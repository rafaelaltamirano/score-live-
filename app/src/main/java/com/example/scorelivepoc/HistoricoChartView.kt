package com.example.scorelivepoc

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.github.mikephil.charting.charts.LineChart

class HistoricoChartView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private lateinit var chart: LineChart

    var data: List<Any> = emptyList()
        set(value) {
            startChart(value)
            field= value
        }

    private fun startChart(value: List<Any>) {
        removeAllViews()


    }
}