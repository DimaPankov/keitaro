package com.example2.testProject.model.dataImpl

import com.example2.testProject.model.models.JsonData
import com.example2.testProject.model.RetrofitApi.retrofitService


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



