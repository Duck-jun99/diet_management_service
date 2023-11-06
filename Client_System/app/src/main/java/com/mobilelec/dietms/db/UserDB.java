package com.mobilelec.dietms.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 2)
public abstract class UserDB extends RoomDatabase {
    public abstract UserDao userDao();

    public static UserDB INSTANCE;

    public static UserDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, UserDB.class, "MyApp.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}