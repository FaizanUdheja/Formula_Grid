package mrkinfotech.formulagrid.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.ui.home.HomeMainActivity
import mrkinfotech.formulagrid.ui.login.LoginActivity
import mrkinfotech.formulagrid.utils.PreferenceHelper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            if (PreferenceHelper.getOnBoardingShow(this)=="true") {
                if (PreferenceHelper.isUserLoggedIn(this)) {
                    startActivity(Intent(this, HomeMainActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            } else {
                startActivity(Intent(this, OnBoardingActivity::class.java))
            }

            finish()
        }, 2000)
    }
}