package com.example.mycalculator;

import android.os.AsyncTask;

import com.example.mycalculator.model.Word;

public class InsertTask extends AsyncTask<Void,Void,Void> {

    WordDao mWordDao;
    Word mword;
    ListAdapter mListAdapter;

    public InsertTask(WordDao wordDao,  Word word, ListAdapter listAdapter){
        mword =word;
        mWordDao = wordDao;
        mListAdapter = listAdapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mWordDao.insert(mword);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        mListAdapter.notifyDataSetChanged();
    }
}
