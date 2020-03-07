package com.example.rockpaperscissor

class Controller(var callBack: CallBack) {
    fun result(player1: String, player2: String) {
        var suit = mutableListOf("Batu", "Gunting", "Kertas")

        if (player1 == suit[0] && player2 == suit[1] ||
            player1 == suit[2] && player2 == suit[0] ||
            player1 == suit[1] && player2 == suit[2]
        ) {
            callBack.resultSuit(id = R.drawable.p1menang)
            callBack.hasilSuit("Player1 Menang")
        } else if (player1 == suit[1] && player2 == suit[0] ||
            player1 == suit[0] && player2 == suit[2] ||
            player1 == suit[2] && player2 == suit[1]
        ) {
            callBack.resultSuit(id = R.drawable.p2menang)
            callBack.hasilSuit( "Player2 Menang")
        } else {
            callBack.resultSuit(id = R.drawable.draw)
            callBack.hasilSuit( "Seri")
        }
    }
}