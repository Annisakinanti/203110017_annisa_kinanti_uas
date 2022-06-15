package com.example.a203110017_annisakinanti_uas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    // mendeklarasikan isi spinner dengan membuat variabel array yang berisi tipe suhu.
    lateinit var tipeSuhu: Spinner
    val types = arrayOf("Celsius", "Kelvin", "Fahrenheit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Memanggil variabel button dari activity_main
        val konversi = findViewById<View>(R.id.btnconvert) as Button
        val btnLogin = findViewById<Button>(R.id.btnAbout)

        // Memanggil variabel spinner tipesuhu
        tipeSuhu = findViewById<View>(R.id.tipesuhu) as Spinner

        // Membuat list atau dropdown pada spinner dengan isi array sesuai variabel types
        val typeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tipeSuhu.adapter = typeAdapter
        konversi.setOnClickListener{
        konversiFunc()
        }

        // method ini akan berjalan apabila tombol btnLogin diklik
        btnLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

    // Fungsi untuk logic perhitungan konversi
    @SuppressLint("SetTextI18n")
    private fun konversiFunc(){
        // Memanggil komponen atau id dari activity_main
        val temperatureTxt = findViewById<View>(R.id.editSuhu) as EditText
        val temperature = temperatureTxt.text.toString().trim()
        val tempNo = Integer.parseInt(temperature)
        val format = tipeSuhu.selectedItem.toString().trim()
        val answer1 = findViewById<View>(R.id.tampilJawabA) as TextView
        val answer2 = findViewById<View>(R.id.tampilJawabB) as TextView
        val ans1 = findViewById<View>(R.id.jawabA) as TextView
        val ans2 = findViewById<View>(R.id.jawabB) as TextView

        // Jika variabel temperature tidak kosong, maka blok kode akan dijalankan
        if (temperature.isNotEmpty()) {
            // Jika format suhu adalah celcius
            if (format == "Celsius") {
                ans1.text = "Fahrenheit"
                ans2.text = "Kelvin"
                answer1.text = ((tempNo * 9/5) + 32).toString()
                answer2.text = (tempNo + 273.15).toString()
            // Jika format suhu adalah kelvin
            }else if (format == "Kelvin") {
                ans1.text = "Fahrenheit"
                ans2.text = "Celsius"
                answer1.text = ((tempNo - 273.15) * 9/5 + 32	).toString()
                answer2.text = (tempNo - 273.15	).toString()
                // Jika format suhu adalah Fahrenheit
            }else if (format == "Fahrenheit") {
                ans1.text = "Celsius"
                ans2.text = "Kelvin"
                answer1.text = ((tempNo - 52) * 5/9).toString()
                answer2.text = ((tempNo - 32) * 5/9 + 273.15).toString()
            }
        }
    }


}