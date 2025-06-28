package mrkinfotech.formulagrid.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.formulagrid.databinding.ActivityOnBoardingBinding
import mrkinfotech.formulagrid.ui.login.LoginActivity
import mrkinfotech.formulagrid.utils.PreferenceHelper

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.GetStarted.setOnClickListener {
            val onBoardShow = startActivity(Intent(this, LoginActivity::class.java))
            PreferenceHelper.setOnBoardingShow(this, "true")
        }
    }
}