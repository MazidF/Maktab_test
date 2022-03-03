package com.example.newproject.ui.users

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newproject.R
import com.example.newproject.databinding.UserFragmentBinding

class UserFragment:Fragment(R.layout.user_fragment) {

    lateinit var binding:UserFragmentBinding

    private val viewModel: UserViewModel by activityViewModels()

    private var listUsers = mutableListOf<String>()

    private lateinit var recyclerAdaptor:RecyclerAdaptor
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UserFragmentBinding.bind(view)
        var recyclerView = binding.rc

        viewModel.getUsersFromServer()

        viewModel._listUsers.observe(viewLifecycleOwner){
            listUsers.clear()
            listUsers.addAll(it)
            recyclerAdaptor.notifyDataSetChanged()
        }

        recyclerAdaptor = RecyclerAdaptor(listUsers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recyclerAdaptor


    }
}