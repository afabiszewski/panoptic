import java.util.UUID

object DbGeneralEventRepository : EventRepository{

    lateinit var map: HashMap<UUID, Event>

    override fun save(event: Event): Int {
        TODO("Not yet implemented")
    }
}