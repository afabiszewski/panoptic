package infrastructure

import domain.Event

fun interface EventRepository {
    fun save(event: Event): Int
}