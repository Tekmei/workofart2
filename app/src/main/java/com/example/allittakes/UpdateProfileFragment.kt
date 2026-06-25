package com.example.allittakes


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.allittakes.R
import com.example.allittakes.databinding.FragmentUpdateProfileBinding
import com.example.allittakes.factory.UserViewModelFactory
import com.example.allittakes.storage.ProfileStorage
import com.example.allittakes.viewmodels.UserViewModel

class UpdateProfileFragment :
    Fragment(R.layout.fragment_update_profile) {

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
            FragmentUpdateProfileBinding.bind(view)

        binding.btnSave.setOnClickListener {

            userVm.updateProfile(
                binding.etName.text.toString(),
                binding.etEmail.text.toString()
            )

            Toast.makeText(
                requireContext(),
                "Profile Saved",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigateUp()
        }
    }
}