package com.example.mvvm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var viewModel: CounterViewModel
    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        val counterObserver = Observer<Int> { newValue ->
            binding.counter.text = newValue.toString()
        }

        viewModel.counter.observe(viewLifecycleOwner, counterObserver)


        binding.decrease.setOnClickListener { viewModel.decreaseCounter() }
        binding.increase.setOnClickListener { viewModel.increaseCounter() }

        return binding.root
    }

}