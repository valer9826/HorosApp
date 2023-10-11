package com.example.horosapp.features.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horosapp.databinding.FragmentHoroscopeBinding
import com.example.horosapp.features.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private var _binding: FragmentHoroscopeBinding? = null
    val binding get() = _binding
    private val viewModel: HoroscopeViewModel by viewModels()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHoroscopeBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter()
        binding?.rvHoroscope?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = horoscopeAdapter
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
//            viewModel.horoscope.flowWithLifecycle(viewLifecycleOwner.lifecycle).collect() {
//
//            }
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }


}