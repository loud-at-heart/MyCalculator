package com.example.mycalculator;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycalculator.model.Word;

import java.util.ArrayList;
import java.util.List;

public class getDataTask extends AsyncTask<Void,Void, List<Word>> {

    RecyclerView mListView;
    WordDao mwordWordDao;
    Context mContext;

    public getDataTask(Context mContext,RecyclerView mListView, WordDao mwordWordDao) {
        this.mListView = mListView;
        this.mwordWordDao = mwordWordDao;
        this.mContext = mContext;
    }

    @Override
    protected List<Word> doInBackground(Void... voids) {
        return mwordWordDao.getAllWords();
    }

    @Override
    protected void onPostExecute(List<Word> words) {
        super.onPostExecute(words);
//        ArrayList<String> arrlistofOptions = new ArrayList<String>(words.stream().toArray());
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter(mContext, android.R.layout.simple_list_item_1,words);
//        WordsAdapter adapter = new WordsAdapter(words);
//        mListView.setAdapter(adapter);
        ListAdapter adapter = new ListAdapter(words);
        mListView.setAdapter(adapter);
    }
}
