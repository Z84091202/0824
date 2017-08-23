package com.qiniu.pili.droid.streaming.demo.G26;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.qiniu.pili.droid.streaming.demo.R;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager1;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    //private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();//隐藏掉整个ActionBar
        setContentView(R.layout.activity_main);
        //初始化视图

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

    }
    //分頁
    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager1= (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager1.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager1);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        //设置Tab的图标
        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);
        four.setIcon(R.mipmap.ic_launcher);


    }


    @Override                           //setting設置
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override                           //setting設置
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.Camera) {
            try {

                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this , LiveSetActivity.class);

                startActivity(intent2);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
