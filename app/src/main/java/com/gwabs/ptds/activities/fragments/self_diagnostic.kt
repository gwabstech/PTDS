package com.gwabs.ptds.activities.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gwabs.ptds.R
import com.gwabs.ptds.databinding.FragmentSelfDiagonosticBinding


class self_diagnostic : Fragment() {
    private var _binding : FragmentSelfDiagonosticBinding? = null
    private val binding get() = _binding
    private var total = 0
    private var counter = 0
    private val section2QuestionList = ArrayList<String>()
    //val questions: Array<String> = resources.getStringArray(R.array.section_2)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelfDiagonosticBinding.inflate(inflater,container,false)
        val view = binding?.root
        val question = activity?.resources?.getStringArray(R.array.section_2)
        if (question != null) {
            addToQuestions(question)
        }
        _binding!!.txtQuestionSection2.text = section2QuestionList.get(counter)

        _binding!!.btnNext.setOnClickListener {

            showDialog(requireContext(),false,getString(R.string.section2Instrictions))
        }

        _binding!!.btnSection2btnNext.setOnClickListener {
            handleSectionB()
        }


        return view
    }


    fun handleSectionB(){

        val selectedOption = _binding?.radioBtnOptions?.checkedRadioButtonId
        when {
            counter > 19 -> {
                if (total > 40){
                    Toast.makeText(requireContext(),"You Have Some issues please see doctor your score is $total",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(),"No issue found your score is $total",Toast.LENGTH_LONG).show()
                }

            }
            else -> {
                _binding!!.txtQuestionSection2.text = section2QuestionList.get(counter)
                when{
                    selectedOption == R.id.rb_zero->{
                        calculateTotal(0)
                    }
                    selectedOption == R.id.rb_one ->{
                        calculateTotal(1)
                    }
                    selectedOption == R.id.rb_two->{
                        calculateTotal(2)
                    }
                    selectedOption == R.id.rb_three ->{
                        calculateTotal(3)
                    }
                    selectedOption == R.id.rb_four ->{
                        calculateTotal(4)
                    }
                }
                counter++
            }
        }



    }

    fun calculateTotal(point : Int){
        total += point
    }


    fun addToQuestions(array: Array<String>){
        for (i in array){
            section2QuestionList.add(i)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


        fun showDialog(context : Context,cancelable: Boolean,message:String, title:String = "Instructions"){
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
                _binding!!.creteria1.visibility = View.GONE
                _binding!!.txtSectionTitle.text = getString(R.string.section_b_title)
                _binding!!.creteria2.visibility = View.VISIBLE
            }


            if (dialog.isShowing)
                dialog.dismiss()

            dialog.show()


        }




}