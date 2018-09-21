package com.example.a11402.me;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends BaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Thread(){
            @Override
            public void run() {
                super.run();

                Message message = new Message();
                message.obj = "1";
                handler.sendMessage(message);
            }
        };

    }
}
