/**
 * @description: Class for main activity.
 */
package com.project.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.news.databinding.ActivityMainBinding
import com.project.news.presentation.ui.NewsBaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mNewsBaseFragment : NewsBaseFragment
    private lateinit var binding: ActivityMainBinding

    /**
     * @description: lifecycle method.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view, mNewsBaseFragment)
        transaction.commit()
    }
}