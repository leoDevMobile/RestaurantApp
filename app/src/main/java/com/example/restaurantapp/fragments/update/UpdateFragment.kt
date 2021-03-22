package com.example.restaurantapp.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.restaurantapp.R
import com.example.restaurantapp.model.Equipment
import com.example.restaurantapp.viewmodel.EquipmentViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class UpdateFragment : Fragment() {


    private val args by navArgs<UpdateFragmentArgs>()

    @InternalCoroutinesApi
    private lateinit var mEquipmentViewModel: EquipmentViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mEquipmentViewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)

        view.UpdateTextPersonName.setText(args.currentEquipment.user)
        view.UpdateTextEquipment.setText(args.currentEquipment.equipment)
        view.UpdateTextDate2.setText(args.currentEquipment.date.toString())
        view.UpdateTextTime2.setText(args.currentEquipment.time.toString())
        view.UpdateTextTemp.setText(args.currentEquipment.temp.toString())

        view.update_btn_add.setOnClickListener {
        updateItem()

        }
        // Add menu
        setHasOptionsMenu(true)

        return view
    }


    @InternalCoroutinesApi
    private fun updateItem(){

        val name = UpdateTextPersonName.text.toString()
        val equi = UpdateTextEquipment.text.toString()
        val date2 = Integer.parseInt(UpdateTextDate2.text.toString())
        val heure2 = Integer.parseInt(UpdateTextTime2.text.toString())
        val temp = Integer.parseInt(UpdateTextTemp.text.toString())

        if (inputCheck(name, equi, UpdateTextDate2.text, UpdateTextTime2.text, UpdateTextTemp.text)){
            // create equipment object
            val updateEquipment = Equipment(args.currentEquipment.id, name, equi, date2, heure2, temp)
            //Update Current Equipment
            mEquipmentViewModel.updateEquipment(updateEquipment)
            Toast.makeText(requireContext(),"Mise a jour reussi!", Toast.LENGTH_SHORT).show()
            //navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_setTempFragment)
        }else{
            Toast.makeText(requireContext(),"Remplir les champs SVP!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(name: String, equi: String, date2: Editable, heure2: Editable, temp: Editable): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(equi) && date2.isEmpty() && heure2.isEmpty() && temp.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    @InternalCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteEquipment()
        }
        return super.onOptionsItemSelected(item)
    }

    @InternalCoroutinesApi
    private fun deleteEquipment() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui") {_, _ ->
        mEquipmentViewModel.deleteEquipment(args.currentEquipment)
            Toast.makeText(
                requireContext(),
                "${args.currentEquipment.user}  Supprimer avec succès",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_setTempFragment)
        }
        builder.setNegativeButton("Non") {_, _ -> }
        builder.setTitle("Supprimer ${args.currentEquipment.user}?")
        builder.setMessage("Etes vous sure de vouloir supprimer ${args.currentEquipment.user}")
        builder.create().show()

    }

}