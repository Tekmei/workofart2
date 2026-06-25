package com.example.allittakes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.allittakes.viewmodels.LoginViewModel
import com.example.allittakes.R
import com.example.allittakes.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val vm: LoginViewModel by viewModels()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        val binding =
            FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {

            val success =
                vm.login(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )

            if (success) {

                findNavController().navigate(
                    R.id.action_login_to_home
                )

            } else {

                Toast.makeText(
                    requireContext(),
                    "Invalid Login",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}