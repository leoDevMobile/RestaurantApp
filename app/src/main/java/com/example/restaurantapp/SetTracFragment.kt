package com.example.restaurantapp


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_set_trac.*
import java.text.DateFormat
import java.util.*



class SetTracFragment : Fragment(R.layout.fragment_set_trac) {





    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val c = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance().format(c.time)
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        editTextDate.setText(currentDate)


        btn_date.setOnClickListener {
            val dpd = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                editTextDate.setText("$dayOfMonth/$month/$year")
            }, year, month, day)
            dpd.show()
        }

        btn_time.setOnClickListener {
            val tpd = TimePickerDialog(requireContext(), { _, hour, minute ->
                editTextTime.setText("$hour : $minute")
            }, hour, minute, true)

            tpd.show()
        }

        editTextTime.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                btn_photo.isEnabled = s.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,
                                           after: Int) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })

        //btn_photo.setOnClickListener {
        //  requireActivity().run {
        //    startActivity(Intent(this, CameraActivity::class.java))
        //   finish()
    //}

        }




    }











