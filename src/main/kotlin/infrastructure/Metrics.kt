package infrastructure

import domain.Event

interface Metrics {
    fun increase(event: Event)
}