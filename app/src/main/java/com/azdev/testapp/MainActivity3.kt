package com.azdev.testapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azdev.testapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private val listStudent = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.rcView.setHasFixedSize(true)
        binding.rcView.layoutManager = LinearLayoutManager(this)

        listStudent.add(Student("User1", "123451"))
        listStudent.add(Student("User2", "123452"))
        listStudent.add(Student("User3", "123453"))
        listStudent.add(Student("User4", "123454"))
        listStudent.add(Student("User5", "123455"))
        listStudent.add(Student("User6", "123456"))
        listStudent.add(Student("User7", "123457"))

        val studentAdapter = StudentAdapter(listStudent)
        studentAdapter.setOnClickCallBack(object: StudentAdapter.onClickCallBack{
            override fun onItemClicked(data: Student) {
                showAlert(data)
            }
        })
        binding.rcView.adapter = studentAdapter
    }

    private fun showAlert(data:Student){
        Toast.makeText(this,"You Clicked " + data.name, Toast.LENGTH_SHORT).show()
    }
}