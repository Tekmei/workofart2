package com.example.allittakes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.allittakes.databinding.FragmentHomeBinding
import com.example.allittakes.factory.UserViewModelFactory
import com.example.allittakes.storage.ProfileStorage
import com.example.allittakes.viewmodels.HomeViewModel
import com.example.allittakes.viewmodels.UserViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val userVm: UserViewModel by activityViewModels {

        UserViewModelFactory(
            ProfileStorage(requireContext())
        )
    }




    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {



        val binding =
            FragmentHomeBinding.bind(view)


        binding.btnProfile.setOnClickListener {

            findNavController().navigate(
                R.id.action_home_to_profile
            )
        }
        binding.btnCounter.setOnClickListener {

            findNavController().navigate(
                R.id.action_home_to_counter
            )
        }

        userVm.profile.observe(viewLifecycleOwner) {

            binding.tvName.text = it.name
            binding.tvEmail.text = it.email
        }
    }
}