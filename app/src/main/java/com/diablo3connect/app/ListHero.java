package com.diablo3connect.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapter.ListHeroAdapter;
import Model.Hero;
import Provider.MainProvider;

/**
 * Created by quentinlogie on 01/01/12.
 */
public class ListHero extends ActionBarActivity {
    final String EXTRA_BATTLE_TAG = "battleTag";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hero);
        new Async().execute();
        listView = (ListView) findViewById(R.id.listHero);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView item = (TextView) view.findViewById(R.id.id);

                Intent detailPage = new Intent(ListHero.this, DetailHero.class);
                detailPage.putExtra("battleTag", item.getText().toString());
                startActivity(detailPage);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
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

    private class Async extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Intent intent = getIntent();
            String tag = intent.getStringExtra(EXTRA_BATTLE_TAG);
            MainProvider.fetchHeroesFromWebservice(tag);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            List<Hero> hero = MainProvider.getHeros();
            final ListHeroAdapter adapter =  new ListHeroAdapter(ListHero.this, R.layout.list_hero_adapter, hero);
            listView.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
