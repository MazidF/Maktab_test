package com.example.newproject.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newproject.R
import com.example.newproject.databinding.FragmentHomeBinding
import com.example.newproject.model.User

class FragmentHome : Fragment(R.layout.fragment_home) {
    val list = listOf("Movie", "Game", "Sport")
    val model: ViewModelHome by viewModels()
    lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        init()
    }

    private fun init() {
        with(binding) {
            homeBtn.setOnClickListener {
                val user = User(
                    homeName.text.toString(),
                    listOf("Movie", "Sport"),
                    homeFamily.text.toString(),
                    homeNationalCode.text.toString()
                )
                model.createUser(user)
            }
        }
    }
}
