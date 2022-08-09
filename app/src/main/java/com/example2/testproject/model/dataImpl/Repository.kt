package com.example2.testproject.model.dataImpl

import com.example2.testproject.model.RetrofitApi.retrofitService
import com.example2.testproject.model.models.JsonData




object Repository {

    suspend fun getData(): JsonData? {
        try {
            return retrofitService.getData()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}



