package com.example.videocardstore2.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.videocardstore2.R
import com.example.videocardstore2.presentation.recycler.VideoCard
import com.example.videocardstore2.presentation.recycler.VideoCardAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_modal_bottom_sheet.*

class ChooseMessageFragment(private val listener: (VideoCard) -> Unit) :
    BottomSheetDialogFragment() {
    companion object {
        fun newInstance(listener: (VideoCard) -> Unit) =
            ChooseMessageFragment(listener)

        const val TAG = "TagBottomSheetDialogFragment"
    }

    private val adapter by lazy { VideoCardAdapter() }
    private val viewModel by lazy { ChooseMessageViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.layout_modal_bottom_sheet, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves()
        recyclerViewModel.adapter = adapter

        adapter.setOnItemClickListener { videoCardItem ->
            listener.invoke(videoCardItem)
            dismiss()
        }
    }

    private fun initObserves() {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
        }
    }
}