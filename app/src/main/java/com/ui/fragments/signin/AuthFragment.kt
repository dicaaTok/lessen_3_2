package com.ui.fragments.signin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dica.lessen_3_2.R
import com.google.android.material.button.MaterialButton

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private lateinit var resultText: TextView
    private lateinit var eraseButton: MaterialButton
    private val correctPassword = "1234"
    private var enteredCode = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resultText = view.findViewById(R.id.result)
        eraseButton = view.findViewById(R.id.erase)

        val buttonIds = listOf(
            R.id.zero, R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six,
            R.id.seven, R.id.eight, R.id.nine
        )

        buttonIds.forEach { id ->
            view.findViewById<MaterialButton>(id).setOnClickListener {
                val digit = (it as MaterialButton).text.toString()
                if (enteredCode.length < 4) {
                    enteredCode += digit
                    updateResult()
                }

                if (enteredCode.length == 4) {
                    if (enteredCode == correctPassword) {
                        findNavController().navigate(R.id.action_authFragment_to_homeFragment2)
                    }
                    else {
                        Toast.makeText(requireContext(), "Неверный пароль", Toast.LENGTH_SHORT).show()
                        enteredCode = ""
                        updateResult()
                    }
                }
            }
        }

        eraseButton.setOnClickListener {
            if (enteredCode.isNotEmpty()) {
                enteredCode = enteredCode.dropLast(1)
                updateResult()
            }
        }

        updateResult()
    }

    private fun updateResult() {
        resultText.text = enteredCode.padEnd(4, '*')

        // Обновляем цвет кнопки "erase"
        eraseButton.setBackgroundColor(
            if (enteredCode.isNotEmpty())
                ContextCompat.getColor(requireContext(), R.color.orange)
            else
                ContextCompat.getColor(requireContext(), R.color.gray)
        )
    }
}