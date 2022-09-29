package com.seymen.coroutinesrepeatexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var i: Int = 0
    private var j: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Created two threads and run two infinite loops at the same time without blocking each other
         */
        CoroutineScope(Dispatchers.Default).launch {

            while (true) {
                loopDefault()
            }
        }

        CoroutineScope(Dispatchers.Main).launch {

            while (true) {
                loopMain()
            }
        }
    }

    /**
     * suspend fun running in default thread. 1 sec delayed for see to easily see in the log records.
     *
     * @return i record on log
     */
    private suspend fun loopDefault(): Int {
        i++
        delay(1000L)
        return Log.v("LOOP1", "Default Counter: $i")
    }

    /**
     * suspend fun running in Main thread. 2 sec delayed for see to easily see in the log records.

     *
     * @return i record on log
     */
    private suspend fun loopMain(): Int {
        j++
        delay(2000L)
        return Log.v("LOOP2", "Main Counter: $j")
    }
}