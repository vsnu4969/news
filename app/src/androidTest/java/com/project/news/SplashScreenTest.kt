package com.project.news

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.project.news.presentation.di.AppModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest
@UninstallModules(AppModule::class)
class SplashScreenTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltAndroidRule.inject()
    }

    //declaring as a general rule.
    @get:Rule(order = 1)
    var mActivityRule: ActivityScenarioRule<SplashScreen?>? =
        ActivityScenarioRule(SplashScreen::class.java)

    @Test
    fun test_splashScreenLogoShowStatus() {
        Espresso.onView(ViewMatchers.withId(R.id.splash_screen_logo))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}