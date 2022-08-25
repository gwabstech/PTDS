package com.gwabs.ptds.activities.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gwabs.ptds.R
import com.gwabs.ptds.databinding.FragmentHomeBinding

class Home : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding  get() = _homeBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _homeBinding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = homeBinding.root

        _homeBinding!!.marqueTxt.isSelected = true
        _homeBinding!!.selfDiagonostic.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_selfD)
        }
        _homeBinding!!.dailyTips.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_dailyTips)
        }
        _homeBinding!!.exerciseNRoutine.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_excersice_Routing)
        }
        _homeBinding!!.contactDoctor.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_contact_Doctor)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _homeBinding = null
    }
}