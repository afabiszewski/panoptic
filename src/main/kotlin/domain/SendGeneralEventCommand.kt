package domain

import command.SendCommand
import infrastructure.Client
import infrastructure.RestGeneralClient

class SendGeneralEventCommand(private val event: Event) : SendCommand(event) {

    override val client: Client by lazy { RestGeneralClient }

    override suspend fun execute() {
        when (send()) {
            SENT -> TODO()
            NOT_SENT -> TODO()
        }
    }
}