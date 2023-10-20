package com.example.horosapp.features.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.horosapp.R
import com.example.horosapp.databinding.FragmentHoroscopeBinding
import com.example.horosapp.databinding.FragmentHoroscopeDetailBinding
import com.example.horosapp.domain.model.HoroscopeModel
import com.example.horosapp.domain.model.HoroscopeModel.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HoroscopeDetailFragment : Fragment() {

    private lateinit var binding: FragmentHoroscopeDetailBinding
    private val viewModel: HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoroscopeDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = when(args.type){
            Aries -> "Aries"
            Taurus -> "Tauro"
            Gemini -> "Geminis"
            Cancer -> TODO()
            Leo -> TODO()
            Virgo -> TODO()
            Libra -> TODO()
            Scorpio -> TODO()
            Sagittarius -> TODO()
            Capricorn -> TODO()
            Aquarius -> TODO()
            Pisces -> TODO()
        }
        initUi()
    }

    private fun initUi() {
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{
                    when(it){
                        is HoroscopeDetailUiState.Error -> errorState()
                        HoroscopeDetailUiState.Loading -> loadingState()
                        is HoroscopeDetailUiState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {

    }

    private fun errorState() {

    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

}