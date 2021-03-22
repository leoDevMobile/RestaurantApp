package com.example.restaurantapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Equipment
import com.example.restaurantapp.viewmodel.EquipmentViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class AddFragment : Fragment() {



        @InternalCoroutinesApi
        private lateinit var mEquipmentViewModel: EquipmentViewModel



    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mEquipmentViewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)

        view.btn_add.setOnClickListener {
            insertDatatoDatabase()

        }

        return view
    }



    @InternalCoroutinesApi
    private fun insertDatatoDatabase() {
        val name = TextPersonName.text.toString()
        val equi = TextEquipment.text.toString()
        val date2 = TextDate2.text
        val heure2 = TextTime2.text
        val temp = TextTemp.text

        if(inputCheck(name, equi, date2, heure2, temp)){
            //Create Equipment Object
            val equipment =  Equipment(0, name, equi, Integer.parseInt(date2.toString()), Integer.parseInt(heure2.toString()), Integer.parseInt(temp.toString()))
            //Data to Database
            mEquipmentViewModel.addEquipment(equipment)
            Toast.makeText(requireContext(), "Ajout avec succes", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_setTempFragment)
        }else{
            Toast.makeText(requireContext(), "Remplir les champs", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, equi: String, date2: Editable, heure2: Editable, temp: Editable): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(equi) && date2.isEmpty() && heure2.isEmpty() && temp.isEmpty())
    }

}
