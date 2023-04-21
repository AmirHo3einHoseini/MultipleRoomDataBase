package com.appacount.multipleroomdatabase

import androidx.room.*
import com.appacount.multipleroomdatabase.entities.Director
import com.appacount.multipleroomdatabase.entities.School
import com.appacount.multipleroomdatabase.entities.Student
import com.appacount.multipleroomdatabase.entities.Subject
import com.appacount.multipleroomdatabase.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName ")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName= :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction

    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    suspend fun getStudentOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName= :studentName")
    suspend fun getSubjectOfStudent(studentName: String): List<StudentWithSubjects>
}