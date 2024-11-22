package com.example

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

val app: HttpHandler = routes(
    "/ping" bind GET to {
        Response(OK).body("pong")
    },

    "/factorial/{length}" bind GET to { req: Request ->

        Response(OK).body(factorial(        req.path("length") ?: "0"))
    }
)

fun factorial(input: String): String {
    return try {
        val n = input.toInt()
        when {
            n < 0 -> "Please enter a non-negative number"
            n > 20 -> "Maximum value is 20"
            else -> factorial(n).toString()
        }
    } catch (e: NumberFormatException) {
        "Invalid number format"
    }
}

fun factorial(n: Int): Long {

    return if (n <= 1) 1L
    else n * factorial(n - 1)
}

fun main() {
    val printingApp: HttpHandler = PrintRequest().then(app)

    val server = printingApp.asServer(SunHttp(9000)).start()

    println("Server started on " + server.port())
}
