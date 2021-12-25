package com.k1ch.aqb.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.k1ch.aqb.R
import com.k1ch.aqb.adapter.QuoteBookViewModel
import com.k1ch.aqb.databinding.FragmentQuoteBookBinding


class QuoteBookFragment : Fragment() {

    private val viewModel: QuoteBookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuoteBookBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root

    }
}