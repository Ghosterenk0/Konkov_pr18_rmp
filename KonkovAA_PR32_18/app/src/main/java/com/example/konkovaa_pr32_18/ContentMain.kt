package com.example.konkovaa_pr32_18

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.konkovaa_pr32_18.databinding.ContentMainBinding

class ContentMain : AppCompatActivity() {

    val key = "COUNTKEY";
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        val setting: SharedPreferences = getSharedPreferences("PFNAME", MODE_PRIVATE)


        count = setting.getInt(key, 0)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab)


        btn1.setOnClickListener {
            Snackbar.make(it, "Prologistc.com.ua - прогроммирование на Java | Android", Snackbar.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            val snakebar = Snackbar.make(it, "Вы изминили что-то", Snackbar.LENGTH_LONG)
            snakebar.setActionTextColor(Color.RED)
            snakebar.setAction("ВЕРНУТЬ КАК БЫЛО?", View.OnClickListener { Snackbar.make(btn2, "Все вернулось на свои места", Snackbar.LENGTH_LONG).show() })
            snakebar.show()
        }
        btn3.setOnClickListener {
            val snakebar = Snackbar.make(it, "Повторите еще раз! ${count}" , Snackbar.LENGTH_LONG)
            snakebar.setActionTextColor(Color.CYAN)
            snakebar.setAction("ПОВТОРИТЬ", View.OnClickListener {
                count++
                setting.edit().putInt(key, count).apply()

            })
            snakebar.show()
        }
        btn4.setOnClickListener {
            Snackbar.make(it, "Вы нажали на FloatingActionBar", Snackbar.LENGTH_LONG).show()
        }

    }
}
