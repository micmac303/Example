package com.example

import org.http4k.contract.*
import org.http4k.contract.openapi.ApiInfo
import org.http4k.contract.openapi.v3.OpenApi3
import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.DebuggingFilters.PrintRequestAndResponse
import org.http4k.format.Jackson
import org.http4k.lens.Path

object ExampleApi {

    private fun ping(): ContractRoute =
        "/ping" meta {
            summary = "ping"
            description = "This is a ping"
            returning(OK to "pong")
        } bindContract Method.GET to { req: Request ->
            Response(OK).body("pong")
        }

    private fun factorial(): ContractRoute =
        "/factorial" / Path.of("length") meta {
            summary = "factorial"
            description = "This is a factorial calculation with input validation"
            returning(
                OK to "The factorial result or error message",
            )
        } bindContract Method.GET to { length: String ->
            { _ -> Response(OK).body(factorial(length)) }
        }


    private val contract = contract {
        renderer = OpenApi3(ApiInfo("My great API", "v1.0"), Jackson)
        descriptionPath = "/openapi.json"

        routes += ping()
        routes += factorial()
    }

    val handler: HttpHandler = PrintRequestAndResponse().then("/api/v1" bind contract)
}
