# PubStar Android Mobile AD SDK

PubStar Android Mobile AD SDK is a comprehensive software development kit designed to empower developers with robust tools and functionalities for integrating advertisements seamlessly into Android mobile applications. Whether you're a seasoned developer or a newcomer to the world of app monetization, our SDK offers a user-friendly solution to maximize revenue streams while ensuring a non-intrusive and engaging user experience.

## Installation

Setting repository.

```bash
repositories {
  mavenCentral()
  maven { url = uri("https://artifactory.appodeal.com/appodeal") }
}
```

Dependency .

```bash
implementation 'io.pubstar.mobile:ads:1.1.7'
```

Add Key to AndroidManifest.

```bash
<meta-data
  android:name="io.pubstar.key"
  android:value="pub-app-id-XXXX" />
```


## Usage

## Init SDK

```python

PubStarAdManager.getInstance()
            .setInitAdListener(object : InitAdListener {
                override fun onDone() {
                    // callback when init done (ready to call load and show ad)
                }

                override fun onError(code: ErrorCode) {
                // callback when init error
                }


            }).init(context)
```

## Load AD

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
    // with no callback
    pubStarAdController.load(context,"id")
    
    // with callback
    val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }
    
    pubStarAdController.load(context,"id",adNetLoaderListener)
    
    // with builder
        val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }
    pubStarAdController.load("id", AdRequest.Builder(context)
                .isAllowLoadNext(true) // allow load to cache after dismiss
                .adLoaderListener(adNetLoaderListener)
                .build())
       
```
## Show AD

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
    // with no callback
    pubStarAdController.show(context,"id",view) // view has optional
    
    // with callback
    val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
    
    
    pubStarAdController.show(context,"id",view,adNetShowListener) // view has optional
    
    // with builder
    val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
    pubStarAdController.show("id", AdRequest.Builder(context)
                .isAllowLoadNext(true) // allow load to cache after dismiss
                .adShowedListener(adNetShowListener)
                .withView(view) // view has optional
                .build())       
```

## Load And Show AD

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
    // with no callback
    pubStarAdController.loadAndShow(context,"id",view) // view has optional
    
    // with callback
    val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }

   val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }    
    
    pubStarAdController.loadAndShow(context,"id",view,adNetLoaderListener,adNetShowListener) // view has optional
    
    // with builder
    val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
   val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }       
    pubStarAdController.loadAndShow("id", AdRequest.Builder(context)
                .isAllowLoadNext(true) // allow load to cache after dismiss
                .adShowedListener(adNetShowListener)
                .adLoaderListener(adNetLoaderListener)                
                .withView(view) // view has optional
                .build())       
```

## Custom Banner

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
     val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
   val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }       

    val requestBanner = BannerAdRequest.Builder(context)
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null)) // change color loading button CTA
                .withView(view)
                .backgroundResource(ResourcesCompat.getDrawable(resources,R.drawable.custom_bg_color,null)) // change color background when loading
                .adLoaderListener(adNetLoaderListener)
                .tag(BannerAdRequest.AdTag.Small)  // change type of banner has "Big" , "Medium" ,"Small" or "Collapsible"              
                .adShowedListener(adNetShowListener)
                .build()

  
    pubStarAdController.loadAndShow("1233/99228313581", requestBanner)       
```

## Custom Native

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
     val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide with reward option
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
   val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }       

    val requestNative = NativeAdRequest.Builder(context)
                .sizeType(NativeAdRequest.Type.Big) // change size of native has "Big" , "Medium" ,"Small"
                .colorCTA(ResourcesCompat.getColor(resources,R.color.purple_200,null)) // change color loading & button CTA
                .backgroundResource(ResourcesCompat.getDrawable(resources,R.drawable.custom_bg_color,null)) // change color background
                .withView(view) 
                .adLoaderListener(adNetLoaderListener)
                .adShowedListener(adNetShowListener)
                .build()

  
    pubStarAdController.loadAndShow("id", requestNative)       
```

## Custom Video

```python
    val pubStarAdController by lazy {
        PubStarAdManager.getAdController()
    }
     val adNetShowListener = object : AdShowedListener {
            override fun onAdShowed() {
                // callback when ad showed
            }

            override fun onAdHide(any: RewardModel?) {
                // callback when ad hide
            }

            override fun onError(code: ErrorCode) {
                // callback when error
            }

    }
   val adNetLoaderListener = object : AdLoaderListener {
            override fun onLoaded() {
                // callback when ad loaded
            }

            override fun onError(code: ErrorCode) {
                // callback when ad load code
            }

    }       

    pubStarAdController.loadAndShow(
        "1233/99228313585", IMARequest.Builder(this)
            .withType(IMARequest.Type.OUT_STREAM) // change type has "OUT_STREAM" ,"IN_STREAM"
            .withSize(IMARequest.Size.Medium) // change size of "Medium" ,"Full" only supports OUT_STREAM
            .withView(binding.nativeAd)
            .adLoaderListener(adNetLoaderListener)
            .adShowedListener(adNetShowListener)            
            .build()
    )    
```

## ID Test AD

```python
App ID : pub-app-id-1233
Banner Id : 1233/99228313580
Native ID : 1233/99228313581
Interstitial ID : 1233/99228313582
Open ID : 1233/99228313583
Rewarded ID : 1233/99228313584
Video ID : 1233/99228313585
```

## License
[Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/)
