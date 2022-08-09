package com.example2.testProject.model.models

import com.example2.testProject.models.Info

data class JsonData(
    val body: String,
    val contentType: String,
    val cookies: Cookies,
    val cookies_ttl: Int,
    val headers: List<String>,
    val info: Info,
    val log: List<String>,
    val status: Int,
    val uniqueness_cookie: String
)