package com.example.a1million_android_clone

import android.os.Parcel
import android.os.Parcelable
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_schedule.view.*

class ScheduleAdapter(private val items: ArrayList<ScheduleItem>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        holder.bind(items[position],position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ScheduleAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_schedule,parent,false)
        return ScheduleAdapter.ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(item: ScheduleItem, position: Int) {
            view.schedule_profile.setImageDrawable(item.profileImage)
            view.schedule_name.text = item.name
            view.schedule_group.text = item.group
            view.schedule_time.text = item.time

        }
    }
}