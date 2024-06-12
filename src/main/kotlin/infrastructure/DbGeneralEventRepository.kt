package infrastructure

import domain.Event
import java.util.UUID
import kotlin.collections.HashMap

object DbGeneralEventRepository : EventRepository {

    lateinit var map: HashMap<UUID, Event>

    override fun save(event: Event): Int = 1
        //TODO("Not yet implemented")

}