package com.k1ch.aqb.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k1ch.aqb.network.QuoteBookApi
import kotlinx.coroutines.launch

class QuoteBookViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getQuoteBook()
    }

    private fun getQuoteBook() {
        viewModelScope.launch {
            try {
                val listResult = QuoteBookApi.retrofitService.getQuote()
                _status.value = listResult
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}