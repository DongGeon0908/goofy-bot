package com.goofy.bot.presentation

import com.goofy.bot.dto.TargetRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/targets")
class TargetRestController {
    @PostMapping
    fun add(@RequestBody target: TargetRequest) {

    }
}
