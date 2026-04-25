package com.example.merry_movers_mobile.features.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.merry_movers_mobile.R
import com.example.merry_movers_mobile.features.market.MarketActivity
import com.example.merry_movers_mobile.features.welcome.WelcomeActivity

class RegisterActivity : AppCompatActivity(), AuthContract.View {
    private lateinit var presenter: AuthContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        presenter = AuthPresenter(
            view = this,
            model = AuthModel(destination = AuthDestination.LOGIN)
        )

        findViewById<View>(R.id.btn_back).setOnClickListener {
            presenter.onBackClicked()
        }

        findViewById<View>(R.id.tv_sign_in).setOnClickListener {
            presenter.onSwitchAuthClicked()
        }

        findViewById<View>(R.id.btn_create_account).setOnClickListener {
            presenter.onPrimaryActionClicked()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.onSystemBackPressed()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun openWelcome() {
        val welcomeIntent = Intent(this, WelcomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        startActivity(welcomeIntent)
        finish()
    }

    override fun openLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun openRegister() {
        // Register is the current screen.
    }

    override fun openMarket() {
        startActivity(Intent(this, MarketActivity::class.java))
        finish()
    }

    override fun playForwardTransition() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun playBackTransition() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
