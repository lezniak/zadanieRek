package com.example.zadanierek.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.scale
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.zadanierek.databinding.FragmentDetailsBinding
import com.example.zadanierek.infrastructure.common.Constants
import com.example.zadanierek.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragment :  Fragment() {
    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding : FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    private fun bindData() {
        CoroutineScope(Dispatchers.Main).launch {
            val linkToPhoto = args.user.photo
            if (linkToPhoto != "Brak"){
//                val img = viewModel.getImage(linkToPhoto).await()
//                binding.imageView.setImageBitmap(img)
                Picasso.get().load(linkToPhoto).into(binding.imageView);
            }

            binding.apiLinkText.apply {
                text = if(args.user.api==1){
                    Constants.apiKey1}else{
                    Constants.apiKey2}
                visibility = View.VISIBLE
            }

            binding.nicknameText.apply {
                text =  args.user.nickname
                visibility = View.VISIBLE
            }

            binding.simpleProgressBar.visibility = View.GONE
        }
    }
}