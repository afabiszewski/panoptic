package infrastructure

import domain.Event

fun interface Client {
    fun send(event: Event): Int
}