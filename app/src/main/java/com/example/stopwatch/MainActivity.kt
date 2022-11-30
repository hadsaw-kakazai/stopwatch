package com.example.stopwatch

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var isStart = false
    var pause = false
    var seconds = 0

    var hours = 0
    var minutes = 0
    var secs: Int = seconds % 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun run(){


        val timeView = findViewById<TextView>(R.id.watch)

        Thread(Runnable {

            while (isStart) {

                seconds++
                if(seconds == 60){
                    minutes++
                    seconds = 0
                }
                if (minutes == 60){
                    hours++
                    minutes = 0
                }
                val time: String = "${hours} : ${minutes} : ${seconds}"


                runOnUiThread{timeView.text = time }

                // Thread sleep for 1 sec
                Thread.sleep(1000)
            }
        }).start()
    }

    fun onClickStart(view: View){
        isStart = true
        run()
    }

    fun onClickStop(view: View){
        pause = true
        isStart = false
    }

    fun onClickRest(view: View){
        isStart = false
        pause = false
    }

    }




