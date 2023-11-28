package com.example.runappstor.EntityDao;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.runappstor.Entity.User;

@Dao
public interface UserDao {
    @Insert
    void insertAllUser(User... users);

    @Query("SELECT Account FROM Profile_User WHERE IdUser = :userId")
    String getUsernameById(int userId);

    @Query("SELECT * FROM Profile_User WHERE Account = :account AND Password = :password")
    Cursor getUserByAccountAndPassword(String account, String password);

    @Query("SELECT IdUser FROM Profile_User WHERE Account = :account AND Password = :password")
    int getIdUserByAccountAndPassword(String account, String password);

    @Query("SELECT Avatar FROM Profile_User WHERE IdUser = :id")
    Cursor getImageByIdUser(int id);

}
