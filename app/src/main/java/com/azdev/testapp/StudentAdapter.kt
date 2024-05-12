package com.azdev.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azdev.testapp.R
import com.azdev.testapp.Student
import com.azdev.testapp.databinding.RowStudentBinding

class StudentAdapter(private val listData: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.DataViewHolder>(){
    private lateinit var onClick: onClickCallBack

    fun setOnClickCallBack(data: onClickCallBack){
        this.onClick = data
    }

    class DataViewHolder(val binding: RowStudentBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_student, parent, false)
        return DataViewHolder(RowStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val current = listData[position]
        holder.binding.txtName.text = current.name
        holder.binding.txtNim.text = current.nim

        holder.itemView.setOnClickListener{
            onClick.onItemClicked(current)
        }
    }

    interface onClickCallBack{
        fun onItemClicked(data:Student)
    }
}