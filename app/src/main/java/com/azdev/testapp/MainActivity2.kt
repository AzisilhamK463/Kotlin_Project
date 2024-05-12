package com.azdev.testapp

import android.content.Intent
import android.os.Bundle
import android.os.Build
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azdev.testapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_RETURN_VALUE = "extra_return_value"
        const val RESULT_CODE = 110
    }

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val student = if(Build.VERSION.SDK_INT>=34){
            intent.getParcelableExtra(EXTRA_DATA, Student::class.java)
        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if(student != null){
            binding.text1.text = student.name
        }

        binding.btnSubmit.setOnClickListener{
            val name = binding.editName.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_RETURN_VALUE, name)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }
}