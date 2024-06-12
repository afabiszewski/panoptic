package domain

import domain.Tracking.Action
import java.time.LocalDateTime
import java.util.EnumSet
import java.util.UUID

class Event(
    val id: UUID,
    val description: String,
    val actions: EnumSet<Action>
) {
    val created: LocalDateTime = LocalDateTime.now()

    companion object {
        fun fromTracking(tracking: Tracking): Event = with(tracking) {
            Event(
                UUID.randomUUID(),
                description,
                getActions()
            )
        }
    }
}