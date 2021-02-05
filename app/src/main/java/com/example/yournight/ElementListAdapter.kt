package com.its.lezione27maggio

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yournight.DetailPage
import com.example.yournight.ElementList
import com.example.yournight.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_restaurant.view.*
import kotlinx.android.synthetic.main.element_list.view.*
import java.util.*
import kotlin.collections.ArrayList


class ElementListAdapter (
    recipes: ArrayList<ElementList>,
    context: Context
) :
    RecyclerView.Adapter<ElementListAdapter.ViewHolder>() {
    private val mData: ArrayList<ElementList> = recipes
    private val mContext: Context = context
    //private var filteredData: ArrayList<ElementList> = recipes

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

        //holder.itemView.titolo.text = filteredData.get(position).title

        holder.itemView.setOnClickListener(View.OnClickListener {

            val name = mData.get(position).title
            val indirizzo = mData.get(position).indirizzo
            val numero = mData.get(position).numero
            val immagine = mData.get(position).immagine
            val intent = Intent(mContext, DetailPage::class.java)
            intent.putExtra("name", name)
            intent.putExtra("indirizzo", indirizzo)
            intent.putExtra("numero", numero)
            intent.putExtra("immagine", immagine)
            mContext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    /*
    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredData = mData
                } else {
                    val resultList = ArrayList<ElementList>()
                    for (row in mData!!) {
                        if (row.title.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            val restaurant = ElementList(row.title.toString(), row.valutazione.toString(), row.indirizzo.toString(), row.immagine.toString(), "878786")
                            resultList.add(restaurant)
                        }
                    }
                    filteredData = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredData
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredData = results?.values as ArrayList<ElementList>
                notifyDataSetChanged()
            }

        }
    } */

}




