package com.example.potato.kiosk4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{
    int lastTab = -1;
    List<Events> items;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tab);

        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Three tab to display in actionbar
        ab.addTab(ab.newTab().setText("Home").setTabListener(this));
        ab.addTab(ab.newTab().setText("Map").setTabListener(this));
        ab.addTab(ab.newTab().setText("Directory").setTabListener(this));
        ab.addTab(ab.newTab().setText("Events").setTabListener(this));

        items = new ArrayList<Events>();
        items.add(new Events("google", "Google", "Lobby Day! Bring your resumes!" +
                "\n2PM-6PM"));
        items.add(new Events("awc", "Association for Women in Computing", "General" +
                " body meeting.\n6PM-9PM"));
        items.add(new Events("john", "Guest Lecture", "Esteemed researcher John Smith will" +
                " be visiting to discuss his work on common names\n7PM-8PM"));
        items.add(new Events("google", "Google", "Lobby Day! Bring your resumes!" +
                "\n2PM-6PM"));
        items.add(new Events("awc", "Association for Women in Computing", "General" +
                " body meeting.\n6PM-9PM"));
        items.add(new Events("john", "Guest Lecture", "Esteemed researcher John Smith will" +
                " be visiting to discuss his work on common names\n7PM-8PM"));

        adapterEvents adp = new adapterEvents(this, items);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adp);
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //Called when a tab is selected
        int nTabSelected = tab.getPosition();
        switch (nTabSelected) {
            case 0:
                if (lastTab != -1)
                    recreate();
                setContentView(R.layout.home_tab);
                break;
            case 1:
                setContentView(R.layout.map_tab);
                break;
            case 2:
                setContentView(R.layout.directory_tab);
                break;
            case 3:
                setContentView(R.layout.events_tab);
                break;
        }

        lastTab = tab.getPosition();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // Called when a tab unselected.
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        this.recreate();
        // Called when a tab is selected again.
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        /*
        items = new ArrayList<Events>();
        list = (ListView) findViewById(R.id.list);
        items.add(new Events("google", "Google", "Lobby Day! Bring your resumes!" +
                "\n2PM-6PM"));
        items.add(new Events("awc", "Association for Women in Computing", "General" +
                " body meeting.\n6PM-9PM"));
        items.add(new Events("john", "Guest Lecture", "Esteemed researcher John Smith will" +
                " be visiting to discuss his work on common names\n7PM-8PM"));
        items.add(new Events("google", "Google", "Lobby Day! Bring your resumes!" +
                "\n2PM-6PM"));
        items.add(new Events("awc", "Association for Women in Computing", "General" +
                " body meeting.\n6PM-9PM"));
        items.add(new Events("john", "Guest Lecture", "Esteemed researcher John Smith will" +
                " be visiting to discuss his work on common names\n7PM-8PM"));

        adapterEvents adp = new adapterEvents(this, items);
        list.setAdapter(adp);*/


//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//                                    long arg3) {
//                Events selection = (Events) arg0.getItemAtPosition(arg2);
//                /**
//                 * PLACE HOLDER. Clicking on event item will initiate to a new intent,
//                 * not yet created in order to view more detail on the event. Name and
//                 * picture of event will be packaged into the intent as extras.
//                 *
//                 * Intent intent = new Intent(getApplicationContext(), EventItem.class);
//                 * intent.putExtra("name",selection.getName().toString());
//                 * intent.putExtra("pic",selection.getPic().toString());
//                 * startActivity(intent);
//                 */
//            }
//        });
}
