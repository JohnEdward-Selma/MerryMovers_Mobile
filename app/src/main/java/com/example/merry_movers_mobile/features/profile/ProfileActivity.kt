package com.example.merry_movers_mobile.features.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.merry_movers_mobile.R
import com.example.merry_movers_mobile.features.market.MarketActivity
import com.example.merry_movers_mobile.features.welcome.WelcomeActivity

class ProfileActivity : AppCompatActivity(), ProfileContract.View {
    private lateinit var presenter: ProfileContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        presenter = ProfilePresenter(this, ProfileModel())
        presenter.onViewReady()

        findViewById<View>(R.id.nav_home).setOnClickListener {
            presenter.onHomeTabClicked()
        }

        findViewById<View>(R.id.btn_logout).setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showProfileName(name: String) {
        findViewById<TextView>(R.id.tv_profile_name).text = name
    }

    override fun openMarket() {
        startActivity(Intent(this, MarketActivity::class.java))
        finish()
    }

    override fun playBackTransition() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
