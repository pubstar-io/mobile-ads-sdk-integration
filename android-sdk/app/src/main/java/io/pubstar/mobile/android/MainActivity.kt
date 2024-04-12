package io.pubstar.mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.pubstar.mobile.ads.pub.PubStarAdManager
import io.pubstar.mobile.android.databinding.ActivityMainBinding


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
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.Admob)
        }
        binding.btnFan.setOnClickListener {
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.Fan)
        }
        binding.btnMax.setOnClickListener {
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.MAX)
        }
        binding.btnPangle.setOnClickListener {
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.Pangle)
        }
        binding.btnUnity.setOnClickListener {
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.Unity)
        }
        binding.btnAll.setOnClickListener {
            NetworkAdsActivity.startNet(this, NetworkAdsActivity.NetType.All)
        }

    }
}
