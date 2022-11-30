package com.gwabs.ptds.activities.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import com.gwabs.ptds.R


fun showTips(context: Context,activity: Activity,meesage:String){

    val dialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
        .create()
    val view = activity.layoutInflater.inflate(R.layout.tips_dialog_view, null)
    dialog.setContentView(R.layout.tips_dialog_view)
    dialog.setCanceledOnTouchOutside(true)
    val txtText = view.findViewById<TextView>(R.id.txt_dialog_message)
    txtText.text = meesage
    dialog.setView(view)
    dialog.setCanceledOnTouchOutside(true)
    dialog.show()


}

fun sendMessage(activity: Activity,message:String,navController: NavController){
    val PhoneWhatsapp: String = "2349078888373"

    try {
        // Replace with your message.
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$PhoneWhatsapp&text=$message")
        activity.startActivity(intent)


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun showPositiveDialog(context: Context,activity: Activity,meesage:String,status:Boolean){

    // TODO: implement me i should show up to patient if its positive
    val dialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
        .create()
    val view = activity.layoutInflater.inflate(R.layout.positive_dialog, null)
    dialog.setContentView(R.layout.tips_dialog_view)
    dialog.setCanceledOnTouchOutside(true)

    dialog.setView(view)
    dialog.setCanceledOnTouchOutside(true)
    dialog.show()

}

fun showNegativeDialog(context: Context,activity: Activity,meesage:String,status:Boolean,navController: NavController){
    // TODO: implement me i should show up to patient if its negative
    val dialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
        .create()
    val view = activity.layoutInflater.inflate(R.layout.nagative_dialog, null)
    dialog.setContentView(R.layout.nagative_dialog)
    dialog.setCanceledOnTouchOutside(true)
    val daiilyTips = view.findViewById<Button>(R.id.btnDailyHealthTips)
    val home = view.findViewById<Button>(R.id.btnToHome)
    daiilyTips.setOnClickListener {
        navController.navigate(R.id.action_selfD_to_dailyTips)
        dialog.dismiss()
    }
    home.setOnClickListener {
        navController.navigate(R.id.action_selfD_to_homeFragment)
        dialog.dismiss()
    }
    //
    dialog.setView(view)
    dialog.setCanceledOnTouchOutside(true)
    dialog.show()

}