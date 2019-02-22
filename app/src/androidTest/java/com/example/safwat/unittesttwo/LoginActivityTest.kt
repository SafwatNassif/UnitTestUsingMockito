package com.example.safwat.unittesttwo


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginActivityWithEmptyEmail() {
        val materialButton = onView(withId(R.id.btn_login))
        val textViewError = onView(withId(R.id.textinput_error))

        materialButton.perform(click())

        textViewError.check(matches(withText("Please enter your mail")))
    }


    @Test
    fun loginActivityWithPassword() {
        // view matcher of espresso component
        val materialButton = onView(withId(R.id.btn_login))
        val mail = onView(withId(R.id.email))
        val error = onView(withId(R.id.textinput_error))
        // view action of espresso component
        mail.perform(replaceText("safwat@gmail.com"), ViewActions.closeSoftKeyboard())
        materialButton.perform(click())

        // view assertion of espresso component
        error.check(matches(withText("please enter password")))
    }


    @Test
    fun loginActivityWithSuccess() {
        // view matcher of espresso component
        val materialButton = onView(withId(R.id.btn_login))
        val mail = onView(withId(R.id.email))
        val pass = onView(withId(R.id.password))
        val toast = onView(withId(android.R.id.navigationBarBackground))
        // view action of espresso component
        mail.perform(replaceText("safwat@gmail.com"), ViewActions.closeSoftKeyboard())
        pass.perform(replaceText("123456789"), ViewActions.closeSoftKeyboard())
        materialButton.perform(click())

        // view assertion of espresso component
        toast.check(matches(isDisplayed()))
    }


}
