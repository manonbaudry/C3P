package com.dungeon.api.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Monster (
        @Id @GeneratedValue var id: Long,
        var name: String,
        var strength: Int,
        var life: Int,
        var description : String
)