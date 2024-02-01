package com.ezyxip.phk.data.inmemory

import java.util.Date

data class Lesson (
    var title: String,
    var date: Date,
    var course: Course
){
    val id: Int = lastId++

    companion object{
        private var lastId = 0
    }
}