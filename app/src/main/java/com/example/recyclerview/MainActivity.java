package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> wordList = new LinkedList<>();
    private RecyclerView recyclerView;
    private WordListAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            wordList.add("Word " + i);
        }

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new WordListAdapter(this, wordList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab.setOnClickListener(v-> onClickFAB());
    }

    public void onClickFAB(){
        wordList.addLast("+ Word " + wordList.size());
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(wordList.size()-1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        wordList.clear();
        for (int i = 0; i < 20; i++) {
            wordList.addLast("Word " + i);
        }
        adapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
}