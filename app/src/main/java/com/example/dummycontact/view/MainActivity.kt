package com.example.dummycontact.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.dummycontact.adapters.RvAdapter
import com.example.dummycontact.adapters.VpAdapter
import com.example.dummycontact.databinding.ActivityMainBinding
import com.example.dummycontact.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        Init Vm
        val vm by viewModels<MainActivityViewModel>()
//        get Data
        vm.getAllData()
        getUser(vm)
        viewPager(vm)
    }

    fun getUser(vm:MainActivityViewModel) {
        vm.data.observe(this@MainActivity) { item ->
            item.users?.let { users ->
                val adapter = RvAdapter(users)
                binding.rvDummy.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvDummy.adapter = adapter
            }
        }
    }

    fun viewPager(vm:MainActivityViewModel) {
        vm.data.observe(this@MainActivity) {
            item ->
            item.users?.let {
                users ->
                val adapter = VpAdapter(users)
                binding.vpDummy.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                binding.vpDummy.adapter = adapter
            }
        }
    }
}