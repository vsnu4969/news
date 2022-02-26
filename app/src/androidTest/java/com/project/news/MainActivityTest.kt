/**
 * @brief UI testing sample for activity main
 */
package com.project.news

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltAndroidRule.inject()
    }

    //declaring as a general rule.
    @get:Rule(order = 1)
    var mActivityRule: ActivityScenarioRule<MainActivity?>? =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_activityDisplayStatus() {
    //val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.fragment_container_view)).check(matches(isDisplayed()))
    }

}