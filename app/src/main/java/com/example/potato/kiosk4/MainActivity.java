package com.example.potato.kiosk4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<Events> items;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
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
        list.setAdapter(adp);

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
}
