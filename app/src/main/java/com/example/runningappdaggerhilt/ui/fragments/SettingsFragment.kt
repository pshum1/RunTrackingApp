package com.example.runningappdaggerhilt.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.runningappdaggerhilt.R
import com.example.runningappdaggerhilt.other.Constants.KEY_NAME
import com.example.runningappdaggerhilt.other.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    @Inject
    lateinit var sharedPref: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPref()
        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if(success) {
                Snackbar.make(view, "Changes Saved", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(view, "Please fill out all fields", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadFieldsFromSharedPref() {
        val name = sharedPref.getString(KEY_NAME, "")
        val weight = sharedPref.getFloat(KEY_WEIGHT, 80f)
        etName.setText(name)
        etWeight.setText(weight.toString())
    }

    private fun applyChangesToSharedPref() : Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()

        if(nameText.isEmpty() || weightText.isEmpty())
            return false

        sharedPref.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weightText.toFloat())
            .apply()

        val toolbarText = "Let's go, $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

}