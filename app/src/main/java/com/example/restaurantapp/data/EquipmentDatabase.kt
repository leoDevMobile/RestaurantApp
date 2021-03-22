package com.example.restaurantapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.restaurantapp.model.Equipment


@Database(entities = [Equipment::class], version = 1, exportSchema = false )
abstract class EquipmentDatabase:RoomDatabase() {

    abstract fun equipmentDao(): EquipmentDao

    companion object{
        @Volatile
        private var INSTANCE: EquipmentDatabase? = null


        fun getDatabase(context: Context): EquipmentDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized( this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EquipmentDatabase::class.java,
                    "equipment_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}