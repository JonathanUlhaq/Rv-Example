package com.example.dummycontact.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dummycontact.databinding.ItemListBinding
import com.example.dummycontact.databinding.VpLayoutBinding
import com.example.dummycontact.models.Users

class VpAdapter(val list:List<Users>):RecyclerView.Adapter<VpAdapter.ViewHolder>() {

    inner class ViewHolder(val binding:VpLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = VpLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.gambar.load(this.image)
            }
        }
    }
}