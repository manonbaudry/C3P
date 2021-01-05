package project.dungeonApi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You're dead...")
class DeadException : RuntimeException() {
}