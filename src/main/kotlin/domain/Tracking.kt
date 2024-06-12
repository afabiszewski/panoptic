package domain

import domain.Tracking.Action.COUNT
import domain.Tracking.Action.STORE
import java.util.EnumSet
import java.util.EnumSet.of

enum class Tracking(
    val description: String,
    private val action: EnumSet<Action>
) {
    AUTHORIZATION("Authorization", of(COUNT, STORE)),
    UPDATED("Updated user", of(COUNT)),
    UNKNOWN("Unknown", of(COUNT));

    enum class Action {
        COUNT,
        SEND,
        STORE,
    }

    fun getActions(): EnumSet<Action> = action
}