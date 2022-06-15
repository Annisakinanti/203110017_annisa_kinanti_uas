package com.example.a203110017_annisakinanti_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // set variabel yang mana nilainya dari id elemen activity_main.xml
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val userName = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        // method ini akan berjalan apabila tombol btnLogin diklik
        btnLogin.setOnClickListener {
            // menvalidasi isian elemen input username dan password
            // jika keduanya bernilai true maka akan intent ke kelas Welcome
            if (userName.text.toString() == "admin" && password.text.toString() == "admin") {
                startActivity(Intent(this, Welcome::class.java))

                // jika ada kondisi false maka akan menampilkan toast "Login Failed!"
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}