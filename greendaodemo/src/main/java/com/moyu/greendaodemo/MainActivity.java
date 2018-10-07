package com.moyu.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;
    private DaoSession daoSession;
    private Query<User> userQuery;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        daoSession = ((App) getApplication()).getDaoSession();
        userDao = daoSession.getUserDao();
        userQuery = userDao.queryBuilder().orderAsc(UserDao.Properties.Id).build();

        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
    }

    //插入数据
    private void insertUser() {
        User user = new User(null, "wangshifei", "nan", 18);
        userDao.insert(user);
    }

    //删除指定位置的数据
    private void deleteUser() {
        userDao.deleteByKey(1l);
    }

    //对位置为position的的数据进行修改
    private void updateUser() {
        User user = userDao.load(1l);
        user.setName("panna");
        userDao.update(user);
    }

    //查询全部的数据
    private List<User> queryList() {
        List<User> userList = userQuery.list();
        Log.e("wsf", "queryList: "+userList.size() );
        return userList;
    }

    private List<User> queryByName(String name, String sex) {
        QueryBuilder<User> userQueryBuilder = userDao.queryBuilder();
        Query<User> query = userQueryBuilder.where(UserDao.Properties.Name.eq(name), UserDao.Properties.Sex.eq(sex)).build();
        List<User> list = query.list();
        return list;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insert:
                insertUser();
                break;
            case R.id.delete:
                deleteUser();
                break;
            case R.id.update:
                updateUser();
                break;
            case R.id.query:
                queryList();
                break;
        }
    }
}
