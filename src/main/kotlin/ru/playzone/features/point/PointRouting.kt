package ru.playzone.features.point

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configurePointRouting() {

    routing {
        post("/add_point") {
            val addPointController = PointController(call)
            addPointController.addNewPoint()
        }
        post("/delete_point") {
            val deletePointController = PointController(call)
            deletePointController.deletePoint()
        }

        get("/show_points"){
            val showPointsController = PointController(call)
            showPointsController.showPoint()

        }

    }
}