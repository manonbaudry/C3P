package project.dungeonApi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Raté, c'est un mur")
class WallException(message: String) : Exception(message) {
}