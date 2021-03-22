package com.example.restaurantapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Equipment
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var equipmentList = emptyList<Equipment>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = equipmentList[position]
        holder.itemView.txt_id.text = currentItem.id.toString()
        holder.itemView.txt_name.text = currentItem.user
        holder.itemView.txt_date.text = currentItem.date.toString()
        holder.itemView.txt_hour.text = currentItem.time.toString()
        holder.itemView.txt_temp.text = currentItem.temp.toString()
        holder.itemView.txt_equip.text = currentItem.equipment

        holder.itemView.rowLayout.setOnClickListener {
            val action = SetTempFragmentDirections.actionSetTempFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(equipment: List<Equipment>){
        this.equipmentList = equipment
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
    return equipmentList.size   }
}