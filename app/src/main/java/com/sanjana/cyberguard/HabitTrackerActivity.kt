package com.sanjana.cyberguard

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HabitTrackerActivity : AppCompatActivity() {

    private lateinit var cbChangePassword: CheckBox
    private lateinit var cbEnable2FA: CheckBox
    private lateinit var cbAvoidPublicWiFi: CheckBox
    private lateinit var cbUpdateSoftware: CheckBox
    private lateinit var cbCheckAppPermissions: CheckBox
    private lateinit var cbUseVPN: CheckBox
    private lateinit var cbBackupData: CheckBox
    private lateinit var cbUseBiometrics: CheckBox
    private lateinit var cbReviewActivity: CheckBox
    private lateinit var cbAvoidPhishing: CheckBox
    private lateinit var btnSaveHabits: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_tracker)

        cbChangePassword = findViewById(R.id.cbChangePassword)
        cbEnable2FA = findViewById(R.id.cbEnable2FA)
        cbAvoidPublicWiFi = findViewById(R.id.cbAvoidPublicWiFi)
        cbUpdateSoftware = findViewById(R.id.cbUpdateSoftware)
        cbCheckAppPermissions = findViewById(R.id.cbCheckAppPermissions)
        cbUseVPN = findViewById(R.id.cbUseVPN)
        cbBackupData = findViewById(R.id.cbBackupData)
        cbUseBiometrics = findViewById(R.id.cbUseBiometrics)
        cbReviewActivity = findViewById(R.id.cbReviewActivity)
        cbAvoidPhishing = findViewById(R.id.cbAvoidPhishing)
        btnSaveHabits = findViewById(R.id.btnSaveHabits)

        loadHabitProgress()

        btnSaveHabits.setOnClickListener {
            saveHabitProgress()
            Toast.makeText(this, "Habit progress saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveHabitProgress() {
        val sharedPreferences = getSharedPreferences("CyberHabits", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putBoolean("ChangePassword", cbChangePassword.isChecked)
        editor.putBoolean("Enable2FA", cbEnable2FA.isChecked)
        editor.putBoolean("AvoidPublicWiFi", cbAvoidPublicWiFi.isChecked)
        editor.putBoolean("UpdateSoftware", cbUpdateSoftware.isChecked)
        editor.putBoolean("CheckAppPermissions", cbCheckAppPermissions.isChecked)
        editor.putBoolean("UseVPN", cbUseVPN.isChecked)
        editor.putBoolean("BackupData", cbBackupData.isChecked)
        editor.putBoolean("UseBiometrics", cbUseBiometrics.isChecked)
        editor.putBoolean("ReviewActivity", cbReviewActivity.isChecked)
        editor.putBoolean("AvoidPhishing", cbAvoidPhishing.isChecked)

        editor.apply()
    }

    private fun loadHabitProgress() {
        val sharedPreferences = getSharedPreferences("CyberHabits", Context.MODE_PRIVATE)

        cbChangePassword.isChecked = sharedPreferences.getBoolean("ChangePassword", false)
        cbEnable2FA.isChecked = sharedPreferences.getBoolean("Enable2FA", false)
        cbAvoidPublicWiFi.isChecked = sharedPreferences.getBoolean("AvoidPublicWiFi", false)
        cbUpdateSoftware.isChecked = sharedPreferences.getBoolean("UpdateSoftware", false)
        cbCheckAppPermissions.isChecked = sharedPreferences.getBoolean("CheckAppPermissions", false)
        cbUseVPN.isChecked = sharedPreferences.getBoolean("UseVPN", false)
        cbBackupData.isChecked = sharedPreferences.getBoolean("BackupData", false)
        cbUseBiometrics.isChecked = sharedPreferences.getBoolean("UseBiometrics", false)
        cbReviewActivity.isChecked = sharedPreferences.getBoolean("ReviewActivity", false)
        cbAvoidPhishing.isChecked = sharedPreferences.getBoolean("AvoidPhishing", false)
    }
}
