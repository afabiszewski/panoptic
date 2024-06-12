package domain

import command.StoreCommand
import infrastructure.DbGeneralEventRepository
import infrastructure.EventRepository

class StoreGeneralEventCommand(private val event: Event) : StoreCommand(event) {

    override val repository: EventRepository by lazy { DbGeneralEventRepository }

    override suspend fun execute() {
        when (save()) {
            SAVED -> TODO()
            NOT_SAVED -> TODO()
        }
    }
}