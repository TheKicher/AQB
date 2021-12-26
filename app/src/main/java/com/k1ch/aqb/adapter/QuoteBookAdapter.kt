
package com.k1ch.aqb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.k1ch.aqb.databinding.GridViewItemBinding
import com.k1ch.aqb.network.AnimeQuote

class QuoteBookAdapter :
    ListAdapter<AnimeQuote, QuoteBookAdapter.AnimeQuoteViewHolder>(DiffCallback) {

    class AnimeQuoteViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animeQuote: AnimeQuote) {
            binding.anime1 = animeQuote

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AnimeQuote>() {
        override fun areItemsTheSame(oldItem: AnimeQuote, newItem: AnimeQuote): Boolean {
            return oldItem.anime == newItem.anime
        }

        override fun areContentsTheSame(oldItem: AnimeQuote, newItem: AnimeQuote): Boolean {
            return oldItem.character == newItem.character
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeQuoteViewHolder {
        return AnimeQuoteViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: AnimeQuoteViewHolder, position: Int) {
        val animeQuoteBook = getItem(position)
        holder.bind(animeQuoteBook)
    }
}
