package com.example.mycalculator;

import android.os.AsyncTask;

import com.example.mycalculator.model.Word;

public class DeleteTask extends AsyncTask<Void,Void,Void> {

    WordDao mWordDao;

    public DeleteTask(WordDao mWordDao) {
        this.mWordDao = mWordDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mWordDao.deleteLatestWord();
        return null;
    }
}
