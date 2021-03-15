package com.example.restaurantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_trac.*


class TracFragment : Fragment(R.layout.fragment_trac) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_trac.setOnClickListener {
            val action4 = TracFragmentDirections.actionTracFragmentToSetTracFragment()
            findNavController().navigate(action4)
        }






    }
}


