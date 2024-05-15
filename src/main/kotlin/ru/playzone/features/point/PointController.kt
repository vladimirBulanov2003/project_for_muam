package ru.playzone.features.point

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.playzone.database.points.PointDTO
import ru.playzone.database.points.Points

class PointController(private val call: ApplicationCall) {

    suspend fun addNewPoint() {
        val registerReceiveRemote = call.receive<PointRecieveRemoteModule>()

            try {
                Points.insert(
                    PointDTO(
                        id = registerReceiveRemote.id,
                        latitude = registerReceiveRemote.latitude,
                        longitude = registerReceiveRemote.longitude,

                    )
                )
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Can't add point ${e.localizedMessage}")
            }

        call.respond(PointResponseRemote(text = "Point has been added successfully"))
        }

    suspend fun deletePoint(){
        val registerReceiveRemote = call.receive<PointDeleteRemote>()
        try {
            Points.delete(registerReceiveRemote.id)
            call.respond(PointResponseRemote(text = "Point has been deleted successfully"))
        } catch (e: Exception) {
            call.respond(HttpStatusCode.BadRequest, "Can't delete point ${e.localizedMessage}")
        }

    }



}
