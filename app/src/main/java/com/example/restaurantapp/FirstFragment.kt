package com.example.restaurantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(R.layout.fragment_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            button_temp.setOnClickListener {
                val action = FirstFragmentDirections.actionFirstFragmentToTempFragment()
                findNavController().navigate(action)
            }
                button_traç.setOnClickListener {
                    val action2 = FirstFragmentDirections.actionFirstFragmentToTracFragment()
                    findNavController().navigate(action2)
                }


    }

}