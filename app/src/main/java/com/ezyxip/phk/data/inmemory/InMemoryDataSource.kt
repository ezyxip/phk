package com.ezyxip.phk.data.inmemory

import com.ezyxip.phk.data.DataAdapter
import com.ezyxip.phk.ui.models.CoursePresentation
import com.ezyxip.phk.ui.models.LessonPresentation
import java.util.Date

class InMemoryDataSource : DataAdapter {
    val courses: MutableList<Course> = mutableListOf(
        Course("Матанализ"),
        Course("ОРГ"),
        Course("Практика речевой деятельности"),
        Course("Физкультура"),
        Course("Алгоритмизация и программирование")
    )

    val lessons: MutableList<Lesson> = mutableListOf(
        Lesson("Теорема Лагранжа", Date(), courses[0]),
        Lesson("Теорема Роля", Date(), courses[0]),
        Lesson("Взятие производной", Date(), courses[0]),

        Lesson("История России", Date(), courses[1]),
        Lesson("Ископаемые ресурсы", Date(), courses[1]),
        Lesson("Николай Второй", Date(), courses[1]),

        Lesson("Метод Сократа", Date(), courses[2]),

        Lesson("Операторы", Date(), courses[4]),
        Lesson("Алгоритмы", Date(), courses[4]),
        Lesson("Системы сборки", Date(), courses[4]),

    )
    override fun getLastLessonList(count: Int): List<LessonPresentation> {
        return lessons
            .reversed()
            .subList(0, count)
            .map { e -> LessonPresentation(
                id = e.id,
                title = e.title,
                date = e.date.toString(),
                course = e.course.name
            ) }
            .toList()
    }

    override fun getCourseById(id: Int): CoursePresentation {
        return courses
            .filter { e -> e.id == id }
            .map { e -> CoursePresentation(id = e.id, name = e.name) }
            .first()
    }

    override fun getLessonsByCourseId(courseId: Int): List<LessonPresentation> {
        return lessons
            .filter { e -> e.course.id == courseId }
            .map { e -> LessonPresentation(
                id = e.id,
                title = e.title,
                date = e.date.toString(),
                course = e.course.name
            ) }
            .reversed()
    }

    override fun getCourseList(): List<CoursePresentation> {
        return courses
            .map { e -> CoursePresentation(id = e.id, name = e.name) }
            .reversed()
            .toList()
    }

    override fun addNewCourse(): Int {
        courses.add(Course("Новый курс"))

        return courses.lastIndex
    }

    override fun addNewLesson(courseId: Int): Int {
        val course = getCourseEntityById(courseId)
        lessons.add(Lesson(
            title = "Новый конспект",
            date = Date(),
            course = course
        ))

        return lessons.lastIndex
    }

    override fun changeCourseName(courseId: Int, newName: String) {
        val targetCourse = courses.find { e -> e.id == courseId }
        if(targetCourse != null){
            targetCourse.name = newName
        }else{
            throw Exception("Невозможно поменять имя курса, так как такого курса не существует")
        }
    }

    private fun getCourseEntityById(id: Int): Course{
        return courses.first { e -> e.id == id }
    }
}