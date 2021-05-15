package com.learn.personal.moviet

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.learn.personal.moviet.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.testIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.testIdlingResource)
    }

    @Test
    fun testLoadViewPagerContent() {
        onView(withId(R.id.movieRv)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))

        onView(withId(R.id.tabNavTvShow)).perform(click())

        onView(withId(R.id.tvShowRv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))

        onView(withId(R.id.tabNavMovie)).perform(click())
        onView(withId(R.id.movieRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
    }

    @Test
    fun testSelectMovie_ShowMovieDetail() {
        onView(withId(R.id.movieRv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(8, click()))
        onView(withId(R.id.detailTextDescription)).perform(scrollTo(), click())
        onView(withId(R.id.detailTextTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextInfo)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextDescription)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun testSelectTvShow_ShowTvShowDetail() {
        onView(withId(R.id.tabNavTvShow)).perform(click())
        onView(withId(R.id.tvShowRv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        onView(withId(R.id.detailTextDescription)).perform(scrollTo(), click())
        onView(withId(R.id.detailTextTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextInfo)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextDescription)).check(matches(isDisplayed()))
        pressBack()
    }
}