package com.example.restaurantapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import javax.xml.transform.Source

@Parcelize
@Entity(tableName = "equipment_table")
data class Equipment(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user: String,
    val equipment: String,
    val date: Int,
    val time: Int,
    val temp: Int
): Parcelable