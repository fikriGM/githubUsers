package com.mf.hcs.gitappusers.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mf.hcs.gitappusers.R
import com.mf.hcs.gitappusers.databinding.ActivityMainBinding
import com.mf.hcs.gitappusers.search.GitHubViewModel
import com.mf.hcs.gitappusers.search.UserAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: GitHubViewModel by viewModels()

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).asGif().load(R.raw.loading_bardual).into(binding.loadingImageView)

        viewModel.getAllUsers()
        setupRecyclerView()
        setupSearchInput()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = UserAdapter { user ->
            val intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra("username", user.login)
            startActivity(intent)
            Log.v("UserDetail", "send intent username: $user.login")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupSearchInput() {
        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            if (query.isNotEmpty()) {
                viewModel.search(query)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.users.observe(this) { users ->
            adapter.submitList(users)
        }

        viewModel.error.observe(this) { errorMsg ->
            errorMsg?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.loadingImageView.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}