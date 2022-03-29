package com.example.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: Text
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
       and provide the Id that we assigned  */

    }
}