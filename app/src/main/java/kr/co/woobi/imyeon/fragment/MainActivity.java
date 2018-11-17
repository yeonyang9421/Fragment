package kr.co.woobi.imyeon.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ColorListFragment.onColorSelectedListener {

    private ColorFragment mcolorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcolorFragment = (ColorFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_color);


    }

    @Override
    public void onColorSelcted(int color) {
        mcolorFragment.setColor(color);

    }


}
