package com.example.mycalculator;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.mycalculator.model.Word;

public class DeleteWordTask extends AsyncTask<Void,Void,Integer> {
    public static String TAG = DeleteWordTask.class.getSimpleName();
    WordDao mWordDao;
    String mword;

    public DeleteWordTask(WordDao mWordDao, String mword) {
        this.mWordDao = mWordDao;
        this.mword = mword;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        Integer a= mWordDao.deleteWord(mword);
//        Toast.makeText(com.example.mycalculator.DataActivity, a.toString(), Toast.LENGTH_SHORT).show();

        return a;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Log.i(TAG,"no of rows deleted = "+integer);
    }
}
