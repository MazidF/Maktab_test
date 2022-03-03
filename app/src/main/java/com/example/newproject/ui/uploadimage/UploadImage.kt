package com.example.newproject.ui.uploadimage

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.newproject.R
import com.example.newproject.databinding.FragmentUploadimageBinding

class UploadImage: Fragment(R.layout.fragment_uploadimage) {
    lateinit var binding: FragmentUploadimageBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUploadimageBinding.bind(view)

        val getImageFromGallery = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imgProfile.setImageURI(it)
            }
        )

        binding.imgProfile.setOnClickListener {
            getImageFromGallery.launch("image/*")
        }



    }
}