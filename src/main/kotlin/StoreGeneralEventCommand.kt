class StoreGeneralEventCommand(private val event: Event) : StoreCommand(event) {

    override val repository: EventRepository by lazy { DbGeneralEventRepository }

    override suspend fun execute() {
        when (save()) {
            SAVED -> null
            NOT_SAVED -> null
        }
    }
}