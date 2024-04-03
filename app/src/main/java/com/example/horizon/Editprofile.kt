package com.example.horizon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
class Editprofile:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //Inflate the layout for this fragment

        return inflater.inflate(R.layout.edit_profile, container, false )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn : Button? = view.findViewById(R.id.save)
        btn?.setOnClickListener {
            val name : EditText? = view.findViewById(R.id.name)
            val mobile : EditText? = view.findViewById(R.id.mobile)
            val email : EditText? =view.findViewById(R.id.email)
            val location : EditText? = view.findViewById(R.id.location)
            val qualification : EditText? =view.findViewById(R.id.qualification)
            val skill : EditText? =view.findViewById(R.id.skills)
            val experience : EditText? =view.findViewById(R.id.experience)
            val radioGroup : RadioGroup? = view.findViewById(R.id.gender)
            val selectedId = radioGroup?.checkedRadioButtonId
            val radioButton : RadioButton? = view.findViewById(selectedId!!)

            val inputgender = radioButton?.text.toString()
            val inputname =name?.text.toString()
            val inputmobile = mobile?.text.toString()
            val inputemail=email?.text.toString()
            val inputlocation = location?.text.toString()
            val inputexperience = experience?.text.toString()
            val inputqualification = qualification?.text.toString()
            val inputskill = skill?.text.toString()


            val bundle = Bundle()
            bundle.putString("name",inputname)
            bundle.putString("mobile",inputmobile)
            bundle.putString("email",inputemail)
            bundle.putString("location",inputlocation)
            bundle.putString("gender",inputgender)
            bundle.putString("experience",inputexperience)
            bundle.putString("qualification",inputqualification)
            bundle.putString("skills",inputskill)
            val fragment = FragmentProfile()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()

        }

    }

}