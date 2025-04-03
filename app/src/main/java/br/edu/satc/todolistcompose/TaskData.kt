package br.edu.satc.todolistcompose

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

@Entity
data class TaskData(

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "task_title")
    val taskTitle: String,

    @ColumnInfo(name = "task_description")
    val taskDescription: String,

    @ColumnInfo(name = "task_complete")
    val taskComplete: Boolean
)

@Dao
interface TaskDao {
    @Query("SELECT * FROM TaskData")
    fun getAll(): List<TaskData>

    @Update
    fun updateAll(vararg tasks: TaskData)

    @Insert
    fun insertAll(vararg tasks: TaskData)

    @Delete
    fun delete(task: TaskData)
}
