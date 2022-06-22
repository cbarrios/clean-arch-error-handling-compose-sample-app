package com.lalosapps.cleanarcherrorhandling.domain

import com.lalosapps.cleanarcherrorhandling.core.util.Resource

interface MyRepository {

    suspend fun submitEmail(email: String): Resource<Unit>
}