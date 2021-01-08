package project.dungeonApi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import project.dungeonApi.enums.ErrorType


@ResponseStatus(value = HttpStatus.CONFLICT)
class GameException : RuntimeException() {
    var ErrorMessage : String = ""
    var Type : ErrorType = ErrorType.MUR
}