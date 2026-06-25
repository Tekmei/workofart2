package com.example.allittakes

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.allittakes.viewmodels.CounterViewModel
import android.os.Bundle
import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.allittakes.databinding.FragmentCounterBinding
import com.example.allittakes.factory.HomeViewModelFactory
import com.example.allittakes.factory.UserRepository
import com.example.allittakes.storage.PreferenceManager
import com.example.allittakes.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class CounterFragment : Fragment(R.layout.fragment_counter) {

    private val viewModel: CounterViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding =
            FragmentCounterBinding.bind(view)

        binding.btnAdd.setOnClickListener {
            viewModel.increment()
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                homeModel.userName.collect { name ->
//                    println(name)
//                    binding.tvUserName.text = name
//                }
//            }
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.count.collect { count ->
                    binding.tvCount.text = count.toString()
                }
            }
        }
    }
}