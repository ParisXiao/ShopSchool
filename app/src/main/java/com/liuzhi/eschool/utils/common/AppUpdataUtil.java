package com.liuzhi.eschool.utils.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.liuzhi.eschool.BuildConfig;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okrx2.adapter.ObservableResponse;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.NumberFormat;

/**
 * Created by Administrator on 2018\4\3 0003.
 */

public class AppUpdataUtil {
    public interface UpdataInter{
        void isLastVersion();
        void newVersion(String appsize,String version,String path);
    }
    /**
     * 查询版本更新
     *
     * @param context
     */
    public  static void appUpdata(final Activity context, final UpdataInter updataInter) {
        OkGo.<String>get(UrlConstans.Companion.getUPDATA())
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<String>>() {
                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Log.e("updata", "====stringResponse========> " + stringResponse.body());
                        try {
                            JSONObject jsonObject = new JSONObject(stringResponse.body());
                            if (jsonObject.getString("code").equals("0")) {
                                PackageInfo info = null;
                                try {
                                   info = context.getPackageManager().getPackageInfo(
                                            context.getPackageName(), 0);
                                } catch (PackageManager.NameNotFoundException e) {
                                    e.printStackTrace();
                                }
                                JSONObject jsonObject1=new JSONObject(jsonObject.optString("data"));
                                String version = info.versionName;
                                if (!version.equals(jsonObject1.getString("appVersion"))){
                                    updataInter.newVersion(jsonObject1.getString("appSize"),jsonObject1.getString("appVersion"),UrlConstans.Companion.getBaseUrl()+jsonObject1.getString("appFilePath"));
//                                        downLoadApk(context,);
                                }else {
                                    updataInter.isLastVersion();
                                }
                            }else {
                                updataInter.isLastVersion();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            updataInter.isLastVersion();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        updataInter.isLastVersion();
                        Log.e("updata", "====stringResponse========> " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private static NumberFormat numberFormat;

    /**
     * 安装apk
     *
     * @param url
     */
    public static   void downLoadApk(final Activity activity, final String url) {
        if (null == numberFormat) {
            numberFormat = NumberFormat.getPercentInstance();
            numberFormat.setMinimumFractionDigits(2);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        lp.alpha = 1f;
        window.setAttributes(lp);
        window.setContentView(R.layout.layout_updata_progress);
        final NumberProgressBar pbProgress = (NumberProgressBar) window.findViewById(R.id.pbProgress);
        final TextView tvDownloadSize = (TextView) window.findViewById(R.id.downloadSize);
        final TextView tvProgress = (TextView) window.findViewById(R.id.tvProgress);
        final TextView tvNetSpeed = (TextView) window.findViewById(R.id.netSpeed);
        GetRequest<File> getRequest = OkGo.<File>get(url)
                .headers("header1", "headerValue1")
                .params("param1", "paramValue1");
        OkDownload.getInstance().request("app",getRequest)
                .folder(Environment.getExternalStorageDirectory()+"/UpdataFiles/")
                .fileName("robotControl.apk")
                .save()
                .register(new DownloadListener("app") {
                    @Override
                    public void onStart(Progress progress) {

                    }
                    @Override
                    public void onProgress(Progress progress) {
                        String downloadLength = Formatter.formatFileSize(activity.getApplicationContext(), progress.currentSize);
                        String totalLength = Formatter.formatFileSize(activity.getApplicationContext(), progress.totalSize);
                        tvDownloadSize.setText(downloadLength + "/" + totalLength);
                        String speed = Formatter.formatFileSize(activity.getApplicationContext(), progress.speed);
                        tvNetSpeed.setText(String.format("%s/s", speed));
                        tvProgress.setText(numberFormat.format(progress.fraction));
                        pbProgress.setMax(10000);
                        pbProgress.setProgress((int) (progress.fraction * 10000));
                    }

                    @Override
                    public void onError(Progress progress) {
                        Toast.makeText(activity, "下载出错" + progress.exception.getMessage(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFinish(File file, Progress progress) {
                        installApk(activity, file);
                        dialog.dismiss(); //结束掉进度条对话框
                    }

                    @Override
                    public void onRemove(Progress progress) {

                    }
                })
                .restart();
    }

    //安装apk
    protected  static void installApk(Activity activity, File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".fileProvider", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }


}
