package com.example

import org.http4k.server.SunHttp
import org.http4k.server.asServer

fun main() {

    println("Server starting...")
    val server = ExampleApi.handler.asServer(SunHttp(9000)).start()
    println("Server started on " + server.port())
}
