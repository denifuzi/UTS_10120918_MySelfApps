package com.example.myselfapps.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.AllData
import com.example.myselfapps.R
import com.example.myselfapps.alertDialog
import com.example.myselfapps.databinding.FragmentAboutBinding
import com.example.myselfapps.databinding.FragmentViewImageBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryAdapter = GalleryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvGallery = getView()?.findViewById<RecyclerView>(R.id.rvGallery)
        rvGallery?.adapter = galleryAdapter
        galleryAdapter.differ.submitList(AllData.galleryList)

        galleryAdapter.setOnItemClickListener {
            initViewImage(it)
        }

    }

    private fun initViewImage(image: Int) {
        val dialogBinding = FragmentViewImageBinding.inflate(layoutInflater)

        context?.alertDialog(dialogBinding.root, true)?.apply {
            show()
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.apply {
                ivDetail.setImageResource(image)
            }
        }
    }
}