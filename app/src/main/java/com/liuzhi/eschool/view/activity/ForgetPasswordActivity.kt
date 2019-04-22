package com.liuzhi.eschool.view.activity

import android.graphics.Color
import android.os.Build
import android.os.CountDownTimer
import android.support.annotation.RequiresApi
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.utils.common.BtnClickUtils
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.utils.common.PhoneUtils
import kotlinx.android.synthetic.main.activity_forgetpassword.*
import kotlinx.android.synthetic.main.layout_title.*

class ForgetPasswordActivity:BaseActivity(),View.OnClickListener{
    override fun onClick(v: View?) {
        when(v){
            forget_send_code->{
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                if (input_edit_forget_phone.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity). shortToast("请输入手机号")
                    return
                }
                if(PhoneUtils.isMobile(input_edit_forget_phone.text.toString().trim())){
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请输入正确的手机号")
                }
                //获取验证码接口
                time?.start()
            }
            forget_commit->{
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                if (input_edit_forget_phone.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity). shortToast("请输入手机号")
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
                if (input_edit_forget_newpassword.text.toString().trim().length<6) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请至少输入6位密码")
                    return
                }
                if (!check_agreement.isChecked) {
                    DialogUtils.getInstance(this@ForgetPasswordActivity).shortToast("请同意服务使用协议")
                    return
                }
             DialogUtils.getInstance(this@ForgetPasswordActivity).showLoadDialog("正在提交...")
                //忘记密码提交接口
            }
            text_agreement->{
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                //打开协议详情
            }
        }
    }

    private var time: TimeCount? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_forgetpassword
    }

    override fun initView() {

        title_name.text="忘记密码"
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
        text_agreement.setOnClickListener(this)
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
}