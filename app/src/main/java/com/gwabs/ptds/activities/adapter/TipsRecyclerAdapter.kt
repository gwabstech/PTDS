package com.gwabs.ptds.activities.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gwabs.ptds.R
import com.gwabs.ptds.activities.data.models.Tips
import com.gwabs.ptds.activities.utils.showTips

class TipsRecyclerAdapter(
    private val context: Context,
    private val activity: Activity,
   private val tipsList: ArrayList<Tips>,

) : RecyclerView.Adapter<TipsRecyclerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dailytips_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_tipsTitle.text = tipsList[position].tips
        holder.itemView.setOnClickListener {
            showTips(context,activity,tipsList[position].tips)
        }
    }

    override fun getItemCount(): Int {
       return tipsList.size
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txt_tipsTitle = itemView.findViewById<TextView>(R.id.txt_tipsTitle)

    }

}
