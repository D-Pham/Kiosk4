package com.example.potato.kiosk4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class EventsTab extends AppCompatActivity {
    List<Events> items;
    ListView list;
    adapterEvents adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_tab);

        items = new ArrayList<>();
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

        adp = new adapterEvents(this, items);
        list = (ListView) findViewById(R.id.list2);
        list.setAdapter(adp);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] categories = new String[]{"All Events","Tech Talks", "Club Events", "Minority Groups","Guest Lectures"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dropdown.setAdapter(adapter);
    }

    public void search(View view){
        adp.clearhidden();
        String searchtext = ((TextView) findViewById(R.id.search)).getText().toString();
        List<Integer> toremove = new ArrayList<>();
        int num = adp.getCount();
        for (int i = 0; i < num; i++) {
            Events tempitem = (Events) adp.getItem(i);
            if (!tempitem.name.toLowerCase().contains(searchtext.toLowerCase()) &&
                    !tempitem.description.toLowerCase().contains(searchtext.toLowerCase()))
                toremove.add(i);
        }
        for(int x: toremove)
            adp.remove(x);
        adp.notifyDataSetChanged();
    }
}
