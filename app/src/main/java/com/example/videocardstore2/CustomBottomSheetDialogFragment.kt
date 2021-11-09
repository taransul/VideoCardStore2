package com.example.videocardstore2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_modal_bottom_sheet.*

class CustomBottomSheetDialogFragment(private val listener: (VideoCardModelData) -> Unit) :
    BottomSheetDialogFragment() {

    private val modelAdapter by lazy { ModelAdapter() }

    companion object {

        const val TAG = "CustomBottomSheetDialogFragmentTag"
        fun newInstance(listener: (VideoCardModelData) -> Unit): CustomBottomSheetDialogFragment {
            return CustomBottomSheetDialogFragment(listener)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
    }

    override fun onResume() {
        super.onResume()
        recyclerViewModel.adapter = modelAdapter

        modelAdapter.submitList(DataSource.VideoCardModelList)

        modelAdapter.setOnItemClickListener { chatItem ->
            listener.invoke(chatItem)
            dismiss()
        }
    }
}