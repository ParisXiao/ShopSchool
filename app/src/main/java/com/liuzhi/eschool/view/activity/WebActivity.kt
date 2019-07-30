package com.liuzhi.eschool.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.MenuItem
import android.view.ViewGroup
import android.webkit.*
import android.widget.EditText
import com.liuzhi.eschool.R
import com.lzy.okgo.OkGo
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.layout_title.*
import okhttp3.Cookie
import android.webkit.WebSettings.LayoutAlgorithm
import android.webkit.WebSettings.ZoomDensity
import android.util.DisplayMetrics



class WebActivity:BaseActivity(){
    val TAG: String = "WebView"
    var titleName=""
    var htmlUrl=""
    override fun getLayoutId(): Int {
        return R.layout.activity_web
    }

    override fun initView() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setBackgroundColor(resources.getColor(R.color.main_blue_color))
        title_name.setTextColor(resources.getColor(R.color.white))
    }

    override fun initData() {
        titleName=intent.getStringExtra("WebTitle")
        htmlUrl=intent.getStringExtra("WebHtml")
        title_name.text=titleName
        initWeb()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon_star touch event
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    @SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
    private fun initWeb() {
        //声明WebSettings子类
        val webSettings = html_web!!.settings

// User settings

        webSettings.javaScriptEnabled = true

        webSettings.javaScriptCanOpenWindowsAutomatically = true

        webSettings.useWideViewPort = true//关键点

        webSettings.layoutAlgorithm = LayoutAlgorithm.SINGLE_COLUMN

        webSettings.displayZoomControls = false

        webSettings.javaScriptEnabled = true // 设置支持javascript脚本

        webSettings.allowFileAccess = true // 允许访问文件

        webSettings.builtInZoomControls = true // 设置显示缩放按钮

        webSettings.setSupportZoom(true) // 支持缩放

        webSettings.loadWithOverviewMode = true

        val metrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(metrics)

        val mDensity = metrics.densityDpi

        Log.d("maomao", "densityDpi = $mDensity")

        if (mDensity == 240) {

            webSettings.defaultZoom = ZoomDensity.FAR

        } else if (mDensity == 160) {

            webSettings.defaultZoom = ZoomDensity.MEDIUM

        } else if (mDensity == 120) {

            webSettings.defaultZoom = ZoomDensity.CLOSE

        } else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {

            webSettings.defaultZoom = ZoomDensity.FAR

        } else if (mDensity == DisplayMetrics.DENSITY_TV) {

            webSettings.defaultZoom = ZoomDensity.FAR

        } else {

            webSettings.defaultZoom = ZoomDensity.MEDIUM

        }

        /**

         * 用WebView显示图片，可使用这个参数 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：

         * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放

         */

        webSettings.layoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS
        // 特别注意：5.1以上默认禁止了https和http混用，以下方式是开启
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        //使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        html_web!!.setWebViewClient(object : WebViewClient() {
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
        html_web!!.setWebChromeClient(object : WebChromeClient() {
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
                AlertDialog.Builder(this@WebActivity)
                    .setTitle("JsAlert")
                    .setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setCancelable(false)
                    .show()
                return true
            }

            override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                //确认框
                AlertDialog.Builder(this@WebActivity)
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
                AlertDialog.Builder(this@WebActivity)
                    .setTitle(message)
                    .setView(EditText(this@WebActivity))
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                    .setCancelable(false)
                    .show()
                return true
            }
        })
        html_web!!.addJavascriptInterface(JsInteration(), "app")
        syncCookie(this,htmlUrl)
        html_web!!.loadUrl(htmlUrl)

    }
    //在webView.loadUrl(url)之前调用此方法，否则无效
    private fun syncCookie(context: Context, url: String) {
        CookieSyncManager.createInstance(context)
        var cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.removeSessionCookie()
        var cookies: MutableList<Cookie> = ArrayList()
        cookies = OkGo.getInstance().cookieJar.cookieStore.allCookie
        for (i in cookies.iterator()) {
            var cookie = i
            var cookieString = cookie.name() + "=" + cookie.value() + "; domain=" + cookie.domain()
            cookieManager.setCookie(url, cookieString)
        }
        CookieSyncManager.getInstance().sync()
    }
    override fun onDestroy() {
        if (html_web != null) {
            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，
            //需要先onDetachedFromWindow()，再destory()
            val parent = html_web!!.parent
            if (parent != null) {
                (parent as ViewGroup).removeView(html_web)
            }
            html_web!!.stopLoading()
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            html_web!!.settings.javaScriptEnabled = false
            html_web!!.clearHistory()
            html_web!!.removeAllViews()
            html_web!!.destroy()

        }
        super.onDestroy()
    }
    inner class JsInteration {
        @JavascriptInterface
        fun submit() {
            finish()
        }
    }
}