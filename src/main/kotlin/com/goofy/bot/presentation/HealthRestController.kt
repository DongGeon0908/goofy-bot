package com.goofy.bot.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health-check")
class HealthRestController {
    @GetMapping
    fun check(): String {
        return "health good"
    }
}
