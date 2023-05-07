package com.goofy.bot.dto

import com.goofy.bot.domain.TargetMetadata
import org.springframework.http.HttpMethod

data class TargetResponse(
    val id: Long,
    val title: String,
    val url: String,
    val httpMethod: HttpMethod,
    val note: String?
) {
    companion object {
        fun from(target: TargetMetadata): TargetResponse {
            return TargetResponse(
                id = target.id,
                title = target.title,
                url = target.baseUrl,
                httpMethod = target.httpMethod,
                note = target.note
            )
        }
    }
}
