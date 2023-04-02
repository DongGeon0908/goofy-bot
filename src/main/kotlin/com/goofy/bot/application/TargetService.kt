package com.goofy.bot.application

import com.goofy.bot.dto.TargetRequest
import com.goofy.bot.infrastructure.TargetMetadataRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TargetService(
    private val targetMetadataRepository: TargetMetadataRepository
) {
    @Transactional
    fun add(request: TargetRequest) {

    }
}
