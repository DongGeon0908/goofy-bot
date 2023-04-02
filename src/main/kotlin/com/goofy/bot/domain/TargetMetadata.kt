package com.goofy.bot.domain

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

    val target: String,

    val url: String,

    @Column(name = "http_method")
    @Enumerated(value = EnumType.STRING)
    val httpMethod: HttpMethod,

    @Column(columnDefinition = "TEXT")
    val request: String,

    val note: String? = null
) : BaseEntity()
