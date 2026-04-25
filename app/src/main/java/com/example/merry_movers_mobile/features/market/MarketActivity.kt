package com.example.merry_movers_mobile.features.market

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.merry_movers_mobile.R
import com.example.merry_movers_mobile.features.profile.ProfileActivity

class MarketActivity : AppCompatActivity(), MarketContract.View {
    private lateinit var presenter: MarketContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_market)

        presenter = MarketPresenter(this, MarketModel())
        presenter.onViewReady()

        findViewById<View>(R.id.nav_profile).setOnClickListener {
            presenter.onProfileTabClicked()
        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showHeader(title: String, subtitle: String) {
        findViewById<TextView>(R.id.tv_market_title).text = title
        findViewById<TextView>(R.id.tv_market_subtitle).text = subtitle
    }

    override fun openProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    override fun playForwardTransition() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}
