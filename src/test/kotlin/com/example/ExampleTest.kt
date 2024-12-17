package com.example

import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExampleTest {

    @Test
    fun `Ping test`() {
        assertEquals(Response(OK).body("pong"), ExampleApi.handler(Request(GET, "/api/v1/ping")))
    }

    @Test
    fun `Factorial test`() {
        assertEquals(Response(OK).body("6"), ExampleApi.handler(Request(GET, "/api/v1/factorial/3")))
    }
}
