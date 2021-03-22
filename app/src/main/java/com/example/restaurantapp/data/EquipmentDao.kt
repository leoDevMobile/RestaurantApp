package com.example.restaurantapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.restaurantapp.model.Equipment


@Dao
interface EquipmentDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addEquipment(equipment: Equipment)

   @Update
   suspend fun updateEquipment(equipment: Equipment)

   @Delete
   suspend fun deleteEquipment(equipment: Equipment)


@Query("DELETE FROM equipment_table")
suspend fun deleteAllEquipments()

   @Query("SELECT * FROM equipment_table ORDER BY id ASC")
   fun readAllEquipment(): LiveData<List<Equipment>>
}