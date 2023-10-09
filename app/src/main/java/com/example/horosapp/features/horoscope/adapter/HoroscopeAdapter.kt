package com.example.horosapp.features.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horosapp.R
import com.horosapp.domain.horoscope.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList()) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(horoscopeList: List<HoroscopeInfo>){
        this.horoscopeList = horoscopeList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {

        holder.bind(horoscopeList[position])
    }
}