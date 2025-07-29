package com.mf.hcs.gitappusers.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mf.hcs.gitappusers.domain.model.GitHubUser
import com.mf.hcs.gitappusers.domain.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val repository: GitHubRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<GitHubUser>>()
    val users: LiveData<List<GitHubUser>> = _users

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _userDetail = MutableLiveData<GitHubUser>()
    val userDetail: LiveData<GitHubUser> = _userDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun search(query: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = repository.searchUsers(query)
                _users.value = result.items
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getAllUsers() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = repository.getUsers()
                _users.value = result
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getUserDetail(username: String) {
        viewModelScope.launch {
            try {
                val response = repository.getUserDetail(username)
                _userDetail.value = response
                Log.v("getUsers", "Users details: $response")
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("GitHubViewModel", "Error fetching user detail", e)
            }
        }
    }
}