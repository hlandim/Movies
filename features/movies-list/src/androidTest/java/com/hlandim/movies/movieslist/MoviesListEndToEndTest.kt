package com.hlandim.movies.movieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalFoundationApi
@HiltAndroidTest
class MoviesListEndToEndTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)


    @get:Rule(order = 1)
    var activityRule = createAndroidComposeRule<MoviesListActivity>()


    companion object {
        const val LIST_DESCRIPTION = "ItemsList"
    }

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun whenOpening_shouldSeeMoviesList() {
        with(activityRule) {
            mainClock.autoAdvance = false
            waitForIdle()

            onNodeWithText("Fetching the movies...").assertIsDisplayed()

            // Waiting for API call finish
            mainClock.autoAdvance = true
            waitUntil(5000) {
                onAllNodesWithContentDescription(LIST_DESCRIPTION).fetchSemanticsNodes(false)
                    .isNotEmpty()
            }

            onNodeWithContentDescription(LIST_DESCRIPTION).assertIsDisplayed()
        }
    }

    @Test
    fun whenSelectingMovie_DetailsScreenShouldAppear() {
        whenOpening_shouldSeeMoviesList()
        with(activityRule) {

            // Clicking on the first movie
            onNodeWithContentDescription(LIST_DESCRIPTION).onChildAt(0).performClick()

            waitForIdle()
            // Checking if all fields on the Details screen are visible
            onNodeWithContentDescription("backDropPath").assertIsDisplayed()
            onNodeWithContentDescription("posterPath").assertIsDisplayed()
            onNodeWithContentDescription("popularity").assertIsDisplayed()
            onNodeWithContentDescription("releaseYear").assertIsDisplayed()
            onNodeWithContentDescription("overview").assertIsDisplayed()
        }
    }

}