package com.gwabs.ptds.activities.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gwabs.ptds.R
import com.gwabs.ptds.activities.utils.sendMessage
import com.gwabs.ptds.activities.utils.showNegativeDialog
import com.gwabs.ptds.activities.utils.showPositiveDialog
import com.gwabs.ptds.databinding.FragmentSelfDiagonosticBinding
import kotlin.properties.Delegates


class self_diagnostic : Fragment() {
    private var _binding: FragmentSelfDiagonosticBinding? = null
    private val binding get() = _binding
    private var total = 0
    private var counter by Delegates.notNull<Int>()
    private val section2QuestionList = ArrayList<String>()
    private val scores = ArrayList<Int>()

    lateinit var label1Response: String
    lateinit var label2Response: String
    lateinit var label3Response: String
    var label4Response: String = "Null"
    var label5Response: String = "null"
    lateinit var name: String
    var age = 0
    lateinit var gender: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelfDiagonosticBinding.inflate(inflater, container, false)
        val view = binding?.root
        val question = activity?.resources?.getStringArray(R.array.section_2)
        if (question != null) {
            addToQuestions(question)
        }
        counter = 0
        _binding!!.txtQuestionSection2.text = section2QuestionList.get(counter)

        _binding!!.btnNext.setOnClickListener {

            val label1 = _binding!!.txt1.text.toString()
            val label2 = _binding!!.txt2.text.toString()
            val label3 = _binding!!.txt3.text.toString()
            val label4 = _binding!!.txt4.text.toString()
            val labell5 = _binding!!.txt5.text.toString()




            contactDoctor(label1,label2,label3,label4,labell5)


        }

        _binding!!.btnSection2btnNext.setOnClickListener {
            handleSectionB()
        }
        return view
    }

    fun contactDoctor(
        label1: String,
        label2: String,
        label3: String,
        label4: String,
        label5: String
    ) {

        label1Response = _binding!!.edtLabel1Response.text.toString()
        label2Response = _binding!!.edtLabel2Response.text.toString()


        if (_binding!!.YES.isChecked) {

            label3Response = _binding!!.YES.text.toString()
        } else {
            label3Response = _binding!!.NO.text.toString()
        }

        when(_binding!!.group2.checkedRadioButtonId){
            binding?.g21?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g21.id)
                if (rad != null) {
                    label4Response = rad.text.toString()
                }
            }
            binding?.g22?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g22.id)
                if (rad != null) {
                    label4Response = rad.text.toString()
                }
            }
            binding?.g23?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g23.id)
                if (rad != null) {
                    label4Response = rad.text.toString()
                }
            }
            binding?.g24?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g24.id)
                if (rad != null) {
                    label4Response = rad.text.toString()
                }
            }
            else->{
                Toast.makeText(requireContext(),"NO value",Toast.LENGTH_LONG).show()
            }
        }

        when(_binding!!.group3.checkedRadioButtonId){

            binding?.g31?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g31.id)
                if (rad != null) {
                    label5Response = rad.text.toString()
                }
            }
            binding?.g32?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g32.id)
                if (rad != null) {
                    label5Response = rad.text.toString()
                }
            }
            binding?.g33?.id ->{
                val rad = view?.findViewById<RadioButton>(_binding!!.g33.id)
                if (rad != null) {
                    label5Response = rad.text.toString()
                }
            }
            else->{
                Toast.makeText(requireContext(),"NO value",Toast.LENGTH_LONG).show()
            }
        }


        showPositiveDialog(
            {
                name = "Abubakar"
                gender = "Male"
                age = 26
                sendMessage(
                    requireActivity(),
                    "PATIENT INFORMATION\nHello doctor i want to book appointment with you here are my self diagnostic result... \nName: $name\nGender $gender\nAge: $age\nStatus Percentage $total"+"%"+"\n\nQuestion 1 :\n$label1" +
                            "\nResponse : \n$label1Response \n\nQuestion 2 :\n$label2\nResponse :\n$label2Response\n\nQuestion 3 :\n" +
                            "$label3\nResponse : \n$label3Response\n\nQuestion 4 :\n$label4\nResponse : \n$label4Response\n\nQuestion 5 :\n $label5\nResponse : \n$label5Response",findNavController()
                )
            },requireContext(),
            requireActivity(),
            "Base on the information you provided in the previours sections\n The result  shows $scores which is positive, You can contact doctor for more details"

        )
        


    }


    fun handleSectionB() {

        val selectedOption = _binding?.radioBtnOptions?.checkedRadioButtonId
        when {
            counter >= 19 -> {

                val clusterA = checkCluster(1, 5, 1)
                val clusterB = checkCluster(6, 7, 1)
                val clusterC = checkCluster(2, 14, 2)
                val clusterD = checkCluster(15, 20, 2)


                if (((clusterA && clusterB) || (clusterC && clusterD)) && total >= 31) {
                    showDialog(requireContext(), false, getString(R.string.section_a_instruction))
                } else {

                    showNegativeDialog(requireContext(),requireActivity(),"Nagetive No issue found your score is $scores",findNavController())
                    Toast.makeText(
                        requireContext(),
                        "No issue found your score is $total",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
            else -> {
                _binding!!.txtQuestionSection2.text = section2QuestionList.get(counter)
                when {
                    selectedOption == R.id.rb_zero -> {
                        //
                        scores.add(0)
                        calculateTotal(0)
                    }
                    selectedOption == R.id.rb_one -> {
                        //
                        scores.add(1)
                        calculateTotal(1)
                    }
                    selectedOption == R.id.rb_two -> {
                        //
                        scores.add(2)
                        calculateTotal(2)
                    }
                    selectedOption == R.id.rb_three -> {
                        //
                        scores.add(3)
                        calculateTotal(3)
                    }
                    selectedOption == R.id.rb_four -> {
                        //
                        scores.add(4)
                        calculateTotal(4)
                    }
                }
                counter = counter + 1
            }
        }


    }

    fun calculateTotal(point: Int) {
        total += point
    }


    fun addToQuestions(array: Array<String>) {
        for (i in array) {
            section2QuestionList.add(i)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    fun showDialog(
        context: Context,
        cancelable: Boolean,
        message: String,
        title: String = "Instructions"
    ) {
        val dialog = Dialog(context, R.style.CustomAlertDialog)
        dialog.setCancelable(cancelable)
        dialog.setContentView(R.layout.dialog_custom_view)
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


    fun checkCluster(start: Int, end: Int, check: Int): Boolean {
        var cluster = false


        when {
            start == 1 && end == 5 -> {
                val newArray = ArrayList<Int>()
                try {
                    for (i in 0..4) {
                        if (scores.get(i) >= 2) {
                            newArray.add(scores.get(i))
                        }
                    }
                    Log.i("TAG", newArray.toString())
                    if (newArray.size >= check) {
                        cluster = true
                    }
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                }

            }
            start == 6 && end == 7 -> {
                val newArray = ArrayList<Int>()
                try {
                    for (i in 5..6) {
                        if (scores.get(i) >= 2) {
                            newArray.add(scores.get(i))
                        }
                    }
                    Log.i("TAG", newArray.toString())
                    if (newArray.size >= check) {
                        cluster = true
                    }
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                }


            }
            start == 8 && end == 14 -> {
                val newArray = ArrayList<Int>()
                try {
                    for (i in 7..13) {
                        if (scores.get(i) >= 2) {
                            newArray.add(scores.get(i))
                        }
                    }
                    Log.i("TAG", newArray.toString())
                    if (newArray.size >= check) {
                        cluster = true
                    }
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                }

            }

            start == 15 && end == 20 -> {

                val newArray = ArrayList<Int>()
                try {
                    for (i in 14..19) {
                        if (scores.get(i) >= 2) {
                            newArray.add(scores.get(i))
                        }
                    }
                    Log.i("TAG", newArray.toString())
                    if (newArray.size >= check) {
                        cluster = true
                    }
                } catch (e: java.lang.IndexOutOfBoundsException) {
                    e.printStackTrace()
                }

            }
        }


        /*
        for (item in newList.distinct()) {
            println("${item}  :   ${Collections.frequency(newList, item)}")
        }

         */
        return cluster
    }

}