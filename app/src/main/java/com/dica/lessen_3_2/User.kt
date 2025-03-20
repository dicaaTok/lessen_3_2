package com.dica.lessen_3_2

import java.io.Serializable

data class User(
    val name : String ="",
    val email : String= "",
    val password : String =""
) : Serializable