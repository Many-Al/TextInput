package com.many.namevornameeinfgenandriod


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lade Views aus dem Layout über die Id
        val inputVorname = findViewById<EditText>(R.id.vorname)
        val inputNachname = findViewById<EditText>(R.id.nachname)
        val inputGeschlecht = findViewById<RadioGroup>(R.id.radioGroup)
        val checkboxKatze = findViewById<CheckBox>(R.id.katze)
        val checkboxHunde = findViewById<CheckBox>(R.id.hunde)
        val buttonEinrichten = findViewById<Button>(R.id.einrichten)
        val anzeigeTextView = findViewById<TextView>(R.id.textView)
        val buttonReset = findViewById<Button>(R.id.reset)


        buttonEinrichten.setOnClickListener {
            val vorname = inputVorname.text.toString()
            val nachname = inputNachname.text.toString()
            val geschlecht = when (inputGeschlecht.checkedRadioButtonId) {
                R.id.frau -> "Weiblich"
                R.id.mann -> "Männlich"
                R.id.diverse -> "Diverse"
                else -> "Der Nutzer hat nichst angegebn"
            }

            val magKatzen = if (checkboxKatze.isChecked) "Ja" else "Nein"
            val magHunde = if (checkboxHunde.isChecked) "Ja" else "Nein"

            // Zusammenfassung der Informationen
            val zusammenfassung =
                "Name: $vorname $nachname\nGeschlecht: $geschlecht\nMag Katzen: $magKatzen\nMag Hunde: $magHunde"
            anzeigeTextView.text = zusammenfassung
        }

        buttonReset.setOnClickListener {
            // Setze alle Eingabefelder und Checkboxen zurück
            inputVorname.setText("")
            inputNachname.setText("")
            inputGeschlecht.clearCheck()
            checkboxKatze.isChecked = false
            checkboxHunde.isChecked = false

            // Lösche den Text im TextView
            anzeigeTextView.text = ""
        }
    }
}