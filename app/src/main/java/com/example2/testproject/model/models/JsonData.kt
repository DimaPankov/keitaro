package com.example2.testproject.model.models


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