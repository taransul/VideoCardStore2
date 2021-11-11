package com.example.videocardstore2.domain

import com.example.videocardstore2.presentation.recycler.VideoCard

interface VideoCardInteractor {
    fun loadMessages(): List<VideoCard>
}