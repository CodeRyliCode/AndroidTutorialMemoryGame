package com.example.mymemory.models

import com.example.mymemory.utils.DEFAULT_ICONS

class MemoryGame (private val boardSize: BoardSize) {


    val cards: List<MemoryCard>
    val numPairsFound = 0

    init {
        val chosenImages : List<Int> = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages : List<Int> = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map{ MemoryCard(it)}
        /* The idea is that we are constructing the list of cards based on the board size. We are
        picking some random images and then based on that creating a memory card data class.
         */
    }

    fun flipCard(position: Int) {
val card: MemoryCard = cards[position]
        card.isFaceUp = !card.isFaceUp
    }
}