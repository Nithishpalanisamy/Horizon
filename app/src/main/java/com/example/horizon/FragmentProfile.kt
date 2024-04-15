package com.example.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

@Suppress("DEPRECATION")
class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name : TextView? = view.findViewById(R.id.name)
        val age : TextView? = view.findViewById(R.id.age)
        val mobile : TextView?= view.findViewById(R.id.mobile)
        val email :TextView?=view.findViewById(R.id.email)
        val gender : TextView?=view.findViewById(R.id.gender)
        val location : TextView?=view.findViewById(R.id.location)
        val experience : TextView?=view.findViewById(R.id.experience)
        val qualification : TextView?=view.findViewById(R.id.qualification)
        val skill : TextView? =view.findViewById(R.id.skills)
        val resume :TextView?=view.findViewById(R.id.Resume)
        val args = this.arguments
        val inputname = args?.get("name")
        val inputmobile =args?.get("mobile")
        val inputemail =args?.get("email")
        val inputgender=args?.get("gender")
        val inputlocation=args?.get("location")
        val inputexperience=args?.get("experience")
        val inputqualification=args?.get("qualification")
        val inputskill=args?.get("skills")
        val inputage = args?.get("age")
        val inputresume = args?.get("resume")

        name?.text = inputname?.toString() ?: ""
        age?.text = inputage?.toString() ?:""
        mobile?.text = inputmobile?.toString() ?: ""
        email?.text = inputemail?.toString() ?: ""
        gender?.text = inputgender?.toString() ?: ""
        location?.text = inputlocation?.toString() ?: ""
        experience?.text = inputexperience?.toString() ?: ""
        qualification?.text = inputqualification?.toString() ?: ""
        skill?.text = inputskill?.toString() ?: ""
        resume?.text = inputresume?.toString()?:""



        // Assuming you have a button in your layout with id 'buttonId'
        val button = view.findViewById<Button>(R.id.edit)
        button.setOnClickListener {
            val newFragment = Editprofile()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

}