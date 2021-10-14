package com.example.tictactoe

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var player1: TextView
    lateinit var player2: TextView
    lateinit var win: TextView
    lateinit var gameOver: TextView

    val buttons = ArrayList<ArrayList<Button>>()
    var player = 1
    var times = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player1 = findViewById(R.id.btn1)
        player2 = findViewById(R.id.btn2)
        win = findViewById(R.id.tvWin)
        gameOver = findViewById(R.id.tvGameOver)
        win.isVisible = false
        gameOver.isVisible = false

        player1.setBackgroundColor(Color.GREEN)

        val row1 = ArrayList<Button>()
        row1.add(findViewById(R.id.button1))
        row1.add(findViewById(R.id.button2))
        row1.add(findViewById(R.id.button3))
        buttons.add(row1)

        val row2 = ArrayList<Button>()
        row2.add(findViewById(R.id.button4))
        row2.add(findViewById(R.id.button5))
        row2.add(findViewById(R.id.button6))
        buttons.add(row2)

        val row3 = ArrayList<Button>()
        row3.add(findViewById(R.id.button7))
        row3.add(findViewById(R.id.button8))
        row3.add(findViewById(R.id.button9))
        buttons.add(row3)



        for (button in buttons){
            for (btn in button){
                btn.setOnClickListener {
                    times++
                    if(player == 1){
                        btn.text = "X"
                        player1.setBackgroundColor(Color.parseColor("#2D000000"))
                        player2.setBackgroundColor(Color.GREEN)
                        btn.isEnabled = false
                        player = 2
                    }else if(player == 2){
                        btn.text = "O"
                        player1.setBackgroundColor(Color.GREEN)
                        player2.setBackgroundColor(Color.parseColor("#2D000000"))
                        btn.isEnabled = false
                        player = 1
                    }

                    if(times >= 9){
                        win.text = "Game Over"
                        win.isVisible = true
                        gameOver.isVisible = true
                        gameOver()
                    }
                    if(doesXWins()){
                        win.text = "Player 1 Wins!"
                        win.isVisible = true
                        gameOver.isVisible = true
                        gameOver()
                    }
                    if(doesOWins()){
                        win.text = "Player 2 Wins!"
                        win.isVisible = true
                        gameOver.isVisible = true
                        gameOver()
                    }
                }
            }
        }
    }

    private fun doesXWins(): Boolean{
        var g = false
        val x = "X"
        when{
            buttons[0][0].text == buttons[0][1].text && buttons[0][1].text == buttons[0][2].text
                    && buttons[0][2].text == x -> g=true
            buttons[1][0].text == buttons[1][1].text && buttons[1][1].text == buttons[1][2].text
                    && buttons[1][2].text == x -> g=true
            buttons[2][0].text == buttons[2][1].text && buttons[2][1].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
        }
        when{
            buttons[0][0].text == buttons[1][0].text && buttons[1][0].text == buttons[2][0].text
                    && buttons[2][0].text == x -> g=true
            buttons[0][1].text == buttons[1][1].text && buttons[1][1].text == buttons[2][1].text
                    && buttons[2][1].text == x -> g=true
            buttons[0][2].text == buttons[1][2].text && buttons[1][2].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
        }
        when{
            buttons[0][0].text == buttons[1][1].text && buttons[1][1].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
            buttons[0][2].text == buttons[1][1].text && buttons[1][1].text == buttons[2][0].text
                    && buttons[2][0].text == x -> g=true
        }
        return g
    }

    private fun doesOWins(): Boolean{
        var g = false
        val x = "O"
        when{
            buttons[0][0].text == buttons[0][1].text && buttons[0][1].text == buttons[0][2].text
                    && buttons[0][2].text == x -> g=true
            buttons[1][0].text == buttons[1][1].text && buttons[1][1].text == buttons[1][2].text
                    && buttons[1][2].text == x -> g=true
            buttons[2][0].text == buttons[2][1].text && buttons[2][1].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
        }
        when{
            buttons[0][0].text == buttons[1][0].text && buttons[1][0].text == buttons[2][0].text
                    && buttons[2][0].text == x -> g=true
            buttons[0][1].text == buttons[1][1].text && buttons[1][1].text == buttons[2][1].text
                    && buttons[2][1].text == x -> g=true
            buttons[0][2].text == buttons[1][2].text && buttons[1][2].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
        }
        when{
            buttons[0][0].text == buttons[1][1].text && buttons[1][1].text == buttons[2][2].text
                    && buttons[2][2].text == x -> g=true
            buttons[0][2].text == buttons[1][1].text && buttons[1][1].text == buttons[2][0].text
                    && buttons[2][0].text == x -> g=true
        }
        return g
    }

    private fun gameOver(){
        player1.setBackgroundColor(Color.BLUE)
        player2.setBackgroundColor(Color.BLUE)
        player1.text = "Yse"
        player2.text = "No"

        for (button in buttons){
            for (btn in button){
                btn.isEnabled = false
            }
        }
        player1.setOnClickListener { recreate() }
        player2.setOnClickListener { finish() }
    }

}