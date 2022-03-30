package com.example.mymemory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {
    /* a viewholder is an object which provides access to all the views of one recycler view element (one memory card of game) */

    /*We're going to define a constant which is the margin size.*/
    companion object {
        private const val MARGIN_SIZE = 10
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth: Int = parent.width / 2 - (2 * MARGIN_SIZE)
        val cardHeight: Int = parent.height / 4 - (2 * MARGIN_SIZE)
        val cardSideLength: Int = min(cardWidth, cardHeight)
        val view: View = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams: ViewGroup.MarginLayoutParams =
            view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
        /*onCreateViewHolder is responsible for figuring out how to create one view of our recycler view*/
    }

    override fun getItemCount() = numPieces
    // how many elements are in our recycler view and that will be the constructor parameter we passed in, numPieces

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        //onBindViewHolder responsible for taking the data at that position and binding it to that ViewHolder passed in here.
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            //no op

        }
    }
}


