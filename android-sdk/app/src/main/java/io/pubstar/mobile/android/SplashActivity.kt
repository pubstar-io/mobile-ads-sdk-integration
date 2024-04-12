package io.pubstar.mobile.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.pubstar.mobile.ads.interfaces.InitAdListener
import io.pubstar.mobile.ads.model.ErrorCode
import io.pubstar.mobile.ads.pub.PubStarAdManager


class SplashActivity : ComponentActivity() {

    private val splashScreen by lazy {
        installSplashScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen.setKeepOnScreenCondition { true }
        super.onCreate(savedInstanceState)
        PubStarAdManager.getInstance()
            .setIsDebug(true)
            .setInitAdListener(object : InitAdListener {
                override fun onDone() {
                    Log.d("TQC", "onDone")
                    splashScreen.setKeepOnScreenCondition { false }
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }

                override fun onError(code: ErrorCode) {
                    ToastObject.show(this@SplashActivity, "onError : $code")
                    Log.d("TQC", "onError : $code")
                }


            }).init(this)
    }
}