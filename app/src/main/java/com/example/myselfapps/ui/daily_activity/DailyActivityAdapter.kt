package com.example.myselfapps.ui.daily_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemDailyActivityBinding

class DailyActivityAdapter() : RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailyActivityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemDailyActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DailyActivityModel) {
            binding.run {
                ivppDialy.setImageResource(item.imageProfile)
                tvNameDialy.text = item.name
                tvUsername.text = item.username
                tvDesc.text = item.caption
                ivImg1.setImageResource(item.image)
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<DailyActivityModel>() {
        override fun areItemsTheSame(
            oldExampleModel: DailyActivityModel, newExampleModel: DailyActivityModel
        ): Boolean {
            return oldExampleModel.caption == newExampleModel.caption
        }

        override fun areContentsTheSame(
            oldExampleModel: DailyActivityModel, newExampleModel: DailyActivityModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

}