package command

import domain.CountGeneralEventCommand
import domain.Event
import infrastructure.Metrics

abstract class CountCommand(private val event: Event) : Command {
    companion object {
        fun from(event: Event): CountCommand = CountGeneralEventCommand(event)
    }

    abstract val counter: Metrics

    fun count() = counter.increase(event)
}