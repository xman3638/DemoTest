package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private int position;
    private OneTableDao oneTableDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        position = 0;
        oneTableDao = new OneTableDao(this);
        createList(null);
    }

    /**
     * 创建数据集合
     *
     * @param view
     */
    public void createList(View view) {
        ArrayList<OneTableBean> oneTableBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OneTableBean oneTableBean = new OneTableBean();
            oneTableBean.setTitle("创建数据集合" + i);
            oneTableBean.setBatchNo("yes");
            oneTableBean.setContent("哎呀");
            oneTableBeans.add(oneTableBean);
        }
        oneTableDao.createList(oneTableBeans);
    }


    /**
     * 创建数据
     *
     * @param view
     */
    public void create(View view) {
        OneTableBean oneTableBean = new OneTableBean();
        oneTableBean.setTitle("huangxiaoguo" + position);
        oneTableBean.setBatchNo("yes");
        oneTableBean.setContent("大大");
        oneTableDao.create(oneTableBean);

        OneTableBean oneTableBean1 = new OneTableBean();
        oneTableBean1.setTitle("huangxiaoguo" + position);
        oneTableBean1.setBatchNo("大大");
        oneTableDao.create(oneTableBean1);
        position++;
    }

    /**
     * 添加一条数据
     *
     * @param view
     */
    public void add(View view) {
        OneTableBean oneTableBean = new OneTableBean();
        if (position == 6) {
            oneTableBean.setTitle("huangxiaoguo" + position);
            oneTableBean.setBatchNo("154546");
            oneTableBean.setContent("dadiouahddjaopdja");
        } else if (position == 8) {
            oneTableBean.setTitle("huangxiaoguo" + position);
        } else {
            oneTableBean.setTitle("huangxiaoguo" + position);
            oneTableBean.setBatchNo("no");
            oneTableBean.setContent("大大");
        }
        oneTableDao.insert(oneTableBean);
        position++;
    }

    /**
     * 通过id删除指定数据
     *
     * @param view
     */
    public void deleteByID(View view) {
        oneTableDao.delete(1);
    }


    /**
     * 删除user表中的一条数据
     *
     * @param view
     */
    public void delete(View view) {
        oneTableDao.delete(oneTableDao.queryById(2));
    }

    /**
     * 删除数据集合
     *
     * @param view
     */
    public void deleteList(View view) {
        oneTableDao.deleteList(oneTableDao.queryByContent("大大"));
    }

    /**
     * 清空数据
     *
     * @param view
     */
    public void deleteAll(View view) {
        oneTableDao.deleteAll();
    }


    /**
     * 更新
     *
     * @param view
     */
    public void updata(View view) {
        OneTableBean oneTableBean = oneTableDao.queryById(5);
        if (oneTableBean != null) {
            oneTableBean.setTitle("我被更新了");
            oneTableDao.update(oneTableBean);
        }
    }


    /**
     * 查询user表中的所有数据
     *
     * @param view
     */
    public void queryAll(View view) {
        Log.d("huangxiaoguo", "-----------------------------------------------");
        List<OneTableBean> oneTableBeans = oneTableDao.queryAll();
        for (int i = 0; i < oneTableBeans.size(); i++) {
            Log.d("huangxiaoguo", oneTableBeans.get(i).toString());
        }

    }

    /**
     * 根据ID取出用户信息
     *
     * @param view
     */
    public void queryById(View view) {
        OneTableBean oneTableBean = oneTableDao.queryById(5);
        Log.d("huangxiaoguo", "-----------------------------------------------");
        if (oneTableBean != null)
            Log.d("huangxiaoguo", oneTableBean.toString());
    }

    /**
     * 通过条件查询集合
     *
     * @param view
     */
    public void queryOther(View view) {
        List<OneTableBean> huangxiaoguo6 = oneTableDao.queryByMessageIdAndTitle(6, "huangxiaoguo0");
        Log.d("huangxiaoguo", "-----------------------------------------------");
        Log.d("huangxiaoguo", huangxiaoguo6.toString());

        List<OneTableBean> huangxiaoguo61 = oneTableDao.queryByContent("大大");
        Log.d("huangxiaoguo", "-----------------------------------------------");
        Log.d("huangxiaoguo", huangxiaoguo61.toString());
    }
}