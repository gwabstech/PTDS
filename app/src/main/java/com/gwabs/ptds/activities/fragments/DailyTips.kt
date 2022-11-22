package com.gwabs.ptds.activities.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gwabs.ptds.databinding.FragmentDailyTipsBinding

class DailyTips : Fragment() {

    private var _binding: FragmentDailyTipsBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDailyTipsBinding.inflate(inflater, container, false)


        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}