package com.example.runappstor.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Calendar;

@Entity(tableName = "Profile_User", indices = @Index(value = {"IdUser"}, unique = true))
public class  User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IdUser")
    @SerializedName("IdUser")
    private int idUser;

    @ColumnInfo(name = "Account")
    @SerializedName("Account")
    private String account;

    @ColumnInfo(name = "Password")
    @SerializedName("Password")
    private int password;

    @ColumnInfo(name = "Sex")
    @SerializedName("Sex")
    private Boolean sex;

    @ColumnInfo(name = "Birthday")
    @SerializedName("Birthday")
    private LocalDate birthday;

    @ColumnInfo(name = "Avatar")
    @SerializedName("Avatar")
    private String avatarUser;



    //gettter setter

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }



}