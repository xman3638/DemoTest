package com.example.myapplication;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;


/**
 * 操作OneTableBean数据表的Dao类，封装这操作OneTableBean表的所有操作
 * 通过DatabaseHelper类中的方法获取ORMLite内置的DAO类进行数据库中数据的操作
 * <p>
 * 调用dao的create()方法向表中添加数据
 * 调用dao的delete()方法删除表中的数据
 * 调用dao的update()方法修改表中的数据
 * 调用dao的queryForAll()方法查询表中的所有数据
 */
public class OneTableDao {
    // ORMLite提供的DAO类对象，第一个泛型是要操作的数据表映射成的实体类；第二个泛型是这个实体类中ID的数据类型
    private Dao<OneTableBean, Integer> dao;

    public OneTableDao(Context context) {
        try {
            this.dao = DatabaseHelper.getInstance(context).getDao(OneTableBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据
     *
     * @param data
     */
    public void create(OneTableBean data) {
        try {
            dao.createOrUpdate(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据集合
     *
     * @param datas
     */
    public void createList(List<OneTableBean> datas) {
        try {
            dao.create(datas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向user表中添加一条数据
     * <p>
     * create:插入一条数据或集合
     * <p>
     * createIfNotExists:如果不存在则插入
     * <p>
     * createOrUpdate:如果指定id则更新
     *
     * @param data
     */
    public void insert(OneTableBean data) {
        try {
            dao.createIfNotExists(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 通过id删除指定数据
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException e) {
        }
    }

    // 删除表中的一条数据
    public void delete(OneTableBean data) {
        try {
            dao.delete(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除数据集合
    public void deleteList(List<OneTableBean> datas) {
        try {
            dao.delete(datas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //清空数据
    public void deleteAll() {
        try {
            dao.delete(dao.queryForAll());
        } catch (Exception e) {
        }
    }

    // 修改表中的一条数据
    public void update(OneTableBean data) {
        try {
            dao.update(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询表中的所有数据
    public List<OneTableBean> queryAll() {
        List<OneTableBean> users = null;
        try {
            users = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 根据ID取出用户信息
    public OneTableBean queryById(int id) {
        OneTableBean user = null;
        try {
            user = dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // 通过条件查询集合（例如：通过messageId和title）
    public List<OneTableBean> queryByMessageIdAndTitle(int messageId, String title) {
        try {
            QueryBuilder<OneTableBean, Integer> builder = dao.queryBuilder();
            builder
                    .where()
                    .eq("messageId", messageId)
                    .and()
                    .eq("title", title);
            builder.orderBy("messageId", false);
            return builder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 通过条件查询集合（例如：通过content）
    public List<OneTableBean> queryByContent(String content) {
        try {
            QueryBuilder<OneTableBean, Integer> builder = dao.queryBuilder();
            builder
                    .where()
                    .eq("content", content);
            builder.orderBy("title", false);
            return builder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}