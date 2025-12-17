package com.example.konkovaa_pr32_18

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.konkovaa_pr32_18.databinding.ContentMainBinding

class ContentMain : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val key = "COUNTKEY";
        val setting = getSharedPreferences("PFNAME", MODE_PRIVATE)

        fun getCount(): Int {
            return setting.getInt(key, 0)
        }
        fun setCount(count: Int) {
            val pref = setting.edit()
            pref.putInt(key, count).apply()
        }


        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Вы нажали на FloatingActionBar", Snackbar.LENGTH_LONG).show()
        }


        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener {
            Snackbar.make(it, "Prologistc.com.ua - прогроммирование на Java | Android", Snackbar.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            val snakebar = Snackbar.make(it, "Вы изминили что-то", Snackbar.LENGTH_LONG)
            snakebar.setActionTextColor(Color.RED)
            snakebar.setAction("ВЕРНУТЬ КАК БЫЛО?", View.OnClickListener { Snackbar.make(btn2, "Все вернулось на свои места", Snackbar.LENGTH_LONG) })
            snakebar.show()
        }
        btn3.setOnClickListener {
            val count = 0;
            val snakebar = Snackbar.make(it, "Повторите еще раз! ${getCount()}" , Snackbar.LENGTH_LONG)
            snakebar.setActionTextColor(Color.CYAN)
            snakebar.setAction("ПОВТОРИТЬ", View.OnClickListener {
                setCount(count + 1);
            })
            snakebar.show()
        }

    }
}