package com.example.movies

import androidx.lifecycle.ViewModel
import com.example.movies.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val repository: ApiRepository):ViewModel() {
}