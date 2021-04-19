package com.example.a1million_android_clone

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a1million_android_clone.R.*
import com.example.a1million_android_clone.R.drawable.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    private lateinit var listAdapter: ScheduleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(layout.fragment_home,container,false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scheduleList = ArrayList<ScheduleItem>()
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))
        scheduleList.add(ScheduleItem(resources.getDrawable(R.drawable.ic_short_cut_schedule,null),"Tina Boo","Master Class", "5:30 PM - 6:50 PM"))

        listAdapter = ScheduleAdapter(scheduleList)
        scheduleRecyclerview.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)

        scheduleRecyclerview.adapter = listAdapter

    }


}