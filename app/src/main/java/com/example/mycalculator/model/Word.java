package com.example.mycalculator.model;

import androidx.room.*;

@Entity
public class Word {

    @PrimaryKey(autoGenerate=true)
    public int uid;

    @ColumnInfo
    public String title;

    public Word(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
