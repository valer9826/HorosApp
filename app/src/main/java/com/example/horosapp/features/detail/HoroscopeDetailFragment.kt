package com.example.horosapp.features.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.horosapp.R
import com.example.horosapp.databinding.FragmentHoroscopeBinding
import com.example.horosapp.databinding.FragmentHoroscopeDetailBinding
import com.example.horosapp.domain.model.HoroscopeModel
import com.example.horosapp.domain.model.HoroscopeModel.*

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
    }

}