package com.sasin.mypreference_pzpapplication;

import android.content.Context;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MyEditTextPreference extends EditTextPreference {

    private EditText mEditText;

    public MyEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.dialog);
        mEditText = getEditText();
        mEditText.setEms(10);   //设置系统默认编辑框的长度为10
    }

    /*创建dialog是会被调用*/
    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        Log.d("pzp1","onBindDialogView");
        mEditText.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 287 && event.getAction() == KeyEvent.ACTION_UP) {
                    if(!(mEditText.getText().toString().isEmpty())){
                        deleteEditText(mEditText);
                    }else{
                        onActivityDestroy();
                    }
                }
                return false;
            }
        });
    }

    /*点击自定义的编辑框选项时被调用*/
    @Override
    protected void onClick() {
        super.onClick();
        Log.d("pzp1","onClick");
        mEditText.setText("");
    }

    /*将系统默认的EditText添加到自己的布局中*/
    @Override
    protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        super.onAddEditTextToDialogView(dialogView, editText);

        ViewGroup container = (ViewGroup) dialogView
                .findViewById(R.id.edittext);

        if (container != null) {
            container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    /*EditText的字符删除*/
    private void deleteEditText(EditText mEditText){
        int index = mEditText.getSelectionStart();
        Editable mEditable = mEditText.getText();
        if(index-1 >= 0){
            mEditable.delete(index-1,index);
        }
    }
}
