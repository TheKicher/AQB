package com.k1ch.aqb.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k1ch.aqb.network.AnimeQuote
import com.k1ch.aqb.network.QuoteBookApi
import kotlinx.coroutines.launch

class QuoteBookViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()


    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    private val _quote = MutableLiveData<List<AnimeQuote>>()
    // The external LiveData interface to the property is immutable, so only this class can modify
    val quote: LiveData<List<AnimeQuote>> = _quote

    init {
        getQuoteBook()
    }

    private fun getQuoteBook() {
        viewModelScope.launch {
            try {
                _quote.value = QuoteBookApi.retrofitService.getQuote()
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}