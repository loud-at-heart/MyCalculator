package com.example.mycalculator;

import androidx.room.*;

import com.example.mycalculator.model.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    abstract void insert(Word word);

    @Query("SELECT * from Word ORDER BY title ASC")
    List<Word> getAllWords();

    @Query("DELETE FROM Word WHERE UID=(SELECT MAX(uid) FROM Word)")
    void deleteLatestWord();

    @Query("DELETE FROM Word WHERE title= :word")
    int deleteWord(String word);
}
