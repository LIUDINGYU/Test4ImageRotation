package com.example.imagerotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView test = (ImageView)findViewById(R.id.test);

        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<12; i++){
                    try{
                        test.setPivotX(test.getWidth()/2);  //设置旋转中心
                        test.setPivotY(test.getHeight()/2);
                        test.setRotation(i*30);              //设置旋转角度，还有setRotationX() setRotationY()
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        testThread.start();
    }
}
