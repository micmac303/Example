package com.example

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes

object ExampleApi {

    val routes: HttpHandler = routes(
        "/ping" bind GET to {
            Response(OK).body("pong")
        },

        "/factorial/{length}" bind GET to { req: Request ->

            Response(OK).body(factorial(        req.path("length") ?: "0"))
        }
    )
}