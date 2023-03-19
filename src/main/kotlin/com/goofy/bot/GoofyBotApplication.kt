package com.goofy.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GoofyBotApplication

fun main(args: Array<String>) {
    runApplication<GoofyBotApplication>(*args)
}
