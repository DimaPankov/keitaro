package com.example2.testproject.model.models



data class Info(
    val campaign_id: Int,
    val is_bot: Boolean,
    val landing_id: Any,
    val offer_id: Any,
    val stream_id: Int,
    val sub_id: String,
    val token: Any,
    val type: String,
    val uniqueness: Uniqueness,
    val url: String
)