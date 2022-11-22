package com.gwabs.ptds.activities.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gwabs.ptds.activities.data.models.Tips

class TipsRecyclerAdapter(
    val context: Context,
    val tipsList:ArrayList<Tips>,
    private val onItemClickListener:OnItemClickListener
) : RecyclerView.Adapter<TipsRecyclerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
        onItemClickListener.onItemClick(holder.itemView, position = position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }




}

interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
}