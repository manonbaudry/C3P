package com.dungeon.api.controllers

import com.dungeon.api.entities.Player
import com.dungeon.api.repositories.PlayerRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/players")
class PlayerController(val repository: PlayerRepository) {
    @CrossOrigin
    @GetMapping
    fun getAll(): MutableList<Player> = repository.findAll()
}