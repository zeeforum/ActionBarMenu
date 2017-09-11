package com.example.zarta.empublite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.lang.reflect.Method;

public class EmPubLiteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em_pub_lite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //render menu file
        getMenuInflater().inflate(R.menu.options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //on menu item selection
        switch (item.getItemId()) {
            case R.id.about:
                Intent i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return true;

            case R.id.help:
                i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) { //to show icons with menu
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch(NoSuchMethodException e) {
                    Log.e("OPEN", "onMenuOpened", e);
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}
