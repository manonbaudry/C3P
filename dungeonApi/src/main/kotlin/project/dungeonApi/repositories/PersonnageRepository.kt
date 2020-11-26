package project.dungeonApi.repositories

import org.hibernate.id.GUIDGenerator
import org.springframework.data.jpa.repository.JpaRepository
import project.dungeonApi.entities.Personnage
import java.util.*

interface PersonnageRepository : JpaRepository<Personnage, UUID> {
}