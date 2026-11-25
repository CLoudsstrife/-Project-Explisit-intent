package com.example.kalkulator
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class KurangFragment : Fragment(R.layout.fragment_history) {
    private val viewModel: CalculatorViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvJudul = view.findViewById<TextView>(R.id.tvJudulOperasi)
        val tvHistory = view.findViewById<TextView>(R.id.tvListHistory)

        tvJudul.text = "History Kurang (-)"
        viewModel.historyKurang.observe(viewLifecycleOwner) { history ->
            tvHistory.text = history
        }
    }
}