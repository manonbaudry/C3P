package project.dungeonApi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import project.dungeonApi.entities.Attaque
import java.util.*

interface AttaqueRepository : JpaRepository<Attaque, UUID> {
}