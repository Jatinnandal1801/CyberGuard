package com.sanjana.cyberguard

import android.Manifest
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SecurityCheckupActivity : AppCompatActivity() {

    private lateinit var tvWifiStatus: TextView
    private lateinit var tvSoftwareStatus: TextView
    private lateinit var tvPermissionsStatus: TextView
    private lateinit var tvLockStatus: TextView
    private lateinit var tvVpnStatus: TextView
    private lateinit var tvUnknownSourcesStatus: TextView
    private lateinit var btnRunCheckup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_security_checkup)

        tvWifiStatus = findViewById(R.id.tvWifiStatus)
        tvSoftwareStatus = findViewById(R.id.tvSoftwareStatus)
        tvPermissionsStatus = findViewById(R.id.tvPermissionsStatus)
        tvLockStatus = findViewById(R.id.tvLockStatus)
        tvVpnStatus = findViewById(R.id.tvVpnStatus)
        tvUnknownSourcesStatus = findViewById(R.id.tvUnknownSourcesStatus)
        btnRunCheckup = findViewById(R.id.btnRunCheckup)

        btnRunCheckup.setOnClickListener {
            checkWifiSecurity()
            checkSoftwareUpdate()
            checkAppPermissions()

            // Static values
            tvLockStatus.text = "Screen Lock: Unlocked"
            tvVpnStatus.text = "VPN Status: VPN not connected"
            tvUnknownSourcesStatus.text = "Unknown Sources: No unknown source"
        }
    }

    private fun checkWifiSecurity() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 101)

            tvWifiStatus.text = "WiFi Security: ⚠️ Permission required to check security."
            return
        }

        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        val connectionInfo = wifiManager.connectionInfo

        if (connectionInfo.ssid == "<unknown ssid>") {
            tvWifiStatus.text = "WiFi Security: No WiFi connected"
        } else {
            val scanResults = wifiManager.scanResults
            val currentNetwork = scanResults.find {
                it.SSID == connectionInfo.ssid.removePrefix("\"").removeSuffix("\"")
            }

            val isOpenNetwork = currentNetwork?.capabilities?.contains("WEP") == true ||
                    currentNetwork?.capabilities?.contains("WPA") == true
            tvWifiStatus.text = if (isOpenNetwork) {
                "WiFi Security: ⚠️ Connected to an unsecured network!"
            } else {
                "WiFi Security: ✅ Secure network detected"
            }
        }
    }

    private fun checkSoftwareUpdate() {
        val currentVersion = Build.VERSION.SDK_INT
        val latestVersion = Build.VERSION_CODES.UPSIDE_DOWN_CAKE // Update as needed

        tvSoftwareStatus.text = if (currentVersion >= latestVersion) {
            "Software Update: ✅ Up-to-date"
        } else {
            "Software Update: ⚠️ Outdated! Update your device."
        }
    }

    private fun checkAppPermissions() {
        val criticalPermissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        val riskyPermissions = criticalPermissions.filter {
            ActivityCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }

        tvPermissionsStatus.text = if (riskyPermissions.isNotEmpty()) {
            "App Permissions: ⚠️ Apps have access to ${riskyPermissions.size} risky permissions!"
        } else {
            "App Permissions: ✅ No high-risk permissions detected"
        }
    }
}
