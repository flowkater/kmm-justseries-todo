package com.justseries.todo.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("completed_at")
    val completedAt: Long?,
)

data class TodoDTO(
    val title: String,
)