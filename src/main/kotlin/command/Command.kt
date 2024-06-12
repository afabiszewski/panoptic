package command

interface Command {
    suspend fun execute()
}