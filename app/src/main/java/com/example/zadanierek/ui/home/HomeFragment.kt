package com.example.zadanierek.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zadanierek.databinding.FragmentMainBinding
import com.example.zadanierek.infrastructure.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),AdapterInterface {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allUsersFromDb.observe(viewLifecycleOwner){
            setupRecycleView(it)
        }
    }

    private fun setupRecycleView(list: List<User>) {
        binding.recycleView.adapter = UserListAdapter(list,this, requireContext())
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onClick(item: User) {
        findNavController().navigate(HomeFragmentDirections.actionMainFragment2ToDetailsFragment(item))
    }
}