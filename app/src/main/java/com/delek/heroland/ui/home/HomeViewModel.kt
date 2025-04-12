package com.delek.heroland.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Touch the screen"
    }
    val text: LiveData<String> = _text
}