package com.mobilelec.dietms.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "created_date")
    public String  createdDate;

    @ColumnInfo(name = "published_date")
    public String publishedDate;

    @ColumnInfo(name = "image")
    public String image;
}
