package com.azdev.testapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azdev.testapp.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val fragment1 = Blank1Fragment()

        val fragment = mFragmentManager
            .findFragmentByTag(Blank1Fragment::class.java.simpleName)
        if(fragment !is Blank1Fragment){
            mFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment1, Blank1Fragment::class.java.simpleName)
                .commit()
        }
    }
}