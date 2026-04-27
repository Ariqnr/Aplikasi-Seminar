package com.example.aplikasipendaftaranseminar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasipendaftaranseminar.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val nama = intent.getStringExtra("EXTRA_NAMA") ?: "-"
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: "-"
        val hp = intent.getStringExtra("EXTRA_HP") ?: "-"
        val gender = intent.getStringExtra("EXTRA_GENDER") ?: "-"
        val seminar = intent.getStringExtra("EXTRA_SEMINAR") ?: "-"

        // Tampilkan data ke UI
        binding.tvNama.text = nama
        binding.tvEmail.text = email
        binding.tvHp.text = hp
        binding.tvGender.text = gender
        binding.tvSeminar.text = seminar

        // Generate nomor pendaftaran acak sederhana
        val randomNum = (1000..9999).random()
        binding.tvNoPendaftaran.text = "#SEM-2024-$randomNum"

        binding.btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}