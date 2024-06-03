abstract class StoreCommand(private val event: Event) : Command {
    companion object {
        const val SAVED: Int = 1
        const val NOT_SAVED: Int = 0

        fun from(event: Event): StoreCommand = StoreGeneralEventCommand(event)
    }

    abstract val repository: EventRepository

    fun save(): Int = repository.save(event)
}
