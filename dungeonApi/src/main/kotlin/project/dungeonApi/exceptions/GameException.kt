package project.dungeonApi.exceptions

import project.dungeonApi.enums.ErrorType

class GameException : Exception{

    var type: ErrorType

    constructor(message: String?, type : ErrorType) : super(message) {
        this.type = type
    }
}