
package com.china.onezudemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.china.onezudemo.fragment.FragmentFive;
import com.china.onezudemo.fragment.FragmentFour;
import com.china.onezudemo.fragment.FragmentOne;
import com.china.onezudemo.fragment.FragmentThree;
import com.china.onezudemo.fragment.FragmentTwo;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar btb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        Fresco.initialize(this);
        btb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(13)
                .setTabPadding(2, 3, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("主页", R.drawable.sy2, R.drawable.sy1, FragmentOne.class)
                .addTabItem("热卖", R.drawable.wt2, R.drawable.wt1, FragmentTwo.class)
                .addTabItem("分类", R.drawable.fl2, R.drawable.fl1, FragmentThree.class)
                .addTabItem("购物车", R.drawable.gwc2, R.drawable.gwc1, FragmentFour.class)
                .addTabItem("我的", R.drawable.wd2, R.drawable.wd1, FragmentFive.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TGA", "位置：" + position + "      选项卡：" + name);
                    }
                });
    }
}
