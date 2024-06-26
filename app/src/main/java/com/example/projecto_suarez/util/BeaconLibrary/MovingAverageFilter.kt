package com.example.projecto_suarez.util.BeaconLibrary

import android.util.Log
import java.util.LinkedList

class MovingAverageFilter(private val size: Int) {
    val distanceQueue = LinkedList<Double>()
    private val TAG = "MovingAverageFilter";
    fun calculateDistance(txPower:Int, rssi: Int): Double {
        val factor = (-1 * txPower - rssi) / (10 * 4.0)
        val distance = Math.pow(10.0, factor)
        var movingAverage = distance

        if (distanceQueue.size == size){

            val sum = distanceQueue.stream().map { it }.reduce{ acc, elem -> acc + elem }.orElse(0.0)
            Log.d(TAG, "Using moving filter" + sum)

            movingAverage = sum / size
        }

        distanceQueue.add(distance)
        if (distanceQueue.size > size) {
            distanceQueue.remove()
        }
        return movingAverage
    }
}