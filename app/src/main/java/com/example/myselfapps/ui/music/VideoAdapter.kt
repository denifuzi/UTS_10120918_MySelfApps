package com.example.myselfapps.ui.music

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemVideoBinding

/**
 * Tanggal Pengerjaan : 10/06/2023
 * NIM : 10120908
 * Nama : Rizka Ghinna Auliya
 * Kelas : IF-10
 * */

class VideoAdapter() : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVideoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VideoModel) {
            binding.run {
                val uri = Uri.parse(item.video)
                vVideo.setVideoURI(uri)
                tvTitle.text = item.name

                val mController = MediaController(root.context)
                mController.setAnchorView(vVideo)
                mController.setMediaPlayer(vVideo)
                vVideo.setMediaController(mController)
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<VideoModel>() {
        override fun areItemsTheSame(
            oldExampleModel: VideoModel, newExampleModel: VideoModel
        ): Boolean {
            return oldExampleModel.name == newExampleModel.name
        }

        override fun areContentsTheSame(
            oldExampleModel: VideoModel, newExampleModel: VideoModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

}