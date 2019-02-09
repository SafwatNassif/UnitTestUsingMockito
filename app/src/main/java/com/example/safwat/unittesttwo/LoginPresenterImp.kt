package com.example.safwat.untitest

import com.example.safwat.unittesttwo.R

class LoginPresenterImp(
    var loginView: LoginContracts.LoginView?,
    var loginModel: LoginContracts.LoginModel?
) : LoginContracts.LoginPresenter {

    override fun doLogin() {
        val email = loginView?.getEmail()
        val password = loginView?.getPassword()

        validation(email!!, password!!)
    }

    private fun validation(email: String, password: String) {
        if (!isEmailValid(email))
            return

        if (!isPasswordValid(password))
            return

        loginView?.onSuccessLogin(R.string.login_success)

    }

    private fun isEmailValid(email: String): Boolean {

        if (email.isEmpty()) {
            loginView?.onEmailFailed(R.string.email_empty)
            return false
        }

        if (!email.contains("@")) {
            loginView?.onEmailFailed(R.string.containAt)
            return false
        }

        loginView?.onEmailValid()

        return true
    }

    private fun isPasswordValid(password: String): Boolean {
        if (password.isEmpty()) {
            loginView?.onPasswordFailed(R.string.password_empty)
            return false
        }

        if (password.length < 8) {
            loginView?.onPasswordFailed(R.string.password_length)
            return false
        }

        loginView?.onPasswordValid()

        return true
    }

    override fun reset() {
        loginView = null
    }

}