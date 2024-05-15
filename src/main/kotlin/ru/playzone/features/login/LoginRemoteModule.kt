package ru.playzone.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRecieveRemoteModule(
     var login:String,
     var password:String
)

@Serializable
data class LoginResponseRemote(
    val token: String
)





