package io.pubstar.mobile.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.content.res.ResourcesCompat
import io.pubstar.mobile.ads.base.BannerAdRequest
import io.pubstar.mobile.ads.base.NativeAdRequest
import io.pubstar.mobile.ads.interfaces.AdLoaderListener
import io.pubstar.mobile.ads.interfaces.AdShowedListener
import io.pubstar.mobile.ads.model.ErrorCode
import io.pubstar.mobile.ads.model.RewardModel
import io.pubstar.mobile.ads.pub.PubStarAdManager
import io.pubstar.mobile.android.databinding.ActivityNetBinding

class NetworkAdsActivity : ComponentActivity() {
    private lateinit var binding : ActivityNetBinding


    private val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                ToastObject.show(this@NetworkAdsActivity, "onLoaded")
            }

            override fun onError(code: ErrorCode) {
                ToastObject.show(this@NetworkAdsActivity, "onLoadedError : " + code.name)
            }

        }
        val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                ToastObject.show(this@NetworkAdsActivity, "onAdShowed")
            }

            override fun onAdHide(any: RewardModel?) {
                ToastObject.show(this@NetworkAdsActivity, "onAdHide : " + any?.type)
            }

            override fun onError(code: ErrorCode) {
                ToastObject.show(this@NetworkAdsActivity, "onShowedError : " + code.name)
            }

        }
        binding.btnShowBanner.setOnClickListener {
            val requestNative = BannerAdRequest.Builder(this)
                .colorCTA(ResourcesCompat.getColor(resources, R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .tag(BannerAdRequest.AdTag.Collapsible)
                .build()
            pubStarAdController.loadAndShow("test_banner_ad", requestNative)
        }
        binding.btnShowNativeMedium.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Medium)
                .colorCTA(ResourcesCompat.getColor(resources, R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad", requestNative)
        }
        binding.btnShowNativeSmall.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Small)
                .colorCTA(ResourcesCompat.getColor(resources, R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad", requestNative)
        }
        binding.btnShowNativeBig.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Big)
                .colorCTA(ResourcesCompat.getColor(resources, R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad", requestNative)
        }
        binding.btnShowReward.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_reward_ad",null,adNetLoaderListener,adNetShowListener)
        }
        binding.btnShowInter.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_inter_ad",null,adNetLoaderListener,adNetShowListener)
        }
        binding.btnShowOpen.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_open_ad")
        }
    }

}