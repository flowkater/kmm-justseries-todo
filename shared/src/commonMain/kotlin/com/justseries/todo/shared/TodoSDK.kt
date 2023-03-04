package com.justseries.todo.shared

import com.justseries.todo.shared.db.Database
import com.justseries.todo.shared.db.DatabaseDriverFactory
import com.justseries.todo.shared.entity.Todo
import com.justseries.todo.shared.entity.TodoDTO

class TodoSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getTodos(): List<Todo> {
        return database.getAllTodos()
    }

    @Throws(Exception::class)
    suspend fun addTodo(todoDTO: TodoDTO): List<Todo> {
        database.addTodo(todoDTO)
        return database.getAllTodos()
    }
}