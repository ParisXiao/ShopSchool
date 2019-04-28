package com.liuzhi.eschool.utils.common;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DialogUtils {
    private static DialogUtils dialogUtils;
    private static Context context;
    private SweetAlertDialog mDialog;

    public DialogUtils(Context context) {
        this.context = context;
    }

    public static DialogUtils getInstance(Context context) {
        if (dialogUtils == null) {
            dialogUtils = new DialogUtils(context);
        }
        return dialogUtils;
    }

    public void showLoadDialog(String s) {
        dismisDialog();
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        mDialog.setTitleText(s);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    public void showSuccessDialog(String s) {
        dismisDialog();
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#22ac38"));
        mDialog.setTitleText(s);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    public void showFailDialog(String s, String content) {

        dismisDialog();
        if (content == null) {
            content = "服务器异常,请重试";
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#EA513D"));
        mDialog.setTitleText(s);
        mDialog.setContentText(content);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    public void showFailDialog(String s, String content, String btnText, final FailListener failListener) {

        dismisDialog();
        if (content == null) {
            content = "服务器异常,请重试";
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#EA513D"));
        mDialog.setTitleText(s);
        mDialog.setContentText(content);
        mDialog.setCancelable(false);
        mDialog.setCancelButton(btnText, new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                failListener.failTry();
            }
        });
        mDialog.show();
    }

    public void dismisDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    public interface FailListener {
        void failTry();
    }

    /**
     * 显示短暂的Toast
     *
     * @param toast 文本
     */
    public void shortToast(String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
