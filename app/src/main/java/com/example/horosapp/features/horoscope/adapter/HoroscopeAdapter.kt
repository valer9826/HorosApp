package com.example.horosapp.features.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.horosapp.R
import com.example.horosapp.databinding.ItemHoroscopeBinding
import com.horosapp.domain.horoscope.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo)-> Unit
    ) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(newHoroscopeList: List<HoroscopeInfo>) {
        val horoscopeListDiff = HoroscopeDiffUtil(horoscopeList, newHoroscopeList)
        val result = DiffUtil.calculateDiff(horoscopeListDiff)
        horoscopeList = newHoroscopeList
        result.dispatchUpdatesTo(this)
//        horoscopeList = newHoroscopeList
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            ItemHoroscopeBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.bind(horoscopeList[position], onItemSelected)
    }

    class HoroscopeDiffUtil(
        private val oldList: List<HoroscopeInfo>,
        private val newList: List<HoroscopeInfo>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}