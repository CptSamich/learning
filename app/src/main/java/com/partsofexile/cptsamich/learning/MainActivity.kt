package com.partsofexile.cptsamich.learning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {

    fun genRandom(){
        rand = r.nextBoolean()
        val randomView = findViewById<TextView>(R.id.displayResult)
        randomView.text = rand.toString()
    }

    fun incScore(v:Int = 0){
        scorePoints += v
        val scorePointsCurr = findViewById<TextView>(R.id.scorePoints)
        scorePointsCurr.text = scorePoints.toString()
    }
    fun doYes(){
        if (rand){
            incScore(1)
        }
        genRandom()
    }

    fun doNo(){
        if (rand == false){
            incScore(1)
        }
        genRandom()
    }
    val r = Random()
    var scorePoints = 0
    var rand = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        genRandom()
        val buttonYes = findViewById<Button>(R.id.buttonYes)
        val buttonNo = findViewById<Button>(R.id.buttonNo)

        //val buttonYesFunc = View.OnClickListener { override fun onClick(v:View?){} }
        buttonYes.setOnClickListener { v -> doYes() }
        buttonNo.setOnClickListener { v -> doNo() }
    }

}
