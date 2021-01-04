package com.its.lezione27maggio

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yournight.ElementList
import com.example.yournight.R
import java.util.*

class ElementListAdapter (
    recipes: ArrayList<ElementList>,
    context: Context
) :
    RecyclerView.Adapter<ElementListAdapter.ViewHolder>() {
    private val mData: ArrayList<ElementList>
    private val mContext: Context

    class ViewHolder(var viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_list, parent, false) as ViewGroup
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val mItem: ElementList = mData[position]
        val titleText = holder.viewGroup.findViewById<TextView>(R.id.titolo)
        titleText.setText(mItem.title)

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    init {
        mData = recipes
        mContext = context
    }
}