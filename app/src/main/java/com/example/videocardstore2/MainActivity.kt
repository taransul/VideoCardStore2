package com.example.videocardstore2

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        initRecycler()
    }

    private fun initRecycler() {
        inputTextActivityMain.setOnClickListener {
            val customBottomSheetDialogFragment =
                CustomBottomSheetDialogFragment.newInstance { modelItem ->
                    inputTextActivityMain.text =
                        Editable.Factory.getInstance().newEditable(modelItem.model)
                }

            customBottomSheetDialogFragment.show(
                supportFragmentManager,
                CustomBottomSheetDialogFragment.TAG
            )
        }
    }
}