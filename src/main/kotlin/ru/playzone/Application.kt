package ru.playzone

import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import ru.playzone.features.login.configureLoginRouting
import ru.playzone.features.point.configurePointRouting
import ru.playzone.features.register.configureRegisterRouting
import ru.playzone.plugins.configureRouting
import ru.playzone.plugins.configureSerialization

fun main() {
    Database.connect("jdbc:postgresql://localhost:5432/playzone", driver = "org.postgresql.Driver",  user = "postgres", password = "asassin003")


    embeddedServer(CIO, port = 8080, host = "0.0.0.0"){
        configureSerialization()
        configureLoginRouting()
        configureRegisterRouting()
        configureRouting()
        configurePointRouting()

    }.start(wait = true)

}


