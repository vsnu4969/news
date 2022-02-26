/**
 * @description: Class used denote the splash screen.
 */
package com.project.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.project.news.common.Constants
import com.project.news.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    /**
     * @description: lifecycle method.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.splashScreenLogo.setImageResource(R.drawable.bbc2)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity :: class.java)
            startActivity(intent)
            finish()
        }, Constants.SPLASH_SCREEN_TIME_OUT)
    }
}