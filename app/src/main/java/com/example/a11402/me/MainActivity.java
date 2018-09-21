package com.example.a11402.me;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //购买课程
    private Button button_bug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button_bug = (Button) findViewById(R.id.button_bug);

        button_bug.setOnClickListener(this);
    }

    //购买课程点击事件，因为不知道是什么需求就点击购买课程了。
    @Override
    public void onClick(View v) {
        //显示popupWindow
        showPopup();
    }

    private void showPopup(){
        //背景
        Resources resources = getBaseContext().getResources();
        Drawable d = resources.getDrawable(R.color.colorPopup);

        //PopupWindow对应的布局
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_set_have_a_class, null);
        //PopupWindow
        final PopupWindow window = new PopupWindow(view);
        //宽
        window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //高
        window.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置背景
        window.setBackgroundDrawable(d);
        //可点击可退出
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        //显示在父控件的哪个位置
        window.showAtLocation(view, Gravity.CENTER, 0, 0);

        //点击布局外围popupWindow消失
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PopupWindow关闭
                window.dismiss();
            }
        });
    }
}