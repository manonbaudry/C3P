package com.dungeon.api.entities

import javax.persistence.*
@Entity
data class Player (
        @Id @GeneratedValue var id: Long,
        var name: String,
        var strength: Int = 10,
        var life: Int = 20
)
