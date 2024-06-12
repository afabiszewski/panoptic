package command

import domain.Event
import domain.SendGeneralEventCommand
import infrastructure.Client

abstract class SendCommand(private val event: Event) : Command {
    companion object {
        const val SENT = 1
        const val NOT_SENT = 0

        fun from(event: Event) = SendGeneralEventCommand(event)
    }

    abstract val client: Client

    fun send(): Int = client.send(event)
}
