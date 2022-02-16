package com.example.movieapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData

import com.example.movieapp.databinding.FragmentProfileBinding

class ProfileFragment:Fragment(R.layout.fragment_profile) {

//    lateinit var binding: FragmentProfileBinding
    lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ViewModelProfile>()
    private lateinit var takePictureActivityResultLauncher: ActivityResultLauncher<Void>
    private lateinit var takeImageGallery : ActivityResultLauncher<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding = FragmentProfileBinding.bind(view)
        getImageFromGallery()
        createTakePictureIntentActivityResultLauncher()

        viewModel.FillData.observe(this,{
            viewModel.setFillData(it)
        })
        binding.btnRegister.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty()
                &&binding.etEmailText.text.isNotEmpty()&&binding.etUsername.text.isNotEmpty()
                &&binding.etPhoneNumber.text.isNotEmpty()
            ){

                    Toast.makeText(this.context, "DATA Saved", Toast.LENGTH_SHORT).show()
                // do save data
                // action argument true to activity
                viewModel.FillData.value = true
            }else{
                Toast.makeText(this.context, "Fill DATA", Toast.LENGTH_SHORT).show()
            }
        }
        binding.profilePic.setOnClickListener {
            AlertDialog.Builder(this.requireContext())
                .setTitle("Choose")
                .setMessage("Choose Gallery Or Camera")
                .setPositiveButton("Gallery")
                { _,_ ->
                    takeImageGallery.launch("Image/*")
                }
                .setNegativeButton("Camera")
                { _,_ ->
                    takePictureActivityResultLauncher.launch(null)
                }
                .setCancelable(true)
                .show()
        }



    }
    private fun createTakePictureIntentActivityResultLauncher() {
        takePictureActivityResultLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            binding.profilePic.setImageBitmap(it)
        }
    }
    private fun getImageFromGallery(){
        takeImageGallery = registerForActivityResult(ActivityResultContracts.GetContent()){
            binding.profilePic.setImageURI(it)
        }
    }
}
