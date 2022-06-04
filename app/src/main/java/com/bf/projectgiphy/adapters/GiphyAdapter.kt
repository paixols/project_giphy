package com.bf.projectgiphy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bf.projectgiphy.databinding.CardGifBinding
import com.bf.projectgiphy.domain.models.Gif

class GiphyAdapter(
    private val giphyList: ArrayList<Gif>,
    private val listener: OnItemClickedListener
) : RecyclerView.Adapter<GiphyAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: CardGifBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gif: Gif?) {
            binding.gif = gif
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: CardGifBinding = CardGifBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(giphyList[position])
        holder.itemView.setOnClickListener { listener.onItemClicked(giphyList[position]) }
    }

    override fun getItemCount(): Int {
        return giphyList.size
    }

}