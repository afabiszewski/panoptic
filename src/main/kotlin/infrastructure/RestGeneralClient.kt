package infrastructure

import domain.Event

object RestGeneralClient : Client{
    override fun send(event: Event): Int {
        TODO()
    }
}