package com.example.mycalculator;


import androidx.room.*;

import android.content.Context;

import com.example.mycalculator.model.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDb extends RoomDatabase {
        public abstract WordDao wordDao();

        private static WordRoomDb INSTANCE;


        static WordRoomDb getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (WordRoomDb.class) {
                    if (INSTANCE == null)    {
                        INSTANCE = Room.databaseBuilder(
                                context.getApplicationContext(),
                                WordRoomDb.class, "word_database")
                                // .addCallback(sOnOpenCallback)
                                .fallbackToDestructiveMigration()
                                .build();
                    }}}
            return INSTANCE;
        }


}
