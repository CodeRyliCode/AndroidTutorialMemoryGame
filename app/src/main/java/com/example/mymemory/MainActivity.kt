package com.example.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView
    /*these are late init vars because they will be set in the onCreate method, not created
    at the time of construction of the Main Activity.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)
        /* in the onCreate, as soon as we've called setContentView, now we can set these newly defined variables
        equal to the corresponding view in the layout and we'll do that by calling a special method, findViewById
       and provide the Id that we assigned  /*

       Every recycler view has 2 core components. One is the adapter and one is the layout manager. The layout manager measures and positions item views. The adapter provides
       a binding for the data set to the views of the RecyclerView.
         */
         */
         rvBoard.adapter = MemoryBoardAdapter(this, 8)
        rvBoard.setHasFixedSize(true) //makes application more efficient
        rvBoard.layoutManager = GridLayoutManager(this, 2)

    }
}