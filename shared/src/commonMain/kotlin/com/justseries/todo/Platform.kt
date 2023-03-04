package com.justseries.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform