package com.example.aplikasipendaftaranseminar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasipendaftaranseminar.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Reset error status
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            // Kredensial: Robert / Aktor123
            if (username == "Robert" && password == "Aktor123") {
                Toast.makeText(this, "Selamat datang di kapal, Kapten Robert!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else if (username != "Robert") {
                binding.tilUsername.error = "Nama pengguna salah"
            } else if (password.isEmpty()) {
                binding.tilPassword.error = "Sandi tidak boleh kosong"
            } else if (password != "Aktor123") {
                binding.tilPassword.error = "Kata sandi salah"
            } else {
                Toast.makeText(this, "Kredensial tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}