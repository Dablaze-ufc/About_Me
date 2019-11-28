package com.dablaze.aboutme

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.dablaze.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonDone.setOnClickListener { addNickName(it) }

    }

    fun addNickName(view: View) {
        binding.apply {
            textViewNickname.text = nicknameText.text
            invalidateAll()
            nicknameText.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textViewNickname.visibility = View.VISIBLE
        }

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)


    }
}
