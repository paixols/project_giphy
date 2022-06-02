package com.bf.projectgiphy.app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bf.projectgiphy.adapters.GiphyAdapter
import com.bf.projectgiphy.app.ProjectGiphyApp
import com.bf.projectgiphy.databinding.ActivityMainBinding
import com.bf.projectgiphy.domain.models.Gif
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    private var mGiphyList: ArrayList<Gif> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ProjectGiphyApp)
            .appComponent
            .createGiphyComponent()
            .create()
            .inject(this)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGiphyRecyclerView()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupGiphyRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = GiphyAdapter(mGiphyList)
        binding.recyclerView.adapter = adapter

        viewModel.gifs().observe(this) {
            mGiphyList.addAll(it)
            adapter.notifyDataSetChanged()
        }

        setupPagination()
    }

    private fun setupPagination() {
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                    .let { lastElement ->
                        viewModel.loadGifsWithPagination(20, lastElement + 20)
                    }
            }

        })
    }

}