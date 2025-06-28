package mrkinfotech.formulagrid.ui.base

import android.content.Context
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
            if (PreferenceHelper.isUserLoggedIn(this)) {
                if(PreferenceHelper.getOnBoardingShow(this) == "true"){
                    startActivity(Intent(this, HomeMainActivity::class.java))
                }else{
                    startActivity(Intent(this, OnBoardingActivity::class.java))
                }
            } else{
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish() // Closes splash activity so user can't return to it
        }, 2000)
    }
}