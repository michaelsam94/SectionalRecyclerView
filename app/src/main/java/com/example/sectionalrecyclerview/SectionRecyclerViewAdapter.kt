package com.example.sectionalrecyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView



import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager


class SectionRecyclerViewAdapter(private val sectionModel: List<SectionModel>) : RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionVH {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_section, parent, false)
        return SectionVH(view)
    }

    override fun onBindViewHolder(holder: SectionVH, position: Int) {
        holder.tvSectionName.text = sectionModel[position].sectionName
        holder.rvSectionItems.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = ItemRecyclerViewAdapter(sectionModel[position].sectionItems)
        }
    }

    override fun getItemCount(): Int {
        return sectionModel.size
    }



    inner class SectionVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSectionName: TextView = itemView.findViewById(R.id.tv_section_name)
        val rvSectionItems: RecyclerView = itemView.findViewById(R.id.rv_section_items)
    }




}