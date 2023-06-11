package com.example.myselfapps.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myselfapps.R
import com.example.myselfapps.alertDialog
import com.example.myselfapps.databinding.FragmentAboutBinding
import java.net.URLEncoder

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    val whatsapp = "85211555205"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivWhatsapp = getView()?.findViewById<ImageView>(R.id.ivWa)
        val ivGmail = getView()?.findViewById<ImageView>(R.id.ivEmail)
        val ivInstagram = getView()?.findViewById<ImageView>(R.id.ivInst)
        val ivLocation = getView()?.findViewById<ImageView>(R.id.ivLoc)
        val ivAbout = getView()?.findViewById<ImageView>(R.id.ivAbout)

        ivWhatsapp?.setOnClickListener { sendWhatsApp() }
        ivGmail?.setOnClickListener { sendGmail() }
        ivInstagram?.setOnClickListener { openInstagram() }
        ivLocation?.setOnClickListener { openLocation() }
        ivAbout?.setOnClickListener { initAboutApp() }
    }

    private fun initAboutApp() {
        val dialogBinding = FragmentAboutBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {

            }
        }
    }

    private fun sendWhatsApp() {
        try {
            val whatsApp = "https://api.whatsapp.com/send?phone=+62$whatsapp&text="
            val packageManager = context?.packageManager
            val whatsappIntent = Intent(Intent.ACTION_VIEW)
            val url = whatsApp + URLEncoder.encode(
                "Hi",
                "UTF-8"
            )
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.data = Uri.parse(url)
            if (packageManager?.let { whatsappIntent.resolveActivity(it) } != null) {
                startActivity(whatsappIntent)
            }
        } catch (e: java.lang.Exception) {
            Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openInstagram() {
        try {
            val packageManager = context?.packageManager
            val instagramIntent = Intent(Intent.ACTION_VIEW)
            val url = "http://instagram.com/_u/denifuzi"
            val browserUrl = "http://instagram.com/denifuzi"
            instagramIntent.setPackage("com.instagram.android")
            instagramIntent.data = Uri.parse(url)

            if (packageManager?.let { instagramIntent.resolveActivity(it) } != null) {
                startActivity(instagramIntent)
            } else {
                val instagramBrowserIntent = Intent(Intent.ACTION_VIEW)
                instagramBrowserIntent.data = Uri.parse(browserUrl)
                startActivity(instagramBrowserIntent)
            }

        } catch (e: java.lang.Exception) {
            Toast.makeText(context, "Instagram not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendGmail() {
        try {
            val gmail = "fuzideni@gmail.com"
            val packageManager = context?.packageManager
            val gmailIntent = Intent(Intent.ACTION_VIEW)
            gmailIntent.setPackage("com.google.android.gm")
            gmailIntent.putExtra(Intent.EXTRA_EMAIL, gmail)
            gmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Saya dari aplikasi My Self App")
            gmailIntent.putExtra(
                Intent.EXTRA_TEXT,
                "hello. this is a message sent from your self app"
            )
            gmailIntent.data = Uri.parse("mailto:")
            if (packageManager?.let { gmailIntent.resolveActivity(it) } != null) {
                startActivity(gmailIntent)
            }
        } catch (e: java.lang.Exception) {
            Toast.makeText(context, "Gmail not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openLocation() {
        try {
            val instagramBrowserIntent = Intent(Intent.ACTION_VIEW)
            instagramBrowserIntent.data = Uri.parse("https://goo.gl/maps/8enZ8267Z8KwEqut7")
            startActivity(instagramBrowserIntent)

        } catch (e: java.lang.Exception) {
            Toast.makeText(context, "Can't open browser", Toast.LENGTH_SHORT).show()
        }
    }
}
