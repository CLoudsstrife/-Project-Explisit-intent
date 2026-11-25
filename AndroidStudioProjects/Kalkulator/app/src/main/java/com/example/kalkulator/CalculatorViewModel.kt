package com.example.kalkulator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _historyTambah = MutableLiveData<String>("")
    val historyTambah: LiveData<String> = _historyTambah

    private val _historyKurang = MutableLiveData<String>("")
    val historyKurang: LiveData<String> = _historyKurang

    private val _historyKali = MutableLiveData<String>("")
    val historyKali: LiveData<String> = _historyKali

    private val _historyBagi = MutableLiveData<String>("")
    val historyBagi: LiveData<String> = _historyBagi

    fun tambahHistory(operasi: String, teksBaru: String) {
        when (operasi) {
            "+" -> _historyTambah.value = "${_historyTambah.value}$teksBaru\n"
            "-" -> _historyKurang.value = "${_historyKurang.value}$teksBaru\n"
            "*" -> _historyKali.value = "${_historyKali.value}$teksBaru\n"
            "/" -> _historyBagi.value = "${_historyBagi.value}$teksBaru\n"
        }
    }
}