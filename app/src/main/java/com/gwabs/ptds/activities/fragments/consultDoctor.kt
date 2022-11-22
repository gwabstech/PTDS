package com.gwabs.ptds.activities.fragments

import android.os.Bundle
import com.gwabs.ptds.activities.fragments.consultDoctor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gwabs.ptds.R


class consultDoctor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consult_doctor, container, false)
    }


}