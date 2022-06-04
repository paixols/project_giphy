package com.bf.projectgiphy.app.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bf.projectgiphy.R
import com.bf.projectgiphy.adapters.GiphyAdapter
import com.bf.projectgiphy.adapters.OnItemClickedListener
import com.bf.projectgiphy.databinding.FragmentMainBinding
import com.bf.projectgiphy.domain.models.Gif

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: FragmentMainBinding
    private var mGiphyList: ArrayList<Gif> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGiphyRecyclerView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupGiphyRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = GiphyAdapter(mGiphyList, object : OnItemClickedListener {
            override fun onItemClicked(item: Gif) {
                viewModel.selectedGif(gif = item)
                navigateToDetailForItem()
            }
        })
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

    private fun navigateToDetailForItem() {
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
    }

}