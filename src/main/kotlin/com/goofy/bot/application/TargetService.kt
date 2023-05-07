package com.goofy.bot.application

import com.goofy.bot.common.extension.toJson
import com.goofy.bot.domain.TargetMetadata
import com.goofy.bot.dto.TargetRequest
import com.goofy.bot.dto.TargetResponse
import com.goofy.bot.infrastructure.TargetMetadataRepository
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TargetService(
    private val targetMetadataRepository: TargetMetadataRepository,
    private val targetCallService: TargetCallService
) {
    private val logger = KotlinLogging.logger {}

    @Transactional
    fun add(request: TargetRequest): TargetResponse {
        val urls = request.url.split("?")
        val baseUrl = urls[0]

        val requestParamToString = (if (urls.size > 1) {
            val map = mutableMapOf<String, Any>()
            urls[1].split("&")
                .map {
                    val keyAndValue = it.split("=")
                    map.put(keyAndValue[0], keyAndValue[1])
                }
        } else null)?.toJson()

        val target = TargetMetadata(
            title = request.title,
            baseUrl = baseUrl,
            requestParam = requestParamToString,
            note = request.note
        )

        val savedTarget = targetMetadataRepository.save(target)

        return TargetResponse.from(savedTarget)
    }

    @Transactional
    fun call(id: Long): Map<*, *>? {
        val target = targetMetadataRepository.findByIdOrNull(id)
            ?: throw RuntimeException()

        val requestParam = target.getRequestParamMap()

        return targetCallService.call(
            baseUrl = target.baseUrl,
            requestParam = requestParam
        ).block()
    }
}
