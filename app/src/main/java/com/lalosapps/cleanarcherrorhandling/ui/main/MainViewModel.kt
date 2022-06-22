package com.lalosapps.cleanarcherrorhandling.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lalosapps.cleanarcherrorhandling.core.util.Resource
import com.lalosapps.cleanarcherrorhandling.domain.SubmitEmailUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun submitEmail() {
        viewModelScope.launch {
            val result = submitEmailUseCase(email)
            if (result is Resource.Error) error = result.message
        }
    }
}