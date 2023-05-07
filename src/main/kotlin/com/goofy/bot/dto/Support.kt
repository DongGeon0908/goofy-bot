package com.goofy.bot.dto

data class ResponseDto<T>(
    val data: T
)

fun <T> T.wrap() = ResponseDto(this)
