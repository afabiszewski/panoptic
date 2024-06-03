import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

object CommandProcessor {
    private const val NUMBER_OF_PROCESSORS: Int = 10

    private val channel = Channel<Command>()
    private val processScope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())
    private val executeScope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())

    init {
        executeScope.launch {
            repeat(NUMBER_OF_PROCESSORS) {
                launchProcessor(channel)
            }
        }
    }

    fun process(command: Command) =
        processScope.launch {
            channel.send(command)
        }

    private suspend fun launchProcessor(channel: ReceiveChannel<Command>) =
        channel.consumeEach {
            it.execute()
        }
}