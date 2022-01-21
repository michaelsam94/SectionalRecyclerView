package com.example.sectionalrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sectionalrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var items: MutableList<SectionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerData()
        setupRecycleView()
    }

    private fun initRecyclerData(){
        items = mutableListOf()
        for (i in 0..5){
            val sectionItems = mutableListOf<String>()
            for (j in 0..10) {
                sectionItems.add("Section ${i+1} Item ${j+1}")
            }
            items.add(SectionModel("Section ${i+1}",sectionItems))
        }
    }

    private fun setupRecycleView() {
        binding.rvSectionItems.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = SectionRecyclerViewAdapter(items)
        }
    }
}