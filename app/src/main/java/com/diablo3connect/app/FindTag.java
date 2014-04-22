package com.diablo3connect.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import Model.Hero;
import Provider.MainProvider;


public class FindTag extends Activity {
    final String EXTRA_BATTLE_TAG = "battleTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tag);

        Button button = (Button)findViewById(R.id.buttonFind);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtBattleTag = (EditText)findViewById(R.id.battleTag);
                String battleTag = txtBattleTag.getText().toString();
                Intent intent = new Intent(FindTag.this, ListHero.class);
                intent.putExtra(EXTRA_BATTLE_TAG, battleTag);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.find_tag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
