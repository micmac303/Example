package com.example

import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.server.SunHttp
import org.http4k.server.asServer

val app: HttpHandler = ExampleApi.routes

fun main() {

    println("Server starting...")
    val server = PrintRequest().then(app).asServer(SunHttp(9000)).start()
    println("Server started on " + server.port())
}
