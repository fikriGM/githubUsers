package com.mf.hcs.gitappusers.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mf.hcs.gitappusers.databinding.ItemUserBinding
import com.mf.hcs.gitappusers.domain.model.GitHubUser

class UserAdapter : ListAdapter<GitHubUser, UserAdapter.UserViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: GitHubUser) {
            binding.tvUsername.text = user.login
            Glide.with(binding.root).load(user.avatarUrl).into(binding.ivAvatar)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GitHubUser>() {
            override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser) = oldItem == newItem
        }
    }
}