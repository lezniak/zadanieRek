package com.example.zadanierek.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanierek.R
import com.example.zadanierek.databinding.UserCardBinding
import com.example.zadanierek.infrastructure.common.Constants
import com.example.zadanierek.infrastructure.model.User


class UserListAdapter(val items: List<User>,val clickAdapterInterface: AdapterInterface): RecyclerView.Adapter<UserListAdapter.UserListAdapterViewHolder>() {
    private var target = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapterViewHolder = UserListAdapterViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.user_card, parent, false
        )
    )

    override fun onBindViewHolder(holder: UserListAdapterViewHolder, position: Int) {
        holder.bind(items[position],clickAdapterInterface)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserListAdapterViewHolder(binding: UserCardBinding): RecyclerView.ViewHolder(binding.root){
        val body  = binding.body
        val name = binding.nameText
        val apiLink =  binding.apiLinkText

        fun bind(item: User, clickAdapterInterface: AdapterInterface){
            name.text = item.nickname
            apiLink.text = if(item.api==1){Constants.apiKey1}else{Constants.apiKey2}

            body.setOnClickListener{
                clickAdapterInterface.onClick(item)
            }
        }
    }
}

interface AdapterInterface{
    fun onClick(item: User)
}