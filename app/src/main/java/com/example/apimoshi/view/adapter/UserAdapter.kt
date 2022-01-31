package com.example.apimoshi.view.adapter

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apimoshi.databinding.FragmentUserBinding
import com.example.apimoshi.network.models.UserModel

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val usersList = mutableListOf<UserModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            FragmentUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(usersList[position])
    }

    override fun getItemCount(): Int {
        return usersList.size
    }



    class UserViewHolder(
        private val binding: FragmentUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserModel) = with(binding) {
            idTv.text = user.id.toString()
            nameTv.text = user.name
            usernameTv.text = user.username
            emailTv.text = user.email
            streetTv.text = user.address.street
            suiteTv.text = user.address.suite
            cityTv.text = user.address.city
            zipcodeTv.text = user.address.zipcode
            latTv.text = user.address.geo.lat
            lonTv.text = user.address.geo.lng
            phoneTv.text = user.phone
            companyNameTv.text = user.company.name
            catchPhraseTv.text = user.company.catchPhrase
            bsTv.text = user.company.bs
        }
    }
}