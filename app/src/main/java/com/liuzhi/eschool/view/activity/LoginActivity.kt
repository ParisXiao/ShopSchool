package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.os.Build
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import com.liuzhi.eschool.MainActivity
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.constants.UserInfoConstans
import com.liuzhi.eschool.entity.ImgCodeEntity
import com.liuzhi.eschool.entity.convert.ImgCodeConvert
import com.liuzhi.eschool.utils.common.BitmapUtils
import com.liuzhi.eschool.utils.common.BtnClickUtils
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.utils.common.SPUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Cookie
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            login_btn -> {
                if (BtnClickUtils.isDouableClick()) return
                var userId = input_edit_userid.text.toString().trim()
                var password = input_edit_password.text.toString().trim()
                var imgCode = input_edit_imgcode.text.toString().trim()
                if (userId.isEmpty()) {
                    DialogUtils.getInstance(this@LoginActivity).shortToast("请输入学籍号")
                    return
                }
                if (password.isEmpty()) {
                    DialogUtils.getInstance(this@LoginActivity).shortToast("请输入密码")
                    return
                }
                if (imgCode.isEmpty()) {
                    DialogUtils.getInstance(this@LoginActivity).shortToast("请输入验证码")
                    return
                }
                DialogUtils.getInstance(this@LoginActivity).showLoadDialog("正在验证登录信息...")
                Observable.timer(1,TimeUnit.SECONDS).subscribe(Consumer {
                    login(userId, password, imgCode)
                })

            }
            login_forget_password -> {
                if (BtnClickUtils.isDouableClick()) return
                startActivity(Intent(this@LoginActivity, ForgetPasswordActivity::class.java))
            }
            login_register -> {
                if (BtnClickUtils.isDouableClick()) return
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
            login_password_show -> {
                if (isPasswordShow) {
                    login_password_show.setImageDrawable(resources.getDrawable(R.drawable.login_eye))
                    input_edit_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    isPasswordShow = false
                } else {
                    login_password_show.setImageDrawable(resources.getDrawable(R.drawable.login_eye_open))
                    input_edit_password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    isPasswordShow = true
                }
            }
            login_clear_id -> {
                input_edit_userid.setText("")
            }
            login_imgcode_show -> {
                getImgCode()
            }

        }
    }

    private var isPasswordShow = false
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        login_btn.setOnClickListener(this)
        login_forget_password.setOnClickListener(this)
        login_register.setOnClickListener(this)
        login_clear_id.setOnClickListener(this)
        login_password_show.setOnClickListener(this)
        login_imgcode_show.setOnClickListener(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            login_password_show.visibility = View.GONE
        }
        if (!TextUtils.isEmpty(SPUtils.getInstance().getString(this@LoginActivity, UserInfoConstans.USERID))) {
            input_edit_userid.setText(SPUtils.getInstance().getString(this@LoginActivity, UserInfoConstans.USERID))
        }
        if (!TextUtils.isEmpty(SPUtils.getInstance().getString(this@LoginActivity, UserInfoConstans.USERPASSWORD))) {
            input_edit_password.setText(
                SPUtils.getInstance().getString(
                    this@LoginActivity,
                    UserInfoConstans.USERPASSWORD
                )
            )
        }

        input_edit_userid.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    login_clear_id.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun initData() {
        getImgCode()

    }

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
                        login_imgcode_show.setImageBitmap(BitmapUtils.stringToBitmap(entity.data.imgCode))
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
                        DialogUtils.getInstance(this@LoginActivity).shortToast("登陆成功")
                        var intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                        SPUtils.getInstance().set(this@LoginActivity, UserInfoConstans.CookieId, LZSESSIONID)
                        SPUtils.getInstance().set(this@LoginActivity, UserInfoConstans.USERID, userId)
                        SPUtils.getInstance().set(this@LoginActivity, UserInfoConstans.USERPASSWORD, password)
                        CookieSyncManager.createInstance(getApplicationContext())
//                        var  cookieManager =CookieManager.getInstance()
//                        var cookies :MutableList<Cookie> = ArrayList()
//                        cookies= OkGo.getInstance().cookieJar.cookieStore.allCookie
//                        for (i in cookies.iterator() ) {
//                            var cookie = i
//                            var cookieString = cookie.name() + "=" + cookie.value() + "; domain=" + cookie.domain()
//                            cookieManager.setCookie(UserInfoConstans.cookiedomain, cookieString)
//                        }
//
//                        CookieSyncManager.getInstance().sync()
                    } else {
                        DialogUtils.getInstance(this@LoginActivity).shortToast("登陆失败：" + jsonObject.optString("msg"))
                        getImgCode()
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@LoginActivity).dismisDialog()
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        DialogUtils.getInstance(this@LoginActivity).dismisDialog()
    }
}