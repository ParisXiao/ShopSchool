package com.liuzhi.eschool.view.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.webkit.CookieSyncManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.liuzhi.eschool.MainActivity
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.constants.UserInfoConstans
import com.liuzhi.eschool.entity.ImgCodeEntity
import com.liuzhi.eschool.entity.convert.ImgCodeConvert
import com.liuzhi.eschool.utils.common.*
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class StartActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = View.inflate(this, R.layout.activity_start, null)
        setTheme(R.style.LancherTheme)
        setContentView(view)
        TranslucentFlag()
        // 渐变展示启动屏
        val aa = AlphaAnimation(0.5f, 1.0f)
        aa.duration = 1000
        RxPermissions(this)
            .requestEach(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
            .subscribe(object : DisposableObserver<Permission>() {
                override fun onNext(permission: Permission) {
                    if (permission.granted) {
                        //同意了这个权限
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                    } else {
                        // 用户拒绝了该权限，并且选中『不再询问』
                    }
                }

                override fun onError(e: Throwable) {}

                override fun onComplete() {
                    view.startAnimation(aa)
                }
            })


        aa.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                AppUpdataUtil.appUpdata(this@StartActivity, object : AppUpdataUtil.UpdataInter {
                    override fun isLastVersion() {
                        if(SPUtils.getInstance().getString(this@StartActivity,UserInfoConstans.USERID).isNotEmpty()){
                            getImgCode()
                        }else{
                            var intent = Intent(this@StartActivity, LoginActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }

                    }

                    override fun newVersion(appsize: String?, version: String?, path: String?) {
                        SweetAlertDialog(this@StartActivity, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("发现新版本")
                            .setContentText("是否更新到最新版本")
                            .setConfirmText("确定")
                            .setCancelText("取消")
                            .setConfirmClickListener { sDialog ->
                                sDialog.dismiss()
                                AppUpdataUtil.downLoadApk(this@StartActivity,path)
                            }
                            .setCancelClickListener { sDialog ->
                                sDialog.dismiss()
                                finish()
                                System.exit(0)
                            }
                            .show()
                    }

                })

            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationStart(animation: Animation) {}
        })

    }

    /**
     * 沉浸式状态栏适配
     */
    var setBlackBar = false

    private fun TranslucentFlag() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT//calculateStatusColor(Color.WHITE, (int) alphaValue)

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//6.0以上 全透明实现
            if (!setBlackBar) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }

        }

    }
    var imgCode=""
    fun getImgCode() {
        var imgCodeConvert = ImgCodeConvert()
        var imgCodeObservableResponse = ObservableResponse<ImgCodeEntity>();
        OkGo.post<ImgCodeEntity>(UrlConstans.ImgCodeGet)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .converter(imgCodeConvert)
            .adapt(imgCodeObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ImgCodeEntity>>() {
                override fun onNext(response: Response<ImgCodeEntity>) {

                    var entity = response.body()
                    if (entity != null && entity.code == 0) {
                        imgCode=entity.data.stringCode
                        login(SPUtils.getInstance().getString(this@StartActivity,UserInfoConstans.USERID),SPUtils.getInstance().getString(this@StartActivity,UserInfoConstans.USERPASSWORD),imgCode)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)

                }

                override fun onComplete() {
                }
            })
    }

    fun login(userId: String, password: String, imgCode: String) {
        OkGo.post<String>(UrlConstans.Login)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("userName", userId)
            .params("userPass", password)
            .params("regCode", imgCode)
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    Log.e("OKGO", response.body().toString())
                    var jsonObject = JSONObject(response.body())
                    if (jsonObject.optInt("code") == 0) {
                        var data = jsonObject.optString("data")
                        var jsonObject1 = JSONObject(data)
                        var LZSESSIONID = jsonObject1.optString("LZSESSIONID")
                        SPUtils.getInstance().set(this@StartActivity, UserInfoConstans.CookieId, LZSESSIONID)
                        SPUtils.getInstance().set(this@StartActivity, UserInfoConstans.USERID, userId)
                        SPUtils.getInstance().set(this@StartActivity, UserInfoConstans.USERPASSWORD, password)
                        CookieSyncManager.createInstance(getApplicationContext())
                        var intent = Intent(this@StartActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()

                    } else {
                        var intent = Intent(this@StartActivity, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@StartActivity).dismisDialog()
                }
            })
    }
}