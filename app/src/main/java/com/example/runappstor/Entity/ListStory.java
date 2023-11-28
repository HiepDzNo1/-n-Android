package com.example.runappstor.Entity;



import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.runappstor.Database.LocalDateConverter;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;




@Entity(tableName = "ListStory",indices = {@Index(value = {"Code_Story"}, unique = true)})
public class ListStory {
    @PrimaryKey
    @ColumnInfo(name = "Code_Story")
    @SerializedName("Code_Story") //ánh xạ tên trường
    @NonNull
    private String code;

    @ColumnInfo(name = "Name_Story")
    @SerializedName("Name_Story")
    private String nameStory;

    //tác giả
    @ColumnInfo(name = "Author")
    @SerializedName("Author")
    private String author;

    //the loai
    @ColumnInfo(name = "Genre")
    @SerializedName("Genre")
    private String genre;

    //ngay xuất bản
    @ColumnInfo(name = "Production_Date")
    @SerializedName("Production_Date")
    private String productionDate;

    //ngày cập nhật
    @ColumnInfo(name = "Update_Day")
    @SerializedName("Update_Day")
    private String updateDayStory;

    //ảnh đại diện truyen
    @ColumnInfo(name = "Avatar_story")
    @SerializedName("Avatar_story")
    private String avatarStory;




    //getter and setter

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getUpdateDayStory() {
        return updateDayStory;
    }

    public void setUpdateDayStory(String updateDayStory) {
        this.updateDayStory = updateDayStory;
    }

    public String getAvatarStory() {
        return avatarStory;
    }

    public void setAvatarStory(String avatarStory) {
        this.avatarStory = avatarStory;
    }
}





