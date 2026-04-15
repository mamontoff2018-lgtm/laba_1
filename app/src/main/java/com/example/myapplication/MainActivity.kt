package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
        setTitle("Покидов М.Ю — Лабораторная работа 1")
    }

    inner class DrawView(context: Context) : View(context) {

        private val paint = Paint().apply {
            isAntiAlias = true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val w = canvas.width
            val h = canvas.height

            // Фон
            canvas.drawARGB(255, 240, 240, 240)

            //Задание 3 (вариант 1)
            val rectWidth = 200
            val rectHeight = rectWidth * 2

            paint.color = Color.rgb(0, 180, 0)
            paint.style = Paint.Style.FILL

            val left = (w - rectWidth) / 2f
            val top = (h - rectHeight) / 2f - 100f

            canvas.drawRect(left, top, left + rectWidth, top + rectHeight, paint)

            //Задание 4 (вариант 1)
            val houseX = (w / 2) - 150
            val houseY = (top + rectHeight + 80).toInt()

            //Стены дома
            paint.color = Color.rgb(245, 220, 180)
            canvas.drawRect(houseX.toFloat(), houseY.toFloat(),
                (houseX + 300).toFloat(), (houseY + 220).toFloat(), paint)

            //Крыша
            paint.color = Color.rgb(200, 50, 50)
            val roof = Path().apply {
                moveTo(houseX.toFloat(), houseY.toFloat())
                lineTo((houseX + 150).toFloat(), (houseY - 120).toFloat())
                lineTo((houseX + 300).toFloat(), houseY.toFloat())
            }
            canvas.drawPath(roof, paint)

            //Дверь
            paint.color = Color.rgb(120, 60, 30)
            canvas.drawRect((houseX + 110).toFloat(), (houseY + 120).toFloat(),
                (houseX + 190).toFloat(), (houseY + 220).toFloat(), paint)

            //Ручка двери
            paint.color = Color.rgb(255, 220, 0)
            canvas.drawCircle((houseX + 175).toFloat(), (houseY + 170).toFloat(), 8f, paint)

            //Окно
            paint.color = Color.rgb(255, 255, 255)
            canvas.drawRect((houseX + 30).toFloat(), (houseY + 40).toFloat(),
                (houseX + 100).toFloat(), (houseY + 100).toFloat(), paint)

            //Рамка и линии окна
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 6f
            canvas.drawRect((houseX + 30).toFloat(), (houseY + 40).toFloat(),
                (houseX + 100).toFloat(), (houseY + 100).toFloat(), paint)
            canvas.drawLine((houseX + 65).toFloat(), (houseY + 40).toFloat(),
                (houseX + 65).toFloat(), (houseY + 100).toFloat(), paint)
            canvas.drawLine((houseX + 30).toFloat(), (houseY + 70).toFloat(),
                (houseX + 100).toFloat(), (houseY + 70).toFloat(), paint)

            //ЗАДАНИЕ 2
            paint.style = Paint.Style.FILL
            paint.color = Color.BLACK

            //Дата рождения
            paint.textSize = 50f
            paint.isFakeBoldText = true

            val dateText = "Дата рождения: 13.06.2006"
            val dateWidth = paint.measureText(dateText)
            canvas.drawText(dateText, (w - dateWidth) / 2f, 120f, paint)

            //Подпись автора
            paint.textSize = 42f
            val authorText = "Выполнил: Покидов М.Ю."
            val authorWidth = paint.measureText(authorText)
            canvas.drawText(authorText, (w - authorWidth) / 2f, h - 60f, paint)
        }
    }
}