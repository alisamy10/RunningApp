package com.example.runningapp.data

import android.content.SharedPreferences
import android.widget.EditText
import com.example.runningapp.common.Constatnt
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

class Shared @Inject constructor(private val sharedPreferences : SharedPreferences ) {



     fun loadFieldsFromSharedPref(etName: TextInputEditText, etWeight:TextInputEditText ) {
        val name = sharedPreferences.getString(Constatnt.KEY_NAME, "")
        val weight = sharedPreferences.getFloat(Constatnt.KEY_WEIGHT, 80f)
        etName.setText(name)
        etWeight.setText(weight.toString())
    }

     fun applyChangesToSharedPref(etName: TextInputEditText, etWeight:TextInputEditText): Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()
        if(nameText.isEmpty() || weightText.isEmpty()) {
            return false
        }
        sharedPreferences.edit()
            .putString(Constatnt.KEY_NAME, nameText)
            .putFloat(Constatnt.KEY_WEIGHT, weightText.toFloat())
            .apply()

        return true
    }

}