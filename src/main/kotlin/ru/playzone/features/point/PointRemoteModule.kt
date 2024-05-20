package ru.playzone.features.point


import kotlinx.serialization.Serializable

@Serializable
data class PointRecieveRemoteModule(
    val id: String,
    var latitude : Double,
    val longitude : Double
)

@Serializable
data class PointDeleteRemote(
    val id: String
)


@Serializable
data class PointResponseRemote(
    val text: String
)



