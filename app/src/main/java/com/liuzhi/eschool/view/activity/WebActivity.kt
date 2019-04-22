package com.liuzhi.eschool.view.activity

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.layout_title.*

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
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWeb() {
        //声明WebSettings子类
        val webSettings = html_web!!.settings

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
//        html_web!!.addJavascriptInterface(JsInteration(), "app")
        html_web!!.loadUrl(htmlUrl)

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

}