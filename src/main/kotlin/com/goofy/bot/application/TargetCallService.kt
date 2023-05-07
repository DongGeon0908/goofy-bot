package com.goofy.bot.application

import com.goofy.bot.common.webclient.WebClientFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TargetCallService {
    fun call(
        baseUrl: String,
        requestParam: Map<String, Any>?
    ): Mono<Map<*, *>> {
        return WebClientFactory.generate(baseUrl = baseUrl).get()
            .uri("", requestParam)
            .retrieve()
            .bodyToMono(Map::class.java)
    }
}
