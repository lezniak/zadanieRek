package com.example.zadanierek.ui.details

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.net.URL
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor():ViewModel() {
    fun getImage(url:String): Deferred<Bitmap>{
        return viewModelScope.async(Dispatchers.IO) {
            val url = URL(url)
            val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            bmp
        }
    }
}