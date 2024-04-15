package com.example.horizon


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
class Editprofile:Fragment() {
    companion object {
        private const val PICKFILE_RESULT_CODE = 1
        private const val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2
    }
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
            val age : EditText? = view.findViewById(R.id.age)
            val resume : TextView? = view.findViewById(R.id.resum)
            val mobile : EditText? = view.findViewById(R.id.mobile)
            val email : EditText? =view.findViewById(R.id.email)
            val location : EditText? = view.findViewById(R.id.location)
            val qualification : EditText? =view.findViewById(R.id.qualification)
            val skill : EditText? =view.findViewById(R.id.skills)
            val experience : EditText? =view.findViewById(R.id.experience)
            val radioGroup : RadioGroup? = view.findViewById(R.id.gender)
            val selectedId = radioGroup?.checkedRadioButtonId
            val inputgender = if (selectedId != null) {
                val radioButton : RadioButton? = view.findViewById(selectedId)
                radioButton?.text.toString()
            } else {
                ""
            }
            val inputname =name?.text.toString()
            val inputmobile = mobile?.text.toString()
            val inputemail=email?.text.toString()
            val inputlocation = location?.text.toString()
            val inputexperience = experience?.text.toString()
            val inputqualification = qualification?.text.toString()
            val inputskill = skill?.text.toString()
            val inputresume = resume?.text.toString()
            val inputage = age?.text.toString()

            val bundle = Bundle()
            bundle.putString("name",inputname)
            bundle.putString("age",inputage)
            bundle.putString("mobile",inputmobile)
            bundle.putString("email",inputemail)
            bundle.putString("location",inputlocation)
            bundle.putString("gender",inputgender)
            bundle.putString("experience",inputexperience)
            bundle.putString("qualification",inputqualification)
            bundle.putString("skills",inputskill)
            bundle.putString("resume",inputresume)
            val fragment = FragmentProfile()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,fragment)?.commit()

        }
        val uploadButton: Button? = view.findViewById(R.id.upload)
        uploadButton?.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed; request the permission
                    ActivityCompat.requestPermissions(requireActivity(),
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)

                    // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            } else {
                // Permission has already been granted
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "*/*"
                startActivityForResult(intent, PICKFILE_RESULT_CODE)
            }
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICKFILE_RESULT_CODE && resultCode == Activity.RESULT_OK) {
            val filePath = data?.data //This is the file path
            // You can now use this file path according to your needs

            // Get the file name
            val fileName: String? = filePath?.let { uri ->
                context?.contentResolver?.query(uri, null, null, null, null)?.use { cursor ->
                    val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    cursor.moveToFirst()
                    cursor.getString(nameIndex)
                }
            }

            val resume : TextView? = view?.findViewById(R.id.resum)
            resume?.text = fileName
        }
    }


    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    val intent = Intent(Intent.ACTION_GET_CONTENT)
                    intent.type = "*/*"
                    startActivityForResult(intent, PICKFILE_RESULT_CODE)
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }
}


