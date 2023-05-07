package com.goofy.bot.presentation

import com.goofy.bot.application.TargetService
import com.goofy.bot.dto.TargetRequest
import com.goofy.bot.dto.wrap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/targets")
class TargetRestController(
    private val targetService: TargetService
) {
    @PostMapping
    fun add(
        @RequestBody request: TargetRequest
    ) = targetService.add(request).wrap()

    @GetMapping("/{id}")
    fun call(
        @PathVariable id: Long
    ) = targetService.call(id).wrap()
}
