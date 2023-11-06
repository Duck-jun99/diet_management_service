package com.mobilelec.dietms.model;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.mobilelec.dietms.db.UserDB;
import com.mobilelec.dietms.db.UserEntity;

import java.util.List;

public class DBRepository {
    UserDB userDB;
    LiveData<List<UserEntity>> getAll;

    public DBRepository(Application application) {
        userDB = UserDB.getInstance(application);
        getAll = userDB.userDao().getAll();
    }

    public void insert(final UserEntity user) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userDB.userDao().insert(user);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LiveData<List<UserEntity>> getAll() {
        return getAll;
    }

    public void delete(final UserEntity user) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userDB.userDao().delete(user);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userDB.userDao().deleteAll();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}