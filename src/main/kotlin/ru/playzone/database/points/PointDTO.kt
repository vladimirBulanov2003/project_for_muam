package ru.playzone.database.points

import kotlinx.serialization.Serializable

@Serializable
class PointDTO(
    val id: String,
    val latitude : Double,
    val longitude : Double,
)
