package com.goofy.bot.domain

import com.goofy.bot.domain.enum.TargetType
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

    @Enumerated(EnumType.STRING)
    val type: TargetType,

    @Column(name = "http_method")
    val httpMethod: HttpMethod? = null,

    val target: String,

    val note: String? = null
) : BaseEntity()
