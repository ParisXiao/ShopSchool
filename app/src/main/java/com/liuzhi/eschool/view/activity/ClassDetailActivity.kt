package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ClassMenuAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ChapterEntity
import com.liuzhi.eschool.entity.ClassDetailEntity.ResultListBean
import com.liuzhi.eschool.entity.ClassMenuEntity
import com.liuzhi.eschool.entity.SectionEntity
import com.liuzhi.eschool.entity.convert.ClassMenuConvert
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.utils.common.ImageUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_classdelist.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject

class ClassDetailActivity : BaseActivity(),View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0){
            collect_class->{
                collectionClass(intentLessionDetail.lsDscb)
            }
        }
    }

    lateinit var intentLessionDetail: ResultListBean
    lateinit var classMenuAdapter: ClassMenuAdapter
    val data = ArrayList<MultiItemEntity>()
    override fun getLayoutId(): Int {
        return R.layout.activity_classdelist
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
        intentLessionDetail = intent.getSerializableExtra("LessonDetail") as ResultListBean
        class_detail_name.text = intentLessionDetail.lsName
        title_name.text = intentLessionDetail.lsName
        class_detail_teacher.text = "授课人：" + intentLessionDetail.lsCreateUName
        class_detail_subject.text = "所属学科：" + intentLessionDetail.lsFirstTypeName
        class_detail_teach_time.text = "创建时间：" + intentLessionDetail.lsCreateTime
        class_detail_introduce.text = intentLessionDetail.lsDscb
        ImageUtils.setImageBitmapUrl(
            this@ClassDetailActivity,
            class_detail_img,
            UrlConstans.BaseUrl + intentLessionDetail.lsImg
        )
        getMenuData(intentLessionDetail.lsId.toLong())
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

    fun getMenuData(lsId: Long) {
        var classMenuConvert = ClassMenuConvert()
        var classMenuResponse = ObservableResponse<ClassMenuEntity>()
        OkGo.get<ClassMenuEntity>(UrlConstans.LessonDetail)
            .headers("Content-Type", "application/x-www-form-urlencoded")
            .params("lsId", lsId)
            .converter(classMenuConvert)
            .adapt(classMenuResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassMenuEntity>>() {
                override fun onNext(response: Response<ClassMenuEntity>) {
                    if (response.code()==302){
                        var intent = Intent(this@ClassDetailActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    Log.e("result", "response ==> " + response.body().toString())
                    var listEntity = response.body()
                    if (listEntity.code == 0) {
                        getExpandListData(listEntity.data)
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                }
            })
    }

    fun getExpandListData(bean: ClassMenuEntity.DataBean) {
        var sectionList = ArrayList<ClassMenuEntity.DataBean.LessonBean.SectionsBean>()
        for (chapterBean in bean.lesson) {
            var chapterEntity = ChapterEntity()
            chapterEntity.chapterId = chapterBean.chapter.cpId
            chapterEntity.chapterName = chapterBean.chapter.cpName
            if (chapterBean.sections.size > 0) {
                chapterEntity.isHaveSc = true
            }
            sectionList = chapterBean.sections as ArrayList<ClassMenuEntity.DataBean.LessonBean.SectionsBean>
            for (sectionBean in sectionList) {
                var sectionEntity = SectionEntity()
                sectionEntity.sectionId = sectionBean.scId
                sectionEntity.sectionName = sectionBean.scName
                chapterEntity.addSubItem(sectionEntity)
            }
            data.add(chapterEntity)
        }
        classMenuAdapter = ClassMenuAdapter(data)
        classMenuAdapter.setItemOnclickInter(object :ClassMenuAdapter.ItemOnclickInter{
            override fun itemOnclick(scId: String?) {

            }

        })
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        class_catalog_recycler.layoutManager = layoutManager
        class_catalog_recycler.adapter = classMenuAdapter
    }
    fun collectionClass(lsId:String){
        OkGo.get<String>(UrlConstans.LessonCollect)
            .headers("Content-Type", "application/x-www-form-urlencoded")
            .params("lsId", lsId)
            .params("url", "/html/lesson/id/$lsId.html")
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    if (response.code()==302){
                        var intent =Intent(this@ClassDetailActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    Log.e("result", "response ==> " + response.body().toString())
                    var listEntity:JSONObject =JSONObject(response.body())
                    if (listEntity.optInt("code") == 0) {
                        collect_class.setText("已收藏")
                        DialogUtils.getInstance(this@ClassDetailActivity).shortToast("收藏成功")
                    }else{
                        DialogUtils.getInstance(this@ClassDetailActivity).shortToast(listEntity.optString("msg"))
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