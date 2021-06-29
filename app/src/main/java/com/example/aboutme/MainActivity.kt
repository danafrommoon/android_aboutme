package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityMainBinding

   // lateinit var nicknameEdit:EditText;
    // lateinit var doneButton: Button;
   // lateinit var nicknameText: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

   // nicknameEdit = findViewById(R.id.nickname_edit)
  //  doneButton = findViewById(R.id.done_button)
     //   nicknameText = findViewById(R.id.nickname_text)

       binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View?) {
        binding.apply {
            binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}