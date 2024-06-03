import Tracking.Action.COUNT
import Tracking.Action.STORE

class TrackingService {

    fun processTracking(tracking: Tracking) =
        createCommands(Event.fromTracking(tracking))
            .onEach(CommandProcessor::process)


    private fun createCommands(event: Event): Array<Command> = with(event) {
        actions.map {
            when (it) {
                COUNT -> CountCommand.from(event)
                STORE -> StoreCommand.from(event)
            }
        }.toTypedArray()
    }
}