package com.example.fabexample2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private LayoutInflater mInflater;
    private final LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        //this.mInflater = mInflater;
        this.mWordList = mWordList;
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked" + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}