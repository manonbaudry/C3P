package com.dungeon.api

import com.dungeon.api.entities.Monster
import com.dungeon.api.entities.Player
import com.dungeon.api.entities.Room
import com.dungeon.api.repositories.MonsterRepository
import com.dungeon.api.repositories.PlayerRepository
import com.dungeon.api.repositories.RoomRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ApiApplication{
    @Bean
    fun init(playerRepository: PlayerRepository, roomRepository: RoomRepository, monsterRepository : MonsterRepository) = CommandLineRunner {
        playerRepository.save(Player( "Jojo"))
        playerRepository.save(Player("Zouzou"))
        playerRepository.save(Player("Gustave"))

        //Create Dungeon rooms
        var hall = Room( "Hall", listOf(), listOf(), "", null, null, null, null)
        roomRepository.save(hall)

        // Create monsters
        var monster1 = Monster( "gégé", 20, 30, "")
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
