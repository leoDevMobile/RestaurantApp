package com.example.restaurantapp.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantapp.R
import com.example.restaurantapp.viewmodel.EquipmentViewModel
import kotlinx.android.synthetic.main.fragment_set_temp.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class SetTempFragment : Fragment() {


    @InternalCoroutinesApi
    private lateinit var mEquipmentViewModel: EquipmentViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_set_temp, container, false)

        //Recyclerview
        val adapter = ListAdapter()
       val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //EquipmentViewModel
        mEquipmentViewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)
        mEquipmentViewModel.readAllData.observe(viewLifecycleOwner, Observer { equipment ->
            adapter.setData(equipment)
        })


        view.floatingActionButtonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_setTempFragment_to_addFragment)
        }

        //Add menu
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    @InternalCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteAllEquipments()
        }
        return super.onOptionsItemSelected(item)
    }

    @InternalCoroutinesApi
    private fun deleteAllEquipments() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui") {_, _ ->
            mEquipmentViewModel.deleteAllEquipments()
            Toast.makeText(
                requireContext(),
                " Listes supprimer avec succès",
                Toast.LENGTH_SHORT).show()

        }
        builder.setNegativeButton("Non") {_, _ -> }
        builder.setTitle("Tout supprimer ?")
        builder.setMessage("Etes vous sure de vouloir tout supprimer ")
        builder.create().show()
    }
}
