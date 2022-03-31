package com.example.mymemory

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymemory.models.BoardSize
import com.example.mymemory.models.MemoryCard
import com.example.mymemory.models.MemoryGame
import com.example.mymemory.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private lateinit var memoryGame: MemoryGame
    private lateinit var adapter: MemoryBoardAdapter
    private var boardSize: BoardSize = BoardSize.EASY
    /*these are late init vars because they will be set in the onCreate method, not created
    at the time of construction of the Main Activity.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        //Now we construct our memory game
        memoryGame = MemoryGame(boardSize)


        /*Each randomized image that we have, this list of images that make up the memory game each of those wil
        correspond with one memory card and we want to create a list of these memory cards. We do this by utilizing
        map function on randomized images and for every element of randomized images we're going to do an operation and
        create a new list. We're going to transform randomized images into a new list. In particular create a new memory
        card object.
         */
        /* in the onCreate, as soon as we've called setContentView, now we can set these newly defined variables
        equal to the corresponding view in the layout and we'll do that by calling a special method, findViewById
       and provide the Id that we assigned  /*

       Every recycler view has 2 core components. One is the adapter and one is the layout manager. The layout manager measures and positions item views. The adapter provides
       a binding for the data set to the views of the RecyclerView.
         */
         */
     adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object : MemoryBoardAdapter.CardClickListener {
                override fun onCardClicked(position: Int) {
                    updateGameWithFlip(position)
                    /*Here is where we add logic for toggling isFaceUp property of this card.*/
                }

            })
        rvBoard.adapter = adapter
            rvBoard.setHasFixedSize(true) //makes application more efficient
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.getWidth())

    }

    private fun updateGameWithFlip(position: Int) {
        //This method is responsible for updating the memory game with an attempted flip
        //at this position. The memory game itself should be responsible for handling what happens in the state of the game
        //when the memory card at this position is flipped.
        memoryGame.flipCard(position)
        /* once we flip the card, we need to tell the recyclerview adapter that the contents of what it's showing has changed
        and so it should update itself. The way you do that is adapter.notifydatasetchain
         */
        adapter.notifyDataSetChanged()
        

    }
}