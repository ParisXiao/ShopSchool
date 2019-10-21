package com.liuzhi.eschool.view.fragment

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.EditText
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.constants.UserInfoConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.AllProjectConvert
import com.liuzhi.eschool.entity.convert.ClassDetailByIdConvert
import com.liuzhi.eschool.entity.convert.ProjectColumConvert
import com.liuzhi.eschool.entity.convert.ProjectDetailByIdConvert
import com.liuzhi.eschool.utils.common.NetWorkUtil
import com.liuzhi.eschool.utils.common.SPUtils
import com.liuzhi.eschool.view.activity.*
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_train_template.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import okhttp3.Cookie
import okhttp3.HttpUrl


class HomeFragment : BaseFragment() {
    val TAG: String = "WebView"
    var mWebSettings: WebSettings? = null
    var home_web: WebView? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View) {
        home_web = view.findViewById(R.id.home_web) as WebView?
        view.edit_home_search.setOnClickListener {
            var intent = Intent(activity, SearchActivity::class.java)
            intent.putExtra("SearchType", 0)
            startActivity(intent)
        }
    }

    override fun initData() {

        initWeb()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWeb() {
        //声明WebSettings子类
        val webSettings = home_web!!.settings

        //如果访问的页面中要与Javascript交互，则webView必须设置支持Javascript
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
        webSettings.javaScriptEnabled = true
        // 设置允许JS弹窗
        webSettings.javaScriptCanOpenWindowsAutomatically = true

        //设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true //将图片调整到适合webView的大小
        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。
        webSettings.builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件

        //其他细节操作
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8"//设置编码格式
        //缓存相关
        if (NetWorkUtil.isNetworkAvailable(context)) {
            //有网络，则加载网络地址
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT)//设置缓存模式LOAD_CACHE_ELSE_NETWORK
        } else {
            //无网络，则加载缓存路径
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        }
        // 特别注意：5.1以上默认禁止了https和http混用，以下方式是开启
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        //使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        home_web!!.setWebViewClient(object : WebViewClient() {
            override fun onLoadResource(view: WebView?, url: String?) {
                Log.i(TAG, "Resource  $url")
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Log.i(TAG, "开始加载:  $url")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                Log.i(TAG, "结束加载:  $url")
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                //加载失败，显示本地网页
                Log.i(TAG, "errorCode: $errorCode   $failingUrl")
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                // 如果实现调用了handler.proceed()来忽略该证书错误，则会受到中间人攻击的威胁，可能导致隐私泄露
                //修复方式：
                //【1】不调用android.webkit.SslErrorHandler的proceed方法
                //【2】当发生证书认证错误时，采用默认的处理方法SslErrorHandler.cancel()，停止加载问题页面
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return super.shouldOverrideUrlLoading(view, url)
            }
        })
        home_web!!.setWebChromeClient(object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                Log.i(TAG, "title: $title   ${view?.url}")
            }

            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {

            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                Log.i(TAG, "progress: $newProgress   ${view?.url}")
            }

            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                //警告框
                AlertDialog.Builder(activity)
                    .setTitle("提醒")
                    .setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setCancelable(false)
                    .show()
                return true
            }

            override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                //确认框
                AlertDialog.Builder(activity)
                    .setTitle("注意")
                    .setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                    .setCancelable(false)
                    .show()
                return true
            }

            override fun onJsPrompt(
                view: WebView?, url: String?, message: String?, defaultValue: String?,
                result: JsPromptResult?
            ): Boolean {
                //输入框
                AlertDialog.Builder(activity)
                    .setTitle(message)
                    .setView(EditText(activity))
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                    .setCancelable(false)
                    .show()
                return true
            }
        })
        home_web!!.addJavascriptInterface(JsInteration(), "app")
        home_web!!.loadUrl("file:///android_asset/index.html")

    }


    override fun onDestroy() {
        if (home_web != null) {
            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，
            //需要先onDetachedFromWindow()，再destory()
            val parent = home_web!!.parent
            if (parent != null) {
                (parent as ViewGroup).removeView(home_web)
            }
            home_web!!.stopLoading()
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            home_web!!.settings.javaScriptEnabled = false
            home_web!!.clearHistory()
            home_web!!.removeAllViews()
            home_web!!.destroy()

        }
        super.onDestroy()
    }

    inner class JsInteration {
        var intent: Intent = Intent(activity, ProjectListActivity::class.java)
        @JavascriptInterface
        fun divReturn(divId: Int) {
            Log.e(TAG, "divId$divId")
            when (divId) {
                0 -> {
                    getProjectColumn("PTGK")
                }
                1 -> {
                    var intent = Intent(activity, MineListActivity::class.java)
                    intent.putExtra("MineListType", 1)
                    activity.startActivity(intent)
                }
                2 -> {
                    var tt =Intent(activity,FZSXDetailActivity::class.java)
                    activity.startActivity(tt)

                }
                3 -> {
                    intent.putExtra("ProjectName", "XNFZSFXM")
                    activity.startActivity(intent)
                }
                4 -> {
                    intent.putExtra("ProjectName", "CYFH")
                    activity.startActivity(intent)
                }
                5 -> {
                    intent.putExtra("ProjectName", "XKJS")
                    activity.startActivity(intent)
                }
                6 -> {
                    intent.putExtra("ProjectName", "XQHZ")
                    activity.startActivity(intent)
                }
                7 -> {
                    var intent = Intent(activity, MineListActivity::class.java)
                    intent.putExtra("MineListType", 5)
                    activity.startActivity(intent)
                }
            }
        }

        @JavascriptInterface
        fun netsReturn(netId: Int) {
            Log.e(TAG, "netId$netId")

        }

        @JavascriptInterface
        fun newsReturn(newsId: String, newLink: String) {
            Log.e(TAG, "newsId$newsId  newLink$newLink")
            var intentWeb = Intent(activity, WebActivity::class.java)
            intentWeb.putExtra("WebTitle", "新闻详情")
            intentWeb.putExtra("WebHtml", UrlConstans.BaseUrl + "/html/text/" + newsId + ".html")
            startActivity(intentWeb)
        }

        @JavascriptInterface
        fun newMore() {
            var intentWeb = Intent(activity, NewsListActivity::class.java)
            startActivity(intentWeb)
        }

        @JavascriptInterface
        fun XKJSMore(code: Int) {
            Log.e(TAG, "XKJSMore")
            if (code == 0) {
                intent.putExtra("ProjectName", "XKJS")
                activity.startActivity(intent)
            } else {
                intent.putExtra("ProjectName", "CYFH")
                activity.startActivity(intent)
            }

        }

        @JavascriptInterface
        fun XKJSReturn(id: String) {
//            630857371081510912
            Log.e(TAG, "XKJSReturn$id")
            Log.e(TAG, "XKJSMore")
            getProjectById(id)
        }

        @JavascriptInterface
        fun CYFHReturn(id: String) {
//            630598952319717376
            Log.e(TAG, "XKJSReturn$id")
            Log.e(TAG, "XKJSMore")
            getProjectById(id)
        }

        @JavascriptInterface
        fun XXSYSMore() {
            Log.e(TAG, "XXSYSMore")
            intent.putExtra("ProjectName", "XXSYS")
            activity.startActivity(intent)
        }

        @JavascriptInterface
        fun XXSYSReturn(id: String) {
            Log.e(TAG, "XXSYSReturn$id")
            getProjectById(id)
        }

        @JavascriptInterface
        fun XNFZMore() {
            Log.e(TAG, "XNFZMore")
            intent.putExtra("ProjectName", "XNFZSFXM")
            activity.startActivity(intent)
        }

        @JavascriptInterface
        fun XNFZReturn(id: String) {
            Log.e(TAG, "XNFZReturn$id")
            getProjectById(id)
        }

//        @JavascriptInterface
//        fun XXZYMore() {
//            Log.e(TAG, "XXZYMore")
//        }

        @JavascriptInterface
        fun XXZYReturn(id: String) {
            Log.e(TAG, "XXZYReturn$id")
            getClassDetailById(id.toLong())
        }
    }

    fun getClassDetailById(id: Long) {
        var classDetailByIdConvert = ClassDetailByIdConvert()
        var detailByIdObservableResponse = ObservableResponse<ClassDetailByIdEntity>()
        OkGo.get<ClassDetailByIdEntity>(UrlConstans.LessonDetailById)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("lsId", id)
            .converter(classDetailByIdConvert)
            .adapt(detailByIdObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassDetailByIdEntity>>() {
                override fun onNext(response: Response<ClassDetailByIdEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity != null) {
                        if (entity.code == 0) {
                            var classDetail = ClassDetailEntity.ResultListBean()
                            classDetail.lsName = entity.data.lessonInfo.lsName
                            classDetail.lsCreateUName = entity.data.lessonInfo.lsCreateUName
                            classDetail.lsCreateTime = entity.data.lessonInfo.lsCreateTime
                            classDetail.lsDscb = entity.data.lessonInfo.lsDscb
                            classDetail.lsImg = entity.data.lessonInfo.lsImg
                            classDetail.lsId = entity.data.lessonInfo.lsId
                            var intent = Intent(activity, ClassDetailActivity::class.java)
                            intent.putExtra("LessonDetail", classDetail)
                            startActivity(intent)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {

                }
            })
    }

    fun getProjectById(id: String) {
        var projectDetailByIdConvert = ProjectDetailByIdConvert()
        var projectDetailByIdResponse = ObservableResponse<ProjectDetailByIdEntity>()
        OkGo.get<ProjectDetailByIdEntity>(UrlConstans.ColInfo)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colId", id)
            .converter(projectDetailByIdConvert)
            .adapt(projectDetailByIdResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectDetailByIdEntity>>() {
                override fun onNext(response: Response<ProjectDetailByIdEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity.code == 0) {
                        var bean = AllProjectEntity.DataBean()
                        bean.colName = entity.data.leftMenu[0].colName
                        bean.colReleaseTime = entity.data.leftMenu[0].colReleaseTime
                        bean.colStopTime = entity.data.leftMenu[0].colStopTime
                        bean.colImg = entity.data.leftMenu[0].colImg
                        bean.colDesc = entity.data.leftMenu[0].colDesc
                        bean.colId = entity.data.leftMenu[0].colId
                        var intent = Intent(activity, ProjectDetailActivity::class.java)
                        intent.putExtra("ProjectBean", bean)
                        startActivity(intent)
                        return
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                }
            })
    }

    fun getProjectColumn(projectName: String) {
        var projectColumConvert = ProjectColumConvert()
        var projectColumResponse = ObservableResponse<ProjectColumEntity>()
        OkGo.get<ProjectColumEntity>(UrlConstans.ProjectColumn)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colSign", projectName)
            .converter(projectColumConvert)
            .adapt(projectColumResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectColumEntity>>() {
                override fun onNext(response: Response<ProjectColumEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity.code == 0) {
                        var intentWeb = Intent(activity, WebActivity::class.java)
                        intentWeb.putExtra("WebTitle", "平台概况")
                        intentWeb.putExtra(
                            "WebHtml",
                            UrlConstans.BaseUrl + "/html/column/" + entity.data[0].colId + ".html"
                        )
                        startActivity(intentWeb)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)

                }

                override fun onComplete() {
                }
            })
    }
}