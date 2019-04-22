package com.liuzhi.eschool.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.EditText
import com.liuzhi.eschool.R
import com.liuzhi.eschool.view.activity.ProjectListActivity


class HomeFragment : BaseFragment() {
    val TAG: String = "WebView"
    var mWebSettings: WebSettings? = null
    var home_web: WebView? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View) {
        home_web = view.findViewById(R.id.home_web) as WebView?
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
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webView中缓存
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8"//设置编码格式

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
                    .setTitle("JsAlert")
                    .setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setCancelable(false)
                    .show()
                return true
            }

            override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                //确认框
                AlertDialog.Builder(activity)
                    .setTitle("JsConfirm")
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
         var intent: Intent=Intent(activity, ProjectListActivity::class.java)
        @JavascriptInterface
        fun divReturn(divId: Int) {
            Log.e(TAG, "divId$divId")
            when (divId) {
                0->{

                }
                1->{

                }
                2 -> {
                    intent.putExtra("ProjectName", "FZSX")
                    activity.startActivity(intent)
                }
                3 -> {
                    intent.putExtra("ProjectName", "XNFZ")
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
            }
        }

        @JavascriptInterface
        fun netsReturn(netId: Int) {
            Log.e(TAG, "netId$netId")
        }

        @JavascriptInterface
        fun newsReturn(newsId: String, newLink: String) {
            Log.e(TAG, "newsId$newsId  newLink$newLink")
        }

        @JavascriptInterface
        fun newMore() {
            Log.e(TAG, "newMore")
        }

        @JavascriptInterface
        fun XKJSMore() {
            Log.e(TAG, "XKJSMore")
            intent = Intent(activity, ProjectListActivity::class.java)
            intent.putExtra("ProjectName", "XKJS")
            activity.startActivity(intent)
        }

        @JavascriptInterface
        fun XKJSReturn(id: String) {
            Log.e(TAG, "XKJSReturn$id")
        }

        @JavascriptInterface
        fun XXSYSMore() {
            Log.e(TAG, "XXSYSMore")
            intent = Intent(activity, ProjectListActivity::class.java)
            intent.putExtra("ProjectName", "XKJS")
            activity.startActivity(intent)
        }

        @JavascriptInterface
        fun XXSYSReturn(id: String) {
            Log.e(TAG, "XXSYSReturn$id")
        }

        @JavascriptInterface
        fun XNFZMore() {
            Log.e(TAG, "XNFZMore")
            intent.putExtra("ProjectName", "FZSX")
            activity.startActivity(intent)
        }

        @JavascriptInterface
        fun XNFZReturn(id: String) {
            Log.e(TAG, "XNFZReturn$id")
        }

        @JavascriptInterface
        fun XXZYMore() {
            Log.e(TAG, "XXZYMore")
        }

        @JavascriptInterface
        fun XXZYReturn(id: String) {
            Log.e(TAG, "XXZYReturn$id")
        }
    }
}