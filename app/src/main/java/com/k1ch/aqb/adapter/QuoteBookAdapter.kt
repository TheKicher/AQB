/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.k1ch.aqb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.k1ch.aqb.databinding.GridViewItemBinding
import com.k1ch.aqb.network.AnimeQuote

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class QuoteBookAdapter :
    ListAdapter<AnimeQuote, QuoteBookAdapter.AnimeQuoteViewHolder>(DiffCallback) {

    /**
     * The MarsPhotosViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsPhoto] information.
     */
    class AnimeQuoteViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animeQuote: AnimeQuote) {
            binding.anime1 = animeQuote
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<AnimeQuote>() {
        override fun areItemsTheSame(oldItem: AnimeQuote, newItem: AnimeQuote): Boolean {
            return oldItem.anime == newItem.anime
        }

        override fun areContentsTheSame(oldItem: AnimeQuote, newItem: AnimeQuote): Boolean {
            return oldItem.character == newItem.character
        }

//        override fun areContents2TheSame(oldItem: AnimeQuote, newItem: AnimeQuote): Boolean {
//            return oldItem.quote == newItem.quote
//        }

    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeQuoteViewHolder {
        return AnimeQuoteViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: AnimeQuoteViewHolder, position: Int) {
        val animeQuoteBook = getItem(position)
        holder.bind(animeQuoteBook)
    }
}
