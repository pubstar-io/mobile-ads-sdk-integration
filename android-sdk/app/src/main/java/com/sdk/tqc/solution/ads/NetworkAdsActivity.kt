package com.sdk.tqc.solution.ads

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.content.res.ResourcesCompat
import com.sdk.tqc.solution.ads.databinding.ActivityNetBinding
import io.pubstar.mobile.ads.base.BannerAdRequest
import io.pubstar.mobile.ads.base.NativeAdRequest
import io.pubstar.mobile.ads.interfaces.AdLoaderListener
import io.pubstar.mobile.ads.interfaces.AdShowedListener
import io.pubstar.mobile.ads.model.ErrorCode
import io.pubstar.mobile.ads.model.RewardModel
import io.pubstar.mobile.ads.pub.PubStarAdManager

class NetworkAdsActivity : ComponentActivity() {
    private lateinit var binding : ActivityNetBinding


    enum class NetType {
        Admob,
        Fan,
        MAX,
        Unity,
        Pangle,
        All
    }


    private val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }

    private val type by lazy {
        (intent.getSerializableExtra(TAG_NET_TYPE) as?  NetType) ?: NetType.Admob
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefix = "_" + type.name
        binding.tvNetName.text = type.name
        when(type) {
            NetType.Unity -> {
                binding.containerNative.visibility = View.GONE
                binding.btnShowOpen.visibility = View.GONE
            }
            else -> {

            }
        }
        val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                ToastObject.show(this@NetworkAdsActivity,"onLoaded")
            }

            override fun onError(code: ErrorCode) {
                ToastObject.show(this@NetworkAdsActivity,"onLoadedError : "+code.name)
            }

        }
        val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                ToastObject.show(this@NetworkAdsActivity,"onAdShowed")
            }

            override fun onAdHide(any: RewardModel?) {
                ToastObject.show(this@NetworkAdsActivity,"onAdHide : "+any?.type)
            }

            override fun onError(code: ErrorCode) {
                ToastObject.show(this@NetworkAdsActivity,"onShowedError : "+code.name)
            }

        }
        binding.btnShowBanner.setOnClickListener {
            val requestNative = BannerAdRequest.Builder(this)
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_banner_ad$prefix", requestNative)
        }
        binding.btnShowNativeMedium.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Medium)
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad$prefix", requestNative)
        }
        binding.btnShowNativeSmall.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Small)
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad$prefix", requestNative)
        }
        binding.btnShowNativeBig.setOnClickListener {
            val requestNative = NativeAdRequest.Builder(this)
                .sizeType(NativeAdRequest.Type.Big)
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null))
                .withView(binding.nativeAd)
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()
            pubStarAdController.loadAndShow("test_native_ad$prefix", requestNative)
        }
        binding.btnShowReward.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_reward_ad$prefix",null,adNetLoaderListener,adNetShowListener)
        }
        binding.btnShowInter.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_inter_ad$prefix",null,adNetLoaderListener,adNetShowListener)
        }
        binding.btnShowOpen.setOnClickListener {
            pubStarAdController.loadAndShow(this,"test_open_ad$prefix")
        }
    }

    companion object {
        private const val TAG_NET_TYPE = "net_type"
        fun startNet(context : Context,netType: NetType) {
            context.startActivity(Intent(context,NetworkAdsActivity::class.java).apply {
                putExtra(TAG_NET_TYPE,netType)
            })
        }
    }


}