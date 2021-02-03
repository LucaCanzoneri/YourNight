package com.its.lezione27maggio

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.yournight.DetailPage
import com.example.yournight.ElementList
import com.example.yournight.R
import com.squareup.picasso.Picasso
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

        val valutazioneText = holder.viewGroup.findViewById<TextView>(R.id.valutazione)
        valutazioneText.setText(mItem.valutazione)

        val indirizzoText = holder.viewGroup.findViewById<TextView>(R.id.indirizzo)
        indirizzoText.setText(mItem.indirizzo)

        val immagineSrc = holder.viewGroup.findViewById<ImageView>(R.id.immagine)
        Picasso.get().load(mItem.immagine).into(immagineSrc)


        holder.itemView.setOnClickListener(View.OnClickListener {

            val name = mData.get(position).title
            val indirizzo = mData.get(position).indirizzo
            val numero = mData.get(position).numero
            val intent = Intent(mContext, DetailPage::class.java)
            intent.putExtra("name", name)
            intent.putExtra("indirizzo", indirizzo)
            intent.putExtra("numero", numero)
            mContext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    init {
        mData = recipes
        mContext = context
    }
}




