package com.data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.db.daos.NoteDao
import com.data.models.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

}