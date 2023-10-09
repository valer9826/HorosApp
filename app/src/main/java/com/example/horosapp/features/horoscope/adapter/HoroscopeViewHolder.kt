package com.example.horosapp.features.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horosapp.databinding.ItemHoroscopeBinding
import com.horosapp.domain.horoscope.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun bind(horoscopeInfo: HoroscopeInfo){
        val context = binding.tvHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.image)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)
//        binding.tvHoroscope.setText(horoscopeInfo.name) 
        
    }

}