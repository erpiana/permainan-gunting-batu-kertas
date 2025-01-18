package com.example.tugasgame

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener() {
        rockImageButton.setOnClickListener { startGame(option = "ROCK") }
        scissorsImageButton.setOnClickListener { startGame(option = "SCISSORS") }
        paperImageButton.setOnClickListener { startGame(option = "PAPER") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListener()
    }

}