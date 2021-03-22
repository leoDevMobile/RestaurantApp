package com.example.restaurantapp.repository

import androidx.lifecycle.LiveData
import com.example.restaurantapp.data.EquipmentDao
import com.example.restaurantapp.model.Equipment

class EquipmentRepository(private val equipmentDao: EquipmentDao) {

    val readAllData: LiveData<List<Equipment>> = equipmentDao.readAllEquipment()

    suspend fun addEquipment(equipment: Equipment){
        equipmentDao.addEquipment(equipment)
    }

    suspend fun updateEquipment(equipment: Equipment){
        equipmentDao.updateEquipment(equipment)
    }

    suspend fun deleteEquipment(equipment: Equipment){
        equipmentDao.deleteEquipment(equipment)
    }

    suspend fun deleteAllEquipments(){
        equipmentDao.deleteAllEquipments()
    }
}