package com.mobilelec.dietms.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity user);

    @Query("SELECT * FROM user")
    LiveData<List<UserEntity>> getAll();

    @Query("DELETE FROM user")
    void deleteAll();

    @Delete
    void delete(UserEntity user);

}