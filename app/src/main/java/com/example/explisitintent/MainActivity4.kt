package com.example.explisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    companion object {
        const val dataPegawai = "kirimDataPegawai"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val intentPegawai = androidx.core.content.IntentCompat.getParcelableArrayListExtra(
            intent,
            dataPegawai,
            Pegawai::class.java
        )

        val isiText : String = "NIP : ${intentPegawai!![0].NIP.toString()}, " +
                "\nNama : ${intentPegawai!![0].Nama.toString()}, " +
                "\nDept : ${intentPegawai!![0].Dept.toString()}" +
                "\n\n" +
                "NIP : ${intentPegawai?.get(1)?.NIP.toString()}, " +
                "\nNama : ${intentPegawai?.get(1)?.Nama.toString()}, " +
                "\nDept : ${intentPegawai?.get(1)?.Dept.toString()}"

        val _showDataPegawai = findViewById<TextView>(R.id.showDataPegawai)
        _showDataPegawai.text = isiText
    }
}