import Tracking.Action.COUNT
import Tracking.Action.STORE
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
        STORE,
    }

    fun getActions(): EnumSet<Action> = action
}