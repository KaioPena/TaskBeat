package com.devspace.taskbeats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface TaskDao {
    @Query("Select * From tasksentity")
    fun getAll(): List<TasksEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(taskEntities: List<TasksEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tasksEntity: TasksEntity)

    @Update
    fun update(tasksEntity: TasksEntity)

    @Delete
    fun delete(tasksEntity: TasksEntity)

    @Query("Select * From tasksentity where category is :categoryName")
    fun getAllByCategoryName(categoryName: String): List<TasksEntity>

    @Delete
    fun deleteAll(tasksEntity: List<TasksEntity>)
}