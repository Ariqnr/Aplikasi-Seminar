package com.example.aplikasipendaftaranseminar

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.aplikasipendaftaranseminar.databinding.ActivityFormPendaftaranBinding

class FormPendaftaranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormPendaftaranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPendaftaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Spinner (AutoCompleteTextView)
        val items = listOf("Seminar Teknologi Hijau", "Seminar Keamanan Siber", "Seminar Kecerdasan Buatan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        binding.actvSeminar.setAdapter(adapter)

        // Real-time Email Validation
        binding.etEmail.addTextChangedListener { text ->
            if (text.isNullOrEmpty()) {
                binding.tilEmail.error = null
            } else if (!text.contains("@")) {
                binding.tilEmail.error = "Format tidak lengkap"
            } else {
                binding.tilEmail.error = null
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val hp = binding.etHp.text.toString()
            val seminar = binding.actvSeminar.text.toString()
            val isChecked = binding.cbPersetujuan.isChecked

            // Mendapatkan gender dari RadioGroup
            val gender = when (binding.rgJenisKelamin.checkedRadioButtonId) {
                R.id.rbLakilaki -> "Laki-laki"
                R.id.rbPerempuan -> "Perempuan"
                else -> "-"
            }

            if (nama.isEmpty() || email.isEmpty() || hp.isEmpty() || seminar.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) {
                binding.tilEmail.error = "Format tidak lengkap"
            } else if (!isChecked) {
                Toast.makeText(this, "Mohon setujui persyaratan", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke ResultActivity dengan data
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_NAMA", nama)
                    putExtra("EXTRA_EMAIL", email)
                    putExtra("EXTRA_HP", hp)
                    putExtra("EXTRA_GENDER", gender)
                    putExtra("EXTRA_SEMINAR", seminar)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}