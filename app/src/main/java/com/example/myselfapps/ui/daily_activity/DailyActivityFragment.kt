package com.example.myselfapps.ui.daily_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.AllData
import com.example.myselfapps.R
import com.example.myselfapps.databinding.ActivityMainBinding
import com.example.myselfapps.databinding.FragmentDailyActivityBinding

class DailyActivityFragment : Fragment(R.layout.fragment_daily_activity) {

    private val friendAdapter = FriendAdapter()
    private val dailyActivityAdapter = DailyActivityAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFriend = getView()?.findViewById<RecyclerView>(R.id.rvFriend)
        val rvDailyActivity = getView()?.findViewById<RecyclerView>(R.id.rvDailyActivity)

        rvFriend?.adapter = friendAdapter
        friendAdapter.differ.submitList(AllData.friendList)

        rvDailyActivity?.adapter = dailyActivityAdapter
        dailyActivityAdapter.differ.submitList(AllData.dailyActivityList)

    }
}