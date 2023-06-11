package com.example.myselfapps.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.myselfapps.R
import com.example.myselfapps.alertDialog
import com.example.myselfapps.databinding.FragmentAboutBinding
import com.example.myselfapps.databinding.FragmentCitaBinding
import com.example.myselfapps.databinding.FragmentHobiBinding
import com.example.myselfapps.databinding.FragmentInterestBinding
import com.example.myselfapps.databinding.FragmentMakesBinding
import com.example.myselfapps.databinding.FragmentMikesBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivHobby = getView()?.findViewById<ImageView>(R.id.ivHobi)
        val ivGoals = getView()?.findViewById<ImageView>(R.id.ivCita)
        val ivFood = getView()?.findViewById<ImageView>(R.id.ivMakes)
        val ivDrink = getView()?.findViewById<ImageView>(R.id.ivMikes)
        val ivInterest = getView()?.findViewById<ImageView>(R.id.ivInterest)

        ivHobby?.setOnClickListener { initHobby() }
        ivGoals?.setOnClickListener { initGoals() }
        ivFood?.setOnClickListener { initFood() }
        ivDrink?.setOnClickListener { initDrink() }
        ivInterest?.setOnClickListener { initInterest() }

    }

    private fun initHobby() {
        val dialogBinding = FragmentHobiBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }

    private fun initGoals() {
        val dialogBinding = FragmentCitaBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }

    private fun initFood() {
        val dialogBinding = FragmentMakesBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }

    private fun initDrink() {
        val dialogBinding = FragmentMikesBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }

    private fun initInterest() {
        val dialogBinding = FragmentInterestBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }
}