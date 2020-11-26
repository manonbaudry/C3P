package com.dungeon.api.controllers

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/")
class GameController {
    @CrossOrigin
    @GetMapping
    fun  welcomePage() : String{
        return "hi"
    }

    @CrossOrigin
    @GetMapping("/start")
    fun startGame(): String {
        return "let's start the game"
    }
}