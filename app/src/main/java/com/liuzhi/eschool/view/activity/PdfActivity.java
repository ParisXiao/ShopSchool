package com.liuzhi.eschool.view.activity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.utils.common.DialogUtils;
import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class PdfActivity extends BaseActivity implements OnPageChangeListener {
    private String path = "";
    private String url = "";
    private String name = "";
    private TextView title_name;
    private Toolbar toolbar;
    private PDFView pdfView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pdf;
    }

    @Override
    protected void initView() {
        DialogUtils.getInstance(PdfActivity.this).showLoadDialog("正在加载PDF文件...");
        title_name= (TextView) findViewById(R.id.title_name);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        pdfView= (PDFView) findViewById(R.id.pdfView);
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

        path = Environment.getExternalStorageDirectory() + "";
        url = getIntent().getStringExtra("PDFUrl");
        name = getIntent().getStringExtra("PDFName");
        title_name.setText(name);

        getPDF();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showPDF();
            }
        }, 5000);


    }

    private void getPDF() {

        Request request = new Request.Builder().url(url).build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.getInstance(PdfActivity.this).showFailDialog("加载失败","PDF文件解析报错");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] bytes = new byte[2048];
                int len = 0;
                FileOutputStream o = null;
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    final File file = new File(path, "class.pdf");
                    o = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(bytes)) != -1) {
                        o.write(bytes, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        if (progress == 100) {
                        }
                    }
                    o.flush();


                } catch (Exception e) {
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (Exception e) {

                    }
                    try {
                        if (o != null)
                            o.close();
                    } catch (Exception e) {

                    }


                }


            }
        });

    }

    private void showPDF() {
//        DialogUtils.getInstance(PdfActivity.this).dismisDialog();
        File file = new File(path, "class.pdf");
        pdfView.fromFile(file)
                //                .pages(0, 0, 0, 0, 0, 0) // 默认全部显示，pages属性可以过滤性显示
                .defaultPage(0)//默认展示第一页
                .onPageChange(this)//监听页面切换
                .load();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }


    @Override
    public void onPageChanged(int i, int i1) {
//        text.setText((i + 1) + "/" + i1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DialogUtils.getInstance(PdfActivity.this).dismisDialog();
    }
}
