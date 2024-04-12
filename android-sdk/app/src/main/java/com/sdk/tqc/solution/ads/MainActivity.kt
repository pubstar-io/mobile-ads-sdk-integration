package com.sdk.tqc.solution.ads

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.content.res.ResourcesCompat
import com.sdk.tqc.solution.ads.databinding.ActivityMainBinding
import io.pubstar.mobile.ads.base.BannerAdRequest
import io.pubstar.mobile.ads.base.NativeAdRequest
import io.pubstar.mobile.ads.interfaces.AdLoaderListener
import io.pubstar.mobile.ads.interfaces.AdShowedListener
import io.pubstar.mobile.ads.model.ErrorCode
import io.pubstar.mobile.ads.model.RewardModel
import io.pubstar.mobile.ads.pub.PubStarAdManager


class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding

    private val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdmob.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.Admob)
        }
        binding.btnFan.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.Fan)
        }
        binding.btnMax.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.MAX)
        }
        binding.btnPangle.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.Pangle)
        }
        binding.btnUnity.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.Unity)
        }
        binding.btnAll.setOnClickListener {
            NetworkAdsActivity.startNet(this,NetworkAdsActivity.NetType.All)
        }

    }
}
