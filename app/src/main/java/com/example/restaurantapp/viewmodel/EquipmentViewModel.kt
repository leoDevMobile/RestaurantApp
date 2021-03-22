package com.example.restaurantapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.restaurantapp.data.EquipmentDatabase
import com.example.restaurantapp.repository.EquipmentRepository
import com.example.restaurantapp.model.Equipment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


@InternalCoroutinesApi
class EquipmentViewModel(application: Application): AndroidViewModel(application) {
 val readAllData: LiveData<List<Equipment>>
    private val repository: EquipmentRepository

    init {

        val equipmentDao = EquipmentDatabase.getDatabase(application).equipmentDao()
        repository = EquipmentRepository(equipmentDao)
        readAllData = repository.readAllData
    }

    fun addEquipment(equipment: Equipment){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEquipment(equipment)
        }
    }

    fun updateEquipment(equipment: Equipment){

        viewModelScope.launch(Dispatchers.IO) {
            repository.updateEquipment(equipment)
        }
    }

    fun deleteEquipment(equipment: Equipment){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteEquipment(equipment)
        }
    }

    fun deleteAllEquipments(){

        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllEquipments()
        }
    }
}