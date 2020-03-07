package com.example.rockpaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), CallBack {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val suit = mutableListOf("Batu", "Gunting", "Kertas")
        val idList = mutableListOf(batu1, kertas1, gunting1)
        var player1 = ""
        var player2 = ""
        val controller = Controller(this)


        for (id in idList) {
            id.setOnClickListener {
                val index = id.contentDescription.toString().toInt()

                player1 = suit[index]
                id.setBackgroundColor(getColor(R.color.colorAccent))
                when (player1) {
                    "Batu" -> {
                        gunting1.setBackgroundColor(getColor(android.R.color.transparent))
                        kertas1.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                    "Gunting" -> {
                        kertas1.setBackgroundColor(getColor(android.R.color.transparent))
                        batu1.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                    "Kertas" -> {
                        gunting1.setBackgroundColor(getColor(android.R.color.transparent))
                        batu1.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                }
                Log.d("Player 1 Memilih: ", player1)

                player2 = suit.random()
                when (player2) {
                    "Kertas" -> {
                        kertas2.setBackgroundColor(getColor(R.color.colorAccent))
                        gunting2.setBackgroundColor(getColor(android.R.color.transparent))
                        batu2.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                    "Batu" -> {
                        batu2.setBackgroundColor(getColor(R.color.colorAccent))
                        gunting2.setBackgroundColor(getColor(android.R.color.transparent))
                        kertas2.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                    "Gunting" -> {
                        gunting2.setBackgroundColor(getColor(R.color.colorAccent))
                        kertas2.setBackgroundColor(getColor(android.R.color.transparent))
                        batu2.setBackgroundColor(getColor(android.R.color.transparent))
                    }
                }

                Log.d("Komputer memilih: ", player2)

                controller.result(player1, player2)
            }
        }
        resetBtn.setOnClickListener {
            player1 = ""
            player2 = ""
            resetBackground()
            hasil.setImageResource(R.drawable.vs)
            Log.d("Player1: ", "Reset")
        }
    }

    private fun resetBackground() {
        batu1.setBackgroundColor(getColor(android.R.color.transparent))
        batu2.setBackgroundColor(getColor(android.R.color.transparent))
        gunting1.setBackgroundColor(getColor(android.R.color.transparent))
        gunting2.setBackgroundColor(getColor(android.R.color.transparent))
        kertas1.setBackgroundColor(getColor(android.R.color.transparent))
        kertas2.setBackgroundColor(getColor(android.R.color.transparent))
    }

    override fun resultSuit(id: Int) {
        hasil.setImageResource(id)
    }

    override fun hasilSuit(hasiltxt: String) {
        Log.d("Hasilnya adalah:", hasiltxt)
    }
}