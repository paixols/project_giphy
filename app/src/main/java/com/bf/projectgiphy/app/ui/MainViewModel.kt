package com.bf.projectgiphy.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bf.projectgiphy.data.models.DataRequest
import com.bf.projectgiphy.domain.models.Data
import com.bf.projectgiphy.domain.models.Gif
import com.bf.projectgiphy.domain.useCases.FetchGifsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val fetchGiphyUseCase: FetchGifsUseCase
) : ViewModel() {

    private var _gifs = MutableLiveData<List<Gif>>().apply {
        value = ArrayList()
    }

    fun gifs(): LiveData<List<Gif>> = _gifs

    private fun defaultDataRequest(): DataRequest = DataRequest(
        query = "Boba Fett",
        limit = 20,
        offset = 0
    )

    init {
        loadGifs()
    }

    private fun loadGifs() {
        viewModelScope.launch {
            val result = fetchGiphyUseCase(defaultDataRequest())
            _gifs.value = result
        }
    }

}