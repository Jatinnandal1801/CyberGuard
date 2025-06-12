package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class TerminalActivity : AppCompatActivity() {

    private lateinit var terminalOutput: TextView
    private lateinit var commandInput: EditText
    private lateinit var runCommandButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminal)

        terminalOutput = findViewById(R.id.terminalOutput)
        commandInput = findViewById(R.id.commandInput)
        runCommandButton = findViewById(R.id.runCommandButton)

        runCommandButton.setOnClickListener {
            val command = commandInput.text.toString()
            runShellCommand(command)
        }
    }

    private fun runShellCommand(command: String) {
        try {
            val process = Runtime.getRuntime().exec(command)
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            val errorReader = BufferedReader(InputStreamReader(process.errorStream))

            val output = StringBuilder()
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                output.appendLine(line)
            }

            while (errorReader.readLine().also { line = it } != null) {
                output.appendLine("Error: $line")
            }

            process.waitFor()
            terminalOutput.text = output.toString()

        } catch (e: Exception) {
            terminalOutput.text = "Exception: ${e.message}"
        }
    }
}
