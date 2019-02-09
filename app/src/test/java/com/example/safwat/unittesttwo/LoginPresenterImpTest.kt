package com.example.safwat.unittesttwo

import com.example.safwat.untitest.LoginContracts
import com.example.safwat.untitest.LoginPresenterImp
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterImpTest {


    @Mock
    private lateinit var loginView: LoginContracts.LoginView

    @Mock
    private lateinit var loginPresenter: LoginContracts.LoginPresenter

    @Before
    fun setup() {
        loginPresenter = LoginPresenterImp(loginView, null)
    }


    @Test
    fun testEmailIsEmpty() {
        Mockito.doReturn("").`when`(loginView).getEmail()
        Mockito.doReturn("123456").`when`(loginView).getPassword()

        loginPresenter.doLogin()

        Mockito.verify(loginView).onEmailFailed(R.string.email_empty)
    }

    @Test
    fun testEmailContainAt() {
        Mockito.doReturn("safwat").`when`(loginView).getEmail()
        Mockito.doReturn("123456").`when`(loginView).getPassword()

        loginPresenter.doLogin()

        Mockito.verify(loginView).onEmailFailed(R.string.containAt)
    }


    @Test
    fun testPasswordEmpty() {
        Mockito.doReturn("safwat@gmail.com").`when`(loginView).getEmail()
        Mockito.doReturn("").`when`(loginView).getPassword()

        loginPresenter.doLogin()

        Mockito.verify(loginView).onPasswordFailed(R.string.password_empty)
    }

    @Test
    fun testPasswordLength() {
        Mockito.doReturn("safwat@gmail.com").`when`(loginView).getEmail()
        Mockito.doReturn("12").`when`(loginView).getPassword()

        loginPresenter.doLogin()

        Mockito.verify(loginView).onPasswordFailed(R.string.password_length)
    }



    @Test
    fun testSuccessLogin() {

        Mockito.doReturn("safwat@gmail.com").`when`(loginView).getEmail()
        Mockito.doReturn("123456789Safwat").`when`(loginView).getPassword()

        loginPresenter.doLogin()

        Mockito.verify(loginView).onEmailValid()
        Mockito.verify(loginView).onPasswordValid()
        Mockito.verify(loginView).onSuccessLogin(R.string.login_success)
    }

}