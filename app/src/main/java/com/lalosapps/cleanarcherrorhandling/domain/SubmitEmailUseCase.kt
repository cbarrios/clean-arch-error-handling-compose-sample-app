package com.lalosapps.cleanarcherrorhandling.domain

import com.lalosapps.cleanarcherrorhandling.core.util.Resource
import com.lalosapps.cleanarcherrorhandling.data.MyRepositoryImpl

class SubmitEmailUseCase(private val repository: MyRepository = MyRepositoryImpl()) {

    suspend operator fun invoke(email: String): Resource<Unit> {
        if (!email.contains("@")) {
            return Resource.Error("That is not a valid email")
        }
        return repository.submitEmail(email)
    }
}