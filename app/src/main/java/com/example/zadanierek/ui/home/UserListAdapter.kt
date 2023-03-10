package com.example.zadanierek.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanierek.R
import com.example.zadanierek.databinding.UserCardBinding
import com.example.zadanierek.infrastructure.common.Constants
import com.example.zadanierek.infrastructure.model.User
import com.squareup.picasso.Picasso


class UserListAdapter(private val items: List<User>, private val clickAdapterInterface: AdapterInterface, private val context: Context): RecyclerView.Adapter<UserListAdapter.UserListAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapterViewHolder = UserListAdapterViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.user_card, parent, false
        )
    )

    override fun onBindViewHolder(holder: UserListAdapterViewHolder, position: Int) {
        holder.bind(items[position],clickAdapterInterface, context = context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserListAdapterViewHolder(binding: UserCardBinding): RecyclerView.ViewHolder(binding.root){
        private val body  = binding.body
        private val name = binding.nameText
        private val apiLink =  binding.apiLinkText
        private val image = binding.avatarImage
        fun bind(item: User, clickAdapterInterface: AdapterInterface,context:Context){
            name.text = item.nickname
            apiLink.text = if(item.api==1){Constants.apiKey1}else{Constants.apiKey2}

            body.setOnClickListener{
                clickAdapterInterface.onClick(item)
            }
            val placeholder = AppCompatResources.getDrawable(context, R.drawable.ic_baseline_insert_emoticon_24)
            if (item.photo!="Brak"){
                Picasso.get().load(item.photo).placeholder(placeholder!!).into(image)
            }else{

                image.setImageDrawable(placeholder)
            }

        }
    }
}

interface AdapterInterface{
    fun onClick(item: User)
}