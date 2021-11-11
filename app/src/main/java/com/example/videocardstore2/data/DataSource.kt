package com.example.videocardstore2.data

import com.example.videocardstore2.domain.VideoCardInteractor
import com.example.videocardstore2.presentation.recycler.VideoCard

class DataSource : VideoCardInteractor {

    private val ListVideoCardModels: List<VideoCard> = listOf(
        VideoCard(model = "NVIDIA 2060"),
        VideoCard(model = "RTX 3011"),
        VideoCard(model = "RTX 3022"),
        VideoCard(model = "RTX 3033"),
        VideoCard(model = "RTX 3044"),
        VideoCard(model = "RTX 3055"),
        VideoCard(model = "RTX 3066"),
        VideoCard(model = "RTX 3077"),
        VideoCard(model = "RTX 3088"),
        VideoCard(model = "RTX 3099"),
        VideoCard(model = "RTX 3000")
    )

    override fun loadMessages(): List<VideoCard> {
        return ListVideoCardModels
    }
}