package com.example.horosapp.features.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horosapp.databinding.ItemHoroscopeBinding
import com.horosapp.domain.horoscope.model.HoroscopeInfo

class HoroscopeViewHolder(private val binding: ItemHoroscopeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.image)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener {
            startRotationAnimation(
                binding.ivHoroscope,
                onItemSelected = { onItemSelected(horoscopeInfo) })
//            onItemSelected.invoke(horoscopeInfo)
        }
//        binding.tvHoroscope.setText(horoscopeInfo.name) 
    }

    private fun startRotationAnimation(view: View, onItemSelected: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {
                onItemSelected.invoke()
            }
            start()
        }
    }

}