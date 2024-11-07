package com.example.appconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputValue: EditText
    private lateinit var resultText: TextView
    private lateinit var convertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValue = findViewById(R.id.inputValue)
        resultText = findViewById(R.id.resultText)
        convertButton = findViewById(R.id.convertButton)

        convertButton.setOnClickListener {
            val meterString = inputValue.text.toString().trim()

            if (meterString.isNotEmpty()) {
                val meter = meterString.toDoubleOrNull()

                if (meter != null) {
                    val kilometer = meter / 1000

                    val formattedKilometer = if (kilometer % 1.0 == 0.0) {
                        kilometer.toInt().toString()
                    } else {
                        String.format("%.2f", kilometer)
                    }

                    resultText.text = "$meter meter = $formattedKilometer kilometer"
                } else {
                    Toast.makeText(this@MainActivity, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Masukkan nilai dalam meter", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
