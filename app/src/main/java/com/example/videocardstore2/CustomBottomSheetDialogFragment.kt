package com.example.videocardstore2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_modal_bottom_sheet.*

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private val modelAdapter by lazy { ModelAdapter() }
    private val modelList by lazy { ModelList() }

    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"
        fun newInstance(): CustomBottomSheetDialogFragment {
            return CustomBottomSheetDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        modelAdapter.submitList(modelList.modelList)
    }

    private fun initRecycler() {
        recyclerModel.adapter = modelAdapter

        modelAdapter.setOnItemClickListener { model ->
            Toast.makeText(context, model.model, Toast.LENGTH_SHORT).show()

            dismiss()
        }
    }
}