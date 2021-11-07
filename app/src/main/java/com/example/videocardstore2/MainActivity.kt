package com.example.videocardstore2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        editText.setOnClickListener {
            val addPhotoBottomDialogFragment = CustomBottomSheetDialogFragment.newInstance()
            addPhotoBottomDialogFragment.show(
                supportFragmentManager,
                CustomBottomSheetDialogFragment.TAG
            )
        }
    }
}