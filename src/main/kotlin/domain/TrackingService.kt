package domain

import domain.Tracking.Action.COUNT
import domain.Tracking.Action.STORE
import command.Command
import command.CommandProcessor
import command.CountCommand
import command.SendCommand
import command.StoreCommand
import domain.Tracking.Action.SEND

class TrackingService {

    fun processTracking(tracking: Tracking) =
        createCommands(Event.fromTracking(tracking))
            .onEach(CommandProcessor::process)


    private fun createCommands(event: Event): Array<Command> = with(event) {
        actions.map {
            when (it) {
                COUNT -> CountCommand.from(event)
                SEND -> SendCommand.from(event)
                STORE -> StoreCommand.from(event)
            }
        }.toTypedArray()
    }
}