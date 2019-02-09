package com.example.safwat.unittesttwo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.safwat.untitest.LoginContracts
import com.example.safwat.untitest.LoginPresenterImp
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContracts.LoginView {

    private lateinit var loginPresenter: LoginContracts.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenterImp(this, null)

        btn_login.setOnClickListener {
            loginPresenter.doLogin()
        }
    }


    override fun getEmail(): String {
        return email.text.toString()
    }

    override fun getPassword(): String {
        return password.text.toString()
    }

    override fun onEmailFailed(emailError: Int) {
        TIL_email.error = getString(emailError)
    }

    override fun onPasswordFailed(passwordError: Int) {
        TIL_password.error = getString(passwordError)
    }

    override fun onSuccessLogin(msg: Int) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_LONG).show()

    }

    override fun onEmailValid() {
        TIL_email.isErrorEnabled = false
    }

    override fun onPasswordValid() {
        TIL_password.isErrorEnabled = false
    }


    override fun onDestroy() {
        loginPresenter.reset()
        super.onDestroy()
    }
}
