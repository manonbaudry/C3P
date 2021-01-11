package project.dungeonApi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.HashMap

@ControllerAdvice
@RequestMapping(produces = arrayOf("application/json"))
@ResponseBody
class ControllerExceptionHandler {

    @ExceptionHandler(GameException::class)
    fun handleConflict(exception: GameException) : ResponseEntity<Map<String, String?>> {
        val errorInfo: MutableMap<String, String?> = HashMap()
        errorInfo["message"] = exception.message
        errorInfo["type"] = exception.type.name
        val entity = ResponseEntity<Map<String, String?>>(errorInfo, HttpStatus.CONFLICT)
        return entity
    }

    @ExceptionHandler(IdNotFoundException::class)
    fun handleIdNotFound(exception: IdNotFoundException) : ResponseEntity<Map<String, String?>> {
        val errorInfo: MutableMap<String, String?> = HashMap()
        errorInfo["message"] = exception.message
        val entity = ResponseEntity<Map<String, String?>>(errorInfo, HttpStatus.NOT_FOUND)
        return entity
    }

}