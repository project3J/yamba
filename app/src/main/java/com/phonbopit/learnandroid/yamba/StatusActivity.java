package com.phonbopit.learnandroid.yamba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class StatusActivity extends ActionBarActivity {

    public static final String TAG = StatusActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if this activity was created before?
        if (savedInstanceState == null) {
            StatusFragment fragment = new StatusFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, fragment, "StatusFragment")
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.itemPrefs:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.itemServiceStart:
                startService(new Intent(this, RefreshService.class));
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }


}
