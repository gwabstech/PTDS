package com.gwabs.ptds.activities.fragments

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
            //

            showDialog(requireContext(),false,getString(R.string.section2Instrictions).toString())
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


    fun showDialog(context : Context, cancelable: Boolean, message:String, title:String = "Instructions"){
        val dialog = Dialog(context, R.style.CustomAlertDialog)
        dialog.setCancelable(cancelable)
        dialog.setContentView(R.layout.dialog_custom_view);
        val txtTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val txtMessage = dialog.findViewById<TextView>(R.id.txtMessage)
        val btnProceed = dialog.findViewById<Button>(R.id.btnProceed)
        txtTitle.text = title
        txtMessage.text = message

        btnProceed.setOnClickListener {
            dialog.dismiss()
        }


        if (dialog.isShowing)
            dialog.dismiss()

        dialog.show()


    }
}