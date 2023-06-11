package com.example.myselfapps.ui.music

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.AllData
import com.example.myselfapps.R
import com.example.myselfapps.ui.gallery.GalleryAdapter


class MusicFragment : Fragment(R.layout.fragment_music) {

    private val videoAdapter = VideoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvVideo = getView()?.findViewById<RecyclerView>(R.id.rvVideo)
        rvVideo?.adapter = videoAdapter
        videoAdapter.differ.submitList(AllData.videoList)

    }

}