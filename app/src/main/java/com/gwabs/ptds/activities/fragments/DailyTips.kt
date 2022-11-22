package com.gwabs.ptds.activities.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gwabs.ptds.R
import com.gwabs.ptds.activities.adapter.TipsRecyclerAdapter
import com.gwabs.ptds.activities.adapter.onclick
import com.gwabs.ptds.activities.data.models.Tips
import com.gwabs.ptds.databinding.FragmentDailyTipsBinding

class DailyTips : Fragment() {

    private var _binding: FragmentDailyTipsBinding? = null
    private val binding get() = _binding
    private val tipsList = ArrayList<Tips>()

    var adapter: TipsRecyclerAdapter? = null
    lateinit var onclick: onclick
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDailyTipsBinding.inflate(inflater, container, false)
        addTipToList()
        _binding!!.tipsRV.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TipsRecyclerAdapter(requireContext(),requireActivity(),tipsList)
        _binding!!.tipsRV.adapter = adapter

        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addTipToList(){
        val tipps = activity?.resources?.getStringArray(R.array.tips)

        if (tipps != null) {
            for (tipp in tipps){
                val tip = Tips(tipp)
                tipsList.add(tip)
            }
        }
    }


}