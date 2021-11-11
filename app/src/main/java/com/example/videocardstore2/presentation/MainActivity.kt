package com.example.videocardstore2.presentation

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.example.videocardstore2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initRecycler()
    }

    private fun initRecycler() {
        inputTextActivityMain.setOnClickListener {
            val bottomSheetDialogFragment =
                ChooseMessageFragment.newInstance { modelItem ->
                    inputTextActivityMain.text =
                        Editable.Factory.getInstance().newEditable(modelItem.model)
                }

            bottomSheetDialogFragment.show(
                supportFragmentManager,
                ChooseMessageFragment.TAG
            )
        }
    }
}