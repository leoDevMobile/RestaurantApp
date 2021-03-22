package com.example.restaurantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_temp.*
import kotlinx.android.synthetic.main.fragment_trac.*

class TempFragment : Fragment(R.layout.fragment_temp) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_temp.setOnClickListener {
            val action5 = TempFragmentDirections.actionTempFragmentToSetTempFragment()
            findNavController().navigate(action5)
        }






    }
}