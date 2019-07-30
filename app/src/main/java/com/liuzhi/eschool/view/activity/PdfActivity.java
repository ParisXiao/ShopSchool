package com.liuzhi.eschool.view.activity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.utils.common.DialogUtils;
import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;
import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class PdfActivity extends BaseActivity implements DownloadFile.Listener {
    private String url = "";
    private String name = "";
    private TextView title_name;
    private Toolbar toolbar;
    private RelativeLayout pdf_root;
    private ProgressBar pb_bar;
    private RemotePDFViewPager remotePDFViewPager;
    private PDFPagerAdapter adapter;
    private TextView pdf_page;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_pdf;
    }

    @Override
    protected void initView() {
        title_name= (TextView) findViewById(R.id.title_name);
        pdf_page= (TextView) findViewById(R.id.pdf_page);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        pb_bar = (ProgressBar) findViewById(R.id.pb_bar);
        pdf_root = (RelativeLayout) findViewById(R.id.remote_pdf_root);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true);
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setBackgroundColor(getResources().getColor(R.color.main_blue_color));
        title_name.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {

        url = getIntent().getStringExtra("PDFUrl");
        name = getIntent().getStringExtra("PDFName");
        title_name.setText(name);
        setDownloadListener();
        pdf_page.setText("左右滑动翻页");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /*设置监听*/
    protected void setDownloadListener() {
        final DownloadFile.Listener listener = this;
        remotePDFViewPager = new RemotePDFViewPager(this, url, listener);
        remotePDFViewPager.setId(R.id.pdfViewPager);
    }
    /*加载成功调用*/
    @Override
    public void onSuccess(String url, String destinationPath) {
        pb_bar.setVisibility(View.GONE);
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter); updateLayout();
    }

    /*更新视图*/
    private void updateLayout() {
        pdf_root.removeAllViewsInLayout();
        pdf_root.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
    /*加载失败调用*/
    @Override
    public void onFailure(Exception e) {
        pb_bar.setVisibility(View.GONE);
        DialogUtils.getInstance(PdfActivity.this).shortToast( "数据加载错误");
    }
    @Override
    public void onProgressUpdate(int progress, int total) {

    }
}
