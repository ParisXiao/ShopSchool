package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.CountDownTimer
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ProjectColumEntity
import com.liuzhi.eschool.entity.convert.ProjectColumConvert
import com.liuzhi.eschool.utils.common.BtnClickUtils
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.utils.common.PhoneUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_forgetpassword.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject

class ForgetPasswordActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            forget_send_code -> {
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                if (input_edit_forget_id.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入学籍号")
                    return
                }
                if (input_edit_forget_phone.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入邮箱地址")
                    return
                }
                if (!PhoneUtils.isEmail(input_edit_forget_phone.text.toString().trim())) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入正确的邮箱地址")
                    return
                }
                //获取验证码接口
                time?.start()
                getMailCode(input_edit_forget_id.text.toString().trim(), input_edit_forget_phone.text.toString())
            }
            forget_commit -> {
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                if (input_edit_forget_phone.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入邮箱地址")
                    return
                }
                if (input_edit_forget_safecode.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入验证码")
                    return
                }
                if (input_edit_forget_newpassword.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入新密码")
                    return
                }
                if (input_edit_forget_newpassword.text.toString().trim().length < 6) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请至少输入6位密码")
                    return
                }
                if (input_edit_forget_safecode.text.toString() != aAddress) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("验证码错误")
                    return
                }
                DialogUtils.getInstance(this@ForgetPasswordActivity).showLoadDialog("正在提交...")
                //忘记密码提交接口
                setForget(input_edit_forget_newpassword.text.toString())
            }

        }
    }

    private var time: TimeCount? = null
    private var aId: String = ""
    private var aAddress: String = ""
    override fun getLayoutId(): Int {
        return R.layout.activity_forgetpassword
    }

    override fun initView() {

        title_name.text = "忘记密码"
        toolbar.setTitle("");
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        forget_send_code.setOnClickListener(this)
        forget_commit.setOnClickListener(this)

    }

    override fun initData() {
        time = TimeCount(60000, 1000)
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


    internal inner class TimeCount(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {

        override fun onFinish() {// 计时完毕
            forget_send_code.setText("重新发送验证码")
            forget_send_code.setClickable(true)
            forget_send_code.setTextColor(resources.getColor(R.color.c787878))
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        override fun onTick(millisUntilFinished: Long) {// 计时过程
            forget_send_code.setClickable(false)//防止重复点击
            forget_send_code.setTextColor(Color.RED)
            forget_send_code.setText((millisUntilFinished / 1000).toString() + "秒后重发")
        }
    }

    fun getMailCode(aUserName: String, aEmail: String) {
        OkGo.post<String>(UrlConstans.ForgotMail)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("aUserName", aUserName)
            .params("aEmail", aEmail)
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    Log.e("OKGO", response.body().toString())
                    var entity: JSONObject = JSONObject(response.body())
                    if (entity.optInt("code") == 0) {
                        var jsonObject: JSONObject = JSONObject(entity.optString("data"))
                        aId = jsonObject.optString("aId")
                        aAddress = jsonObject.optString("aAddress")
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)

                }

                override fun onComplete() {
                }
            })
    }

    fun setForget(aPassword: String) {
        OkGo.post<String>(UrlConstans.ForgotPassword)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("aId", aId)
            .params("aAddress", aAddress)
            .params("aPassword", aPassword)
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    Log.e("OKGO",response.body().toString())
                    var entity: JSONObject = JSONObject(response.body())

                    if (entity.optInt("code") == 0) {
                        DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("密码重置成功")
                        finish()
                    } else {
                        DialogUtils.getInstance(this@ForgetPasswordActivity)
                            .shortToast("密码重置失败：" + entity.optString("msg"))
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)

                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).dismisDialog()
                }
            })
    }
}