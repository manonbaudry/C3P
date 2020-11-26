package com.dungeon.api.repositories

import com.dungeon.api.entities.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<Room, Long> {
}