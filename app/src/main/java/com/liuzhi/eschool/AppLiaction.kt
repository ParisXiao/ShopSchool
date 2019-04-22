package com.liuzhi.eschool

import android.app.Application
import com.google.gson.GsonBuilder
import com.liuzhi.eschool.gjson.*
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.cookie.CookieJarImpl
import com.lzy.okgo.cookie.store.DBCookieStore
import com.lzy.okgo.cookie.store.MemoryCookieStore
import com.lzy.okgo.cookie.store.SPCookieStore
import com.lzy.okgo.https.HttpsUtils
import com.threshold.rxbus2.RxBus
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class AppLiaction:Application(){
    override fun onCreate() {
        super.onCreate()
        initHttp()
        initRx()
    }
    fun initHttp(){
        var sslParams: HttpsUtils.SSLParams= HttpsUtils.getSslSocketFactory()
        var builder: OkHttpClient.Builder= OkHttpClient.Builder()
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
            .hostnameVerifier(HttpsUtils.UnSafeHostnameVerifier)
            .connectTimeout(15 , TimeUnit.SECONDS)
            .readTimeout(15 , TimeUnit.SECONDS)
            .writeTimeout(15 , TimeUnit.SECONDS)
            .cookieJar(CookieJarImpl(SPCookieStore(this)))
            .cookieJar(CookieJarImpl(DBCookieStore(this)))
            .cookieJar(CookieJarImpl(MemoryCookieStore()))
        OkGo.getInstance().init(this)                       //必须调用初始化
            .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
            .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
            .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE).retryCount = 2
    }
    fun initRx(){
        RxBus.setMainScheduler(AndroidSchedulers.mainThread())
        AppConsds.mGson = GsonBuilder()
            .registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
            .registerTypeAdapter(Int::class.javaPrimitiveType, IntegerDefault0Adapter())
            .registerTypeAdapter(Double::class.java, DoubleDefault0Adapter())
            .registerTypeAdapter(Double::class.javaPrimitiveType, DoubleDefault0Adapter())
            .registerTypeAdapter(Float::class.java, FloatDefault0Adapter())
            .registerTypeAdapter(Float::class.javaPrimitiveType, FloatDefault0Adapter())
            .registerTypeAdapter(Long::class.java, LongDefault0Adapter())
            .registerTypeAdapter(Long::class.javaPrimitiveType, LongDefault0Adapter())
            .create()
    }
}