class CountGeneralEventCommand(private val event: Event) : CountCommand(event) {

    override val counter: Metrics by lazy { GeneralMetrics }

    override suspend fun execute() {
        count()
    }

}