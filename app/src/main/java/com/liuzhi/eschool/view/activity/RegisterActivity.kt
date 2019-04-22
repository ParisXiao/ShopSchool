package com.liuzhi.eschool.view.activity

import android.util.Log
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.utils.common.BtnClickUtils
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.utils.common.IDCardUtils
import com.liuzhi.eschool.utils.common.PhoneUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject

class RegisterActivity:BaseActivity(),View.OnClickListener{
    override fun onClick(v: View?) {
        when(v){
            btn_register->{
                if (BtnClickUtils.isDouableClick()) {
                    return
                }
                if (input_edit_reg_username.text.toString().trim().isNullOrEmpty()) {
                   DialogUtils.getInstance(this@RegisterActivity).shortToast("请输入用户名")
                    return
                }
                if (input_edit_reg_userid.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@RegisterActivity).shortToast("请输入学籍号")
                    return
                }
                if (input_edit_reg_password.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@RegisterActivity). shortToast("请输入密码")
                    return
                }
                if (input_edit_reg_password.text.toString().trim().length<6) {
                    DialogUtils.getInstance(this@RegisterActivity).shortToast("请至少输入6位密码")
                    return
                }
                if (input_edit_reg_usernum.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@RegisterActivity).shortToast("请输入身份证号")
                    return
                }
                if(!IDCardUtils.IDCardValidate(input_edit_reg_usernum.text.toString().trim()).equals("")){
                    DialogUtils.getInstance(this@RegisterActivity).shortToast("请输入正确身份证号")
                    return
                }
                if (input_edit_reg_phone.text.toString().trim().isNullOrEmpty()) {
                    DialogUtils.getInstance(this@RegisterActivity).shortToast("请输入手机号")
                    return
                }
                if(PhoneUtils.isEmail(input_edit_reg_phone.text.toString().trim())){
                    DialogUtils.getInstance(this@RegisterActivity). shortToast("请输入正确的手机号")
                    return
                }
                //注册接口
                DialogUtils.getInstance(this@RegisterActivity).showLoadDialog("正在注册...")
                regist(input_edit_reg_username.text.toString().trim(),input_edit_reg_userid.text.toString().trim(),
                    input_edit_reg_password.text.toString().trim(),input_edit_reg_usernum.text.toString().trim() ,input_edit_reg_phone.text.toString().trim())
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        title_name.text="注册"
        btn_register.setOnClickListener(this)
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

    override fun initData() {
    }
    fun regist(userName:String,userId:String,password:String,usrNum:String,phoneNum:String){
        btn_register.isEnabled=false
        OkGo.post<String>(UrlConstans.Register)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("aName",userName)
            .params("aUserName",userName)
            .params("stuNumber",userId)
            .params("aPassword",password)
            .params("aIdCode",usrNum)
            .params("aMobilePhone",phoneNum)
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    var jsonObject :JSONObject= JSONObject(response.body())
                    if (jsonObject.optInt("code") == 0) {
                        DialogUtils.getInstance(this@RegisterActivity).shortToast("注册成功")
                        finish()
                    }else{
                        DialogUtils.getInstance(this@RegisterActivity).shortToast("该用户名已被注册")
                        btn_register.isEnabled=true
                    }
                }
                override fun onError(e: Throwable) {
                    Log.e("OKGO",e.message)

                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@RegisterActivity).dismisDialog()
                }
            })
    }

}