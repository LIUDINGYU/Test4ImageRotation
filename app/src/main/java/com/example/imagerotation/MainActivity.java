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
                for (int i = 0; i<100; i++){
                    try{
                        test.setPivotX(test.getWidth()/2);  //设置旋转中心
                        test.setPivotY(test.getHeight()*4/13);
                        test.setTranslationX(i*3);           //设置边平移边旋转
                        test.setTranslationY(i*3);
                        test.setRotation(i*5);              //设置旋转角度，还有setRotationX() setRotationY()
                        Thread.sleep(50);            //如果刷新时间50ms
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        testThread.start();
    }
}
