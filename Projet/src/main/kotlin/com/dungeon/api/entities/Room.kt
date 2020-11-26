package com.dungeon.api.entities

import com.dungeon.api.enums.Direction
import javax.persistence.*

@Entity
data class Room{
        @Id
        @GeneratedValue
        var id: Long = 0
        var name: String;
        @OneToMany
        var monster: List<Monster>;
        @OneToMany
        var player: List<Player>;
        var description : String;
        @OneToOne
        var north : Room?;
        @OneToOne
        var south : Room?;
        @OneToOne
        var est : Room?;
        @OneToOne
        var west : Room?;

        constructor(name: String, monster: List<Monster>, player: List<Player>, description: String, north: Room?, south: Room?, est: Room?, west: Room?) {
                this.name = name
                this.monster = monster
                this.player = player
                this.description = description
                this.north = north
                this.south = south
                this.est = est
                this.west = west
        }
}

