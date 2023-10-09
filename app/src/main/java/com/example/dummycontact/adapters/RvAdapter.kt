package com.example.dummycontact.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.dummycontact.R
import com.example.dummycontact.databinding.ActivityMainBinding
import com.example.dummycontact.databinding.ItemListBinding
import com.example.dummycontact.models.Users

class RvAdapter(val list: List<Users>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivAvatar.load(this.image) {
                    placeholder(R.drawable.ic_launcher_foreground)
                    transformations(CircleCropTransformation())
                }
                binding.tvNama.setText(this.firstName)
            }
        }
    }

    override fun getItemCount(): Int = list.size

}