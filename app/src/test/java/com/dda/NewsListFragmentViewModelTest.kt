package com.dda

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
internal class NewsListFragmentViewModelTest : NewsListBaseTest() {
    private lateinit var newsListFragmentViewModel: NewsListFragmentViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = TestCoroutineRule()

    @Before
    override fun setUp() {
        super.setUp()
        newsListFragmentViewModel = NewsListFragmentViewModel(newsListRepository)
    }

    @Test
    fun `observe livedata for list of newsDetails successfully`() = mainCoroutineRule.runTest {
        newsListFragmentViewModel.getNewsList()
        newsListFragmentViewModel.newsListLD.observeForever(object :
            Observer<NewsList> {
            override fun onChanged(t: NewsList?) {
                assertEquals(t!!.results[0],expectedSuccessValue )
            }
        })

    }
}