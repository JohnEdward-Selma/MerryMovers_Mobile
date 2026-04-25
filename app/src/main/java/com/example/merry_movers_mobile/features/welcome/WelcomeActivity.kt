package com.example.merry_movers_mobile.features.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.merry_movers_mobile.R
import com.example.merry_movers_mobile.features.auth.LoginActivity
import com.example.merry_movers_mobile.features.auth.RegisterActivity

class WelcomeActivity : AppCompatActivity(), WelcomeContract.View {
    private lateinit var presenter: WelcomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        presenter = WelcomePresenter(
            view = this,
            model = WelcomeModel()
        )

        findViewById<View>(R.id.btn_create_account).setOnClickListener {
            presenter.onCreateAccountClicked()
        }

        findViewById<View>(R.id.btn_sign_in).setOnClickListener {
            presenter.onSignInClicked()
        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun openLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun openRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun playForwardTransition() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}