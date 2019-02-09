package com.example.safwat.untitest

interface LoginContracts {

    interface LoginView {
        fun getEmail(): String
        fun getPassword(): String
        fun onEmailFailed(emailError: Int)
        fun onPasswordFailed(passwordError: Int)
        fun onSuccessLogin(msg: Int)
        fun onEmailValid()
        fun onPasswordValid()
    }

    interface LoginPresenter {
        fun doLogin()
        fun reset()
    }

    interface LoginModel {}
}