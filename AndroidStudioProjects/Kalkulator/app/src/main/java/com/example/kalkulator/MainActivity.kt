package com.example.kalkulator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerTambah, TambahFragment())
                .replace(R.id.fragmentContainerKurang, KurangFragment())
                .replace(R.id.fragmentContainerKali, KaliFragment())
                .replace(R.id.fragmentContainerBagi, BagiFragment())
                .commit()
        }

        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)
        val etAngka1 = findViewById<EditText>(R.id.etAngka1)
        val etAngka2 = findViewById<EditText>(R.id.etAngka2)

        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnKurang = findViewById<Button>(R.id.btnKurang)
        val btnKali = findViewById<Button>(R.id.btnKali)
        val btnBagi = findViewById<Button>(R.id.btnBagi)

        btnTambah.setOnClickListener { hitung("+", etAngka1, etAngka2, rootLayout) }
        btnKurang.setOnClickListener { hitung("-", etAngka1, etAngka2, rootLayout) }
        btnKali.setOnClickListener { hitung("*", etAngka1, etAngka2, rootLayout) }
        btnBagi.setOnClickListener { hitung("/", etAngka1, etAngka2, rootLayout) }
    }

    private fun hitung(
        operasi: String,
        et1: EditText,
        et2: EditText,
        rootLayout: LinearLayout
    ) {
        val input1 = et1.text.toString()
        val input2 = et2.text.toString()

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Harap isi kedua angka!", Toast.LENGTH_SHORT).show()
            return
        }

        val angka1 = input1.toDouble()
        val angka2 = input2.toDouble()

        if (operasi == "/" && angka2 == 0.0) {
            Toast.makeText(this, "Tidak bisa membagi dengan nol!", Toast.LENGTH_SHORT).show()
            return
        }

        val hasil = when (operasi) {
            "+" -> angka1 + angka2
            "-" -> angka1 - angka2
            "*" -> angka1 * angka2
            "/" -> angka1 / angka2
            else -> 0.0
        }

        if (hasil < 0) {
            rootLayout.setBackgroundColor(Color.RED)
        } else {
            rootLayout.setBackgroundColor(Color.WHITE)
        }

        val strAngka1 = formatAngka(angka1)
        val strAngka2 = formatAngka(angka2)
        val strHasil = formatAngka(hasil)

        val catatan = "$strAngka1 $operasi $strAngka2 = $strHasil"
        viewModel.tambahHistory(operasi, catatan)
    }

    private fun formatAngka(nilai: Double): String {
        return if (nilai % 1.0 == 0.0) {
            nilai.toLong().toString()
        } else {
            String.format("%.2f", nilai)
        }
    }
}