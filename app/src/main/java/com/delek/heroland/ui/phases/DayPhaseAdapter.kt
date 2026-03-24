package com.delek.heroland.ui.phases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.DayPhase

class DayPhaseAdapter(
    private var dayPhaseList: List<DayPhase> = emptyList(),
    private var onItemSelected: (DayPhase) -> Unit
) : RecyclerView.Adapter<DayPhaseViewHolder>() {

    companion object {
        var selected = -1
    }

    //@SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<DayPhase>) {
        dayPhaseList = list
        //notifyDataSetChanged()
        notifyItemChanged(selected)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayPhaseViewHolder {
        return DayPhaseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_phase, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DayPhaseViewHolder, position: Int) {
        holder.render(dayPhaseList[position], onItemSelected)
    }

    override fun getItemCount(): Int = dayPhaseList.count()


    /*    @SuppressLint("NotifyDataSetChanged")
        fun setData(data: List<DayPhase>) {
            dayPhaseList.run {
                clear()
                addAll(data)
                notifyDataSetChanged()
            }
        }*/

}