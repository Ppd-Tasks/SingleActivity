package com.example.singleactivity.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.singleactivity.R
import com.example.singleactivity.adapter.HomeTwoAdapter
import com.example.singleactivity.databinding.FragmentHomeBinding
import com.example.singleactivity.helper.SpaceItemDecoration
import com.example.singleactivity.model.ResponseItem
import com.example.singleactivity.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var photos = ArrayList<ResponseItem>()
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {

        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val decoration = SpaceItemDecoration(10)
        binding.recyclerView.addItemDecoration(decoration)

        apiPosterListRetrofit()
    }

    private fun apiPosterListRetrofit() {
        RetrofitHttp.posterService.listPhotosForYou().enqueue(object :
            Callback<ArrayList<ResponseItem>> {
            override fun onResponse(
                call: Call<ArrayList<ResponseItem>>,
                response: Response<ArrayList<ResponseItem>>
            ) {
                Log.d("@@@", response.body().toString())
                photos.clear()
                photos.addAll(response.body()!!)
                refreshAdapter(photos)
            }

            override fun onFailure(call: Call<ArrayList<ResponseItem>>, t: Throwable) {
                Log.d("@@@", t.message.toString())
            }

        })
    }

    fun refreshAdapter(photos: ArrayList<ResponseItem>) {
        val homeTwoAdapter = HomeTwoAdapter(photos)
        binding.recyclerView.adapter = homeTwoAdapter
    }

}