package com.dungeon.api.repositories

import com.dungeon.api.entities.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository : JpaRepository<Player, Long> {

}