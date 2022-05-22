package com.example.retobasicroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retobasicroom.database.User
import com.example.retobasicroom.databinding.UserCardBinding

class MainAdapter(private val usuarios: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = UserCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size

    class MainHolder (val binding: UserCardBinding): RecyclerView.ViewHolder(binding.root){
        fun render (usuarios: User){
            binding.TextUser.setText(usuarios.user_name)
        }
    }
}