package com.example.videocardstore2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videocardstore2.data.DataSource
import com.example.videocardstore2.domain.VideoCardInteractor
import com.example.videocardstore2.presentation.recycler.VideoCard

class ChooseMessageViewModel : ViewModel() {
    private val interactor: VideoCardInteractor = DataSource()

    val messages: LiveData<List<VideoCard>> get() = _messages
    private val _messages = MutableLiveData<List<VideoCard>>(interactor.loadMessages())
}