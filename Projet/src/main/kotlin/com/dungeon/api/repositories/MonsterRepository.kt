package com.dungeon.api.repositories

import com.dungeon.api.entities.Monster
import org.springframework.data.jpa.repository.JpaRepository

interface MonsterRepository : JpaRepository<Monster, Long> {
}