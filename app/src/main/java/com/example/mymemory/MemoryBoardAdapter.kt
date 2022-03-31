package com.example.mymemory

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymemory.models.BoardSize
import com.example.mymemory.models.MemoryCard
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cards: List<MemoryCard>
    ) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {
    /* a viewholder is an object which provides access to all the views of one recycler view element (one memory card of game) */

    /*We're going to define a constant which is the margin size.*/
    companion object {
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth: Int = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
        val cardHeight: Int = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
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

    override fun getItemCount() = boardSize.numCards
    // how many elements are in our recycler view and that will be the constructor parameter we passed in, numPieces

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        //onBindViewHolder responsible for taking the data at that position and binding it to that ViewHolder passed in here.
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

        fun bind(position: Int) {
            imageButton.setImageResource(if (cards[position].isFaceUp) cards[position].identifier else R.drawable.ic_launcher_background)
            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position")
            }
        }
    }
}


