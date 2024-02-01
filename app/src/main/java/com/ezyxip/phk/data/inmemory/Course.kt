package com.ezyxip.phk.data.inmemory

data class Course(
    var name: String
){
    val id: Int = lastId++

    companion object{
        private var lastId = 0
    }
}
