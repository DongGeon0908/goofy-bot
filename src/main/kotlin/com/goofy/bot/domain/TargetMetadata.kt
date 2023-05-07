package com.goofy.bot.domain

import com.fasterxml.jackson.module.kotlin.readValue
import com.goofy.bot.common.extension.mapper
import org.springframework.http.HttpMethod
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "target_metadata")
class TargetMetadata(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1L,

    val title: String,

    val baseUrl: String,

    @Column(name = "request_param")
    val requestParam: String?,

    @Column(name = "http_method")
    @Enumerated(value = EnumType.STRING)
    val httpMethod: HttpMethod = HttpMethod.GET,

    @Column(columnDefinition = "TEXT")
    val note: String? = null
) : BaseEntity() {
    data class RequestParam(
        val key: String,
        val value: String
    )

    fun getRequestParamMap(): Map<String, Any>? {
        if (requestParam == null) {
            return null
        }

        return mapper.readValue(requestParam!!)
    }
}
