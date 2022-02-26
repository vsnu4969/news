/**
 * @brief Test suite for testing all classes together
 */
package com.project.news.testsuite

import com.project.news.MainActivityTest
import com.project.news.SplashScreenTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SplashScreenTest::class)
class EspressoSampleTestSuite