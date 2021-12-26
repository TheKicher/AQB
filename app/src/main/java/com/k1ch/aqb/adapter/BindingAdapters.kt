
package com.k1ch.aqb.adapter


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.k1ch.aqb.network.AnimeQuote


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<AnimeQuote>?) {
    val adapter = recyclerView.adapter as QuoteBookAdapter
    adapter.submitList(data)
}


