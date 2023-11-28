package com.example.runappstor.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.LocalDate;


@Entity(tableName = "Comment_Content",indices = {@Index("Code_Story"), @Index("IdUser")},
        foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "IdUser",
        childColumns = "IdUser"
//        onDelete = ForeignKey.CASCADE
        ), @ForeignKey(entity = ListStory.class,
        parentColumns = "Code_Story",
        childColumns = "Code_Story"
//        onDelete = ForeignKey.CASCADE
        )})
public class Comment {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IdComment")
    private int idComment;
    @ColumnInfo(name = "IdUser")
    private int idUser;


    @ColumnInfo(name = "Code_Story")
    private String codeStory;

    @ColumnInfo(name = "Comment")
    private String comment;

    //thời gian gửi
    @ColumnInfo(name = "TimeComment")
    private LocalDate timeComment;


    //getter setter
    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCodeStory() {
        return codeStory;
    }

    public void setCodeStory(String codeStory) {
        this.codeStory = codeStory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(LocalDate timeComment) {
        this.timeComment = timeComment;
    }


}

