package com.justseries.todo.shared.db

import com.justseries.todo.shared.entity.Todo
import com.justseries.todo.shared.entity.TodoDTO

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllTodos()
        }
    }

    internal fun getAllTodos(): List<Todo> {
        return dbQuery.selectAllTodos(::mapTodoSelecting).executeAsList()
    }

    private fun mapTodoSelecting(
        id: Long,
        title: String,
        description: String?,
        completedAt: String?,
    ): Todo {
        return Todo(
            id = id.toInt(),
            title = title,
            description = description,
            completedAt = completedAt?.toLong(),
        )
    }

    internal fun addTodo(todoDTO: TodoDTO) {
        dbQuery.transaction {
            insertTodo(todoDTO)
        }
    }

    private fun insertTodo(todoDTO: TodoDTO) {
        dbQuery.insertTodo(
            title = todoDTO.title,
        )
    }
}