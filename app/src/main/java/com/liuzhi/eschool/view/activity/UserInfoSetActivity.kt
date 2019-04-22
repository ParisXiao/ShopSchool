package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v4.content.FileProvider
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import com.liuzhi.eschool.BuildConfig
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.UserInfoEntity
import com.liuzhi.eschool.utils.common.*
import com.liuzhi.eschool.view.widget.CommonPopWindow
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_set.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject
import java.io.File
import java.net.URI
import java.net.URISyntaxException
import java.util.*


class UserInfoSetActivity:BaseActivity(),CommonPopWindow.ViewClickListener,View.OnClickListener{
    override fun onClick(p0: View?) {
        when(p0){
            rl_username->{
                set_username.isFocusable = true
            }
            rl_icon->{
                CommonPopWindow.newBuilder()
                    .setView(R.layout.pop_bottom)
                    .setAnimationStyle(R.style.AnimUp)
                    .setBackgroundDrawable(BitmapDrawable())
                    .setSize(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    .setViewOnClickListener(this)
                    .setBackgroundDarkEnable(true)
                    .setBackgroundAlpha(0.7f)
                    .build(this)
                    .showAsBottom(ll_main)
            }
            rl_name->{
                set_name.isFocusable = true
            }
            rl_phone->{
                set_phone.isFocusable = true
            }
            rl_email->{
                set_mail.isFocusable = true
            }
        }
    }

    lateinit var userInfoEntity:UserInfoEntity
    var photoCode=""

    //调用照相机返回图片文件
    private var tempFile: File? = null
    private var facePath = ""
    private var uritempFile: Uri? = null

    //相册请求码
    private val ALBUM_REQUEST_CODE = 1
    //相机请求码
    private val CAMERA_REQUEST_CODE = 2
    //剪裁请求码
    private val CROP_REQUEST_CODE = 3
    override fun getLayoutId(): Int {
        return R.layout.activity_user_set
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
        title_name.text="个人资料管理"
        userInfoEntity= intent.getSerializableExtra("UserInfo") as UserInfoEntity
        set_username.setText(userInfoEntity.getaName().toString())
        set_name.setText(userInfoEntity.getaUserName().toString())
        set_lession.setText(userInfoEntity.mjName)
        set_class.setText(userInfoEntity.stuClassName)
        set_phone.setText(userInfoEntity.getaMobilePhone().toString())
        set_mail.setText(userInfoEntity.getaEmail().toString())
        ImageUtils.setImageBitmapUrl(this@UserInfoSetActivity, set_icon, UrlConstans.BaseUrl + userInfoEntity.getaPhotoUrl())
        rl_username.setOnClickListener(this)
        rl_icon.setOnClickListener(this)
        rl_name.setOnClickListener(this)
        rl_phone.setOnClickListener(this)
        rl_email.setOnClickListener(this)
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
        set_icon.setOnClickListener {
            CommonPopWindow.newBuilder()
                .setView(R.layout.pop_bottom)
                .setAnimationStyle(R.style.AnimUp)
                .setBackgroundDrawable(BitmapDrawable())
                .setSize(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setViewOnClickListener(this)
                .setBackgroundDarkEnable(true)
                .setBackgroundAlpha(0.7f)
                .build(this)
                .showAsBottom(ll_main)
        }
        set_commit.setOnClickListener {
            DialogUtils.getInstance(this@UserInfoSetActivity).showLoadDialog("正在修改...")
            var name=set_name.text.toString().trim()
            var userName=set_username.text.toString().trim()
            var phone=set_phone.text.toString().trim()
            var mail=set_mail.text.toString().trim()
            if (name.isEmpty()){
                DialogUtils.getInstance(this).shortToast("请输入用户名")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            if (userName.isEmpty()){
                DialogUtils.getInstance(this).shortToast("请输入姓名")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            if (phone.isEmpty()){
                DialogUtils.getInstance(this).shortToast("请输入手机号码")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            if (mail.isEmpty()){
                DialogUtils.getInstance(this).shortToast("请输入邮箱地址")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            if (PhoneUtils.isMobile(phone)){
                DialogUtils.getInstance(this).shortToast("请输入正确手机号码")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            if (PhoneUtils.isMobile(mail)){
                DialogUtils.getInstance(this).shortToast("请输入正确邮箱地址")
                DialogUtils.getInstance(this).dismisDialog()
                return@setOnClickListener
            }
            updataUserInfo(photoCode,userName,name,mail,phone)
        }
    }
    fun updataUserInfo(aPhoto:String,aUserName:String,aName:String,aEmail:String,aMobilePhone:String){
        OkGo.post<String>(UrlConstans.UserCenter)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("aPhoto", aPhoto)
            .params("aUserName", aUserName)
            .params("aName", aName)
            .params("aEmail", aEmail)
            .params("aMobilePhone", aMobilePhone)
            .params("aId", userInfoEntity.getaId())
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    Log.e("OKGO", response.body())
                    var entity:JSONObject =JSONObject(response.body())


                    if (entity .optInt("code")==0) {
                        DialogUtils.getInstance(this@UserInfoSetActivity).shortToast("修改成功")
                    }else{
                        DialogUtils.getInstance(this@UserInfoSetActivity).shortToast("修改失败:"+entity.optString("msg"))
                    }


                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                    DialogUtils.getInstance(this@UserInfoSetActivity).shortToast("修改失败:"+e.message)
                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@UserInfoSetActivity).dismisDialog()
                }
            })
    }

   override fun getChildView(mPopupWindow: PopupWindow, view: View, layoutResId: Int) {
        when (layoutResId) {
            R.layout.pop_bottom -> {
                val btnTakePhoto = view.findViewById(R.id.btn_take_photo) as Button
                val btnSelectPhoto = view.findViewById(R.id.btn_select_photo) as Button
                val btnCancel = view.findViewById(R.id.btn_cancel) as Button
                btnTakePhoto.setOnClickListener(object : View.OnClickListener {
                   override fun onClick(v: View) {
                        mPopupWindow.dismiss()
                       getPicFromCamera()//调用相机
                   }
                })
                btnSelectPhoto.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        mPopupWindow.dismiss()
                        getPicFromAlbm()//调用相册
                    }
                })
                btnCancel.setOnClickListener(object : View.OnClickListener {
                  override  fun onClick(v: View) {
                        mPopupWindow.dismiss()
                    }
                })
            }
        }
    }

    /**
     * 回调接口
     *
     * @param requestCode
     * @param resultCode
     * @param intent
     */
   @RequiresApi(Build.VERSION_CODES.KITKAT)
   override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {
        when (requestCode) {
            // 调用相机后返回
            CAMERA_REQUEST_CODE -> if (resultCode == RESULT_OK) {
                //用相机返回的照片去调用剪裁也需要对Uri进行处理
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val contentUri = FileProvider.getUriForFile(
                        this@UserInfoSetActivity,
                        BuildConfig.APPLICATION_ID + ".fileProvider",
                        tempFile
                    )
                    cropPhoto(contentUri)//裁剪图片
                } else {
                    cropPhoto(Uri.fromFile(tempFile))//裁剪图片
                }
            }
            //调用相册后返回
            ALBUM_REQUEST_CODE -> if (resultCode == RESULT_OK) {
                if (null == intent.data) {
                    return
                }
                val uri = intent.data
                cropPhoto(uri)//裁剪图片
            }
            //调用剪裁后返回
            CROP_REQUEST_CODE -> if (RomUtil.isMiui()) {
                var file: File? = null
                try {
                    file = File(URI(uritempFile.toString()))
                } catch (e: URISyntaxException) {
                    e.printStackTrace()
                }

                //照片路径
                facePath = Objects.requireNonNull<File>(file).path
                val image = BitmapUtils.getBitmapFromFile(facePath, 300, 300)
                set_icon.setImageBitmap(image)
                photoCode=BitmapUtils.bitmapToString(image)
            } else {
                try {
                    if (intent.extras == null) {
                        return
                    }
                    val bundle = intent.extras
                    //在这里获得了剪裁后的Bitmap对象，可以用于上传
                    val image = bundle!!.getParcelable<Bitmap>("data")
                    //设置到ImageView上
                    set_icon.setImageBitmap(image)
                    //也可以进行一些保存、压缩等操作后上传
                    photoCode=BitmapUtils.bitmapToString(image)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    /**
     * 从相机获取图片
     */
    private fun getPicFromCamera() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = File(Environment.getExternalStorageDirectory().path, System.currentTimeMillis().toString() + ".jpg")
        //跳转到调用系统相机
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.flags = Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            val contentUri =
                FileProvider.getUriForFile(this@UserInfoSetActivity, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri)
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile))
        }
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    /**
     * 从相册获取图片
     */
    private fun getPicFromAlbm() {
        val photoPickerIntent = Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE)
    }

    /**
     * 裁剪图片
     */
    private fun cropPhoto(uri: Uri) {
        val intent = Intent("com.android.camera.action.CROP")
        uritempFile =
            Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().path + "/" + System.currentTimeMillis() + ".jpg")
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uritempFile)
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())
        intent.putExtra("noFaceDetection", true)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        intent.setDataAndType(uri, "image/*")
        intent.putExtra("crop", "true")
        intent.putExtra("return-data", true)
        startActivityForResult(intent, CROP_REQUEST_CODE)
    }
}