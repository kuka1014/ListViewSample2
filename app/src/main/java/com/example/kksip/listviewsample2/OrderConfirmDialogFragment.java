package com.example.kksip.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class OrderConfirmDialogFragment extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState){

        //ダイアログビルダー生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージ設定
        builder.setMessage(R.string.dialog_msg);
        //positive button設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //negative button設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //neutral button 設定
        builder.setNeutralButton(R.string.dialog_btn_nu,new DialogButtonClickListener());
        //ダイアログオブジェクト作成し、リターン
        AlertDialog dialog =builder.create();
        return  dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            //トースト用メッセージ設置
            String msg="";
            //タップされたボタンで分岐
            switch (i){
                //psitive
                case DialogInterface.BUTTON_POSITIVE:
                    //注文用のメッセs－魏
                    msg=getString(R.string.dialog_ok_toast);
                    break;

                 case DialogInterface.BUTTON_NEGATIVE:
                     //negative
                     msg=getString(R.string.dialog_ng_toast);
                     break;

                case DialogInterface.BUTTON_NEUTRAL:
                    //問い合わせ
                    msg=getString(R.string.dialog_nu_toast);
                    break;
            }
            //トースト表示
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
