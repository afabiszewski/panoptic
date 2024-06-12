package command

import domain.Event
import domain.StoreGeneralEventCommand
import infrastructure.EventRepository

abstract class StoreCommand(private val event: Event) : Command {
    companion object {
        const val SAVED = 1
        const val NOT_SAVED = 0

        fun from(event: Event): StoreCommand = StoreGeneralEventCommand(event)
    }

    abstract val repository: EventRepository

    fun save(): Int = repository.save(event)
}
