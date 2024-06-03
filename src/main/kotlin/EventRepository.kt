fun interface EventRepository {
    fun save(event: Event): Int
}