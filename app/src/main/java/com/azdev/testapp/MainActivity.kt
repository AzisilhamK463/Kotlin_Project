package com.azdev.testapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azdev.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.text1.text = "Hello Programmer"

        // Explicit Intent
        binding.btn1.setOnClickListener{
            val intentDestination = Intent(this@MainActivity, MainActivity2::class.java)
            intentDestination.putExtra(MainActivity2.EXTRA_DATA, Student("Joko", "123456"))
//            startActivity(intentDestination)
            rsltLauncher.launch((intentDestination))
        }

        // Implicit Intent
        binding.btn2.setOnClickListener{
            val number = "1234567"
            val intentcall = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $number"))
            startActivity(intentcall)
        }

        binding.btn3.setOnClickListener{
            val intentRv = Intent(this@MainActivity, MainActivity3::class.java)
            startActivity(intentRv)
        }

        binding.btn4.setOnClickListener{
            val intentRv = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intentRv)
        }
    }
    private val rsltLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->if(result.resultCode==MainActivity2.RESULT_CODE && result.data!=null){
            val name = result.data?.getStringExtra(MainActivity2.EXTRA_RETURN_VALUE)
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
        }
    }
}