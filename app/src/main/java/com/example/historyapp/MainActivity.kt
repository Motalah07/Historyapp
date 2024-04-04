package com.example.historyapp

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //initialize
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)

        searchButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val FamousPerson = when (age) {
                    20 -> "XXXTentaction, Jahseh Dwayne Ricardo Onfroy, was an American rapper and singer-songwriter"
                    36 -> "Bob Marley was a Jamaican reggae singer."
                    40 -> "Paul Walker was an American actor, best known for his role as Brian O'Conner in the Fast & Furious franchise."
                    50 -> "Michael Jackson was an American singer, songwriter, dancer, and philanthropist."
                    60 -> "Diego Maradona was an Argentine professional football player."
                    70 -> "Louis Vuitton founded a French luxury fashion house and company in 1854 called Louis Vuitton"
                    80 -> "Donatello was an Italian sculptor of the Renaissance period."
                    95 -> "Nelson Mandela was a South African anti-apartheid activist, politician and was the first black president."
                    100 -> "Charlie Trippi was an American professional football player for the Chicago Cardinals."
                    else -> null
                }
                val message = if (FamousPerson != null) "The famous persons name is $FamousPerson"
                else "No employee found with the entered age"
                resultTextView.text = message
            }else {
                resultTextView.text = "Invalid input.Please enter a valid age between 20 and 100"


            }
            clearButton.setOnClickListener {
                ageInput.text.clear()
                resultTextView.text = ""

            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }
    }
}