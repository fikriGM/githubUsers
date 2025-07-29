package com.mf.hcs.gitappusers.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mf.hcs.gitappusers.R
import com.mf.hcs.gitappusers.databinding.ActivityUserDetailBinding
import com.mf.hcs.gitappusers.search.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityUserDetailBinding
    private val viewModel: GitHubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loadingImageView.visibility = View.VISIBLE
        Glide.with(this).asGif().load(R.raw.loading_bardual).into(binding.loadingImageView)

        val username = intent.getStringExtra("username") ?: return
        viewModel.getUserDetail(username)

        viewModel.userDetail.observe(this) { user ->
            binding.loadingImageView.visibility = View.GONE
            Toast.makeText(this, "Received detail for ${user?.login}", Toast.LENGTH_SHORT).show()
            binding.tvName.text = user.name ?: "-"
            binding.tvUsername.text = user.login
            binding.tvFollowers.text = "${user.followers ?: 0} followers"
            binding.tvFollowing.text = "${user.following ?: 0} following"
            Glide.with(this).load(user.avatarUrl).into(binding.ivAvatar)
        }
    }
}