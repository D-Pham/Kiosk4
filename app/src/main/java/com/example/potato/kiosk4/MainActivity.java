package com.example.potato.kiosk4;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static com.example.potato.kiosk4.Constant.FIRST_COLUMN;
import static com.example.potato.kiosk4.Constant.SECOND_COLUMN;
import static com.example.potato.kiosk4.Constant.THIRD_COLUMN;
import static com.example.potato.kiosk4.Constant.FOURTH_COLUMN;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{
    int lastTab = -1;
    List<Events> items;
    ListView list;
    private ArrayList<HashMap> dirList;
    private listviewAdapter adapter;
    private listviewAdapter adapter1;
    private EditText etSearch;
    private ListView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tab);

        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //This adds the cs logo to the tab bar

        ab.setDisplayOptions(ab.getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(ab.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.cs_logo2);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
                | Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        ab.setCustomView(imageView);

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

    private void initialize() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lview = (ListView)findViewById(R.id.mobile_list);
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
//                TextView textView = (TextView) findViewById(R.id.BrendanIribe2);
//                SpannableString content = new SpannableString("For Computer Science and Innovation\n");
//                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
//                textView.setText(content);
                // Make the header
                populateDirectoryList(1);
                ListView lview1 = (ListView) findViewById(R.id.header_list);
                adapter = new listviewAdapter(this, dirList);
                lview1.setAdapter(adapter);

                // Make the other shit
                populateDirectoryList(0);
                initialize();
                adapter1 = new listviewAdapter(this, dirList);
                lview.setAdapter(adapter1);



                etSearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Call back the Adapter with current character to Filter
                        adapter1.getFilter().filter(s.toString());
                        //lview.setAdapter(adapter1);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                    }


                });

                //lview.setAdapter(adapter);

                break;
            case 3:
                setContentView(R.layout.events_tab);
                break;
        }

        lastTab = tab.getPosition();
    }

    private void populateDirectoryList(int i) {
        //to populate full list pass i=0 otherwise you are making the header. yeah this is ugly, I know

        dirList = new ArrayList<HashMap>();
        if(i == 0) {
            HashMap temp = new HashMap();
            temp.put(FIRST_COLUMN, "Agrawala Ashok");
            temp.put(SECOND_COLUMN, "52525");
            temp.put(THIRD_COLUMN, "agrawala@cs.umd.edu");
            temp.put(FOURTH_COLUMN, "4149");
            dirList.add(temp);

            HashMap temp1 = new HashMap();
            temp1.put(FIRST_COLUMN, "John Aloimonos");
            temp1.put(SECOND_COLUMN, "51743");
            temp1.put(THIRD_COLUMN, "yiannis@cs.umd.edu");
            temp1.put(FOURTH_COLUMN, "4475");
            dirList.add(temp1);

            HashMap temp2 = new HashMap();
            temp2.put(FIRST_COLUMN, "Alexander Barg");
            temp2.put(SECOND_COLUMN, "57135");
            temp2.put(THIRD_COLUMN, "abarg@umd.edu");
            temp2.put(FOURTH_COLUMN, "2361");
            dirList.add(temp2);

            HashMap temp3 = new HashMap();
            temp3.put(FIRST_COLUMN, "Rajeev Barua");
            temp3.put(SECOND_COLUMN, "58137");
            temp3.put(THIRD_COLUMN, "barua@eng.umd.edu");
            temp3.put(FOURTH_COLUMN, "1431");
            dirList.add(temp3);

            HashMap temp4 = new HashMap();
            temp4.put(FIRST_COLUMN, "Victor Basili");
            temp4.put(SECOND_COLUMN, "52690");
            temp4.put(THIRD_COLUMN, "basili@cs.umd.edu");
            temp4.put(FOURTH_COLUMN, "3175");
            dirList.add(temp4);

            temp = new HashMap();
            temp.put(FIRST_COLUMN, "Ben Bederson");
            temp.put(SECOND_COLUMN, "HBK 53394");
            temp.put(THIRD_COLUMN, "bederson@cs.umd.edu");
            temp.put(FOURTH_COLUMN, "HBK 2117D");
            dirList.add(temp);

            temp1 = new HashMap();
            temp1.put(FIRST_COLUMN, "Bobby Bhattacharjee");
            temp1.put(SECOND_COLUMN, "51658");
            temp1.put(THIRD_COLUMN, "bobby@cs.umd.edu");
            temp1.put(FOURTH_COLUMN, "4143");
            dirList.add(temp1);

            temp2 = new HashMap();
            temp2.put(FIRST_COLUMN, "Marine Carpuat");
            temp2.put(SECOND_COLUMN, "58801");
            temp2.put(THIRD_COLUMN, "rama@cfar.umd.edu");
            temp2.put(FOURTH_COLUMN, "3157");
            dirList.add(temp2);

            temp4 = new HashMap();
            temp4.put(FIRST_COLUMN, "Ramalingam Chellappa");
            temp4.put(SECOND_COLUMN, "53656");
            temp4.put(THIRD_COLUMN, "rama@cfar.umd.edu");
            temp4.put(FOURTH_COLUMN, "4411");
            dirList.add(temp4);

            temp = new HashMap();
            temp.put(FIRST_COLUMN, "Jason Smith");
            temp.put(SECOND_COLUMN, "52525");
            temp.put(THIRD_COLUMN, "agrawala@cs.umd.edu");
            temp.put(FOURTH_COLUMN, "4149");
            dirList.add(temp);

            temp1 = new HashMap();
            temp1.put(FIRST_COLUMN, "Joe Aloimonos");
            temp1.put(SECOND_COLUMN, "51743");
            temp1.put(THIRD_COLUMN, "yiannis@cs.umd.edu");
            temp1.put(FOURTH_COLUMN, "4475");
            dirList.add(temp1);

            temp2 = new HashMap();
            temp2.put(FIRST_COLUMN, "Evan Golub");
            temp2.put(SECOND_COLUMN, "50180");
            temp2.put(THIRD_COLUMN, "egolub@cs.umd.edu");
            temp2.put(FOURTH_COLUMN, "1115");
            dirList.add(temp2);
//
//            temp3 = new HashMap();
//            temp3.put(FIRST_COLUMN, "Rajeev Barua");
//            temp3.put(SECOND_COLUMN, "58137");
//            temp3.put(THIRD_COLUMN, "barua@eng.umd.edu");
//            temp3.put(FOURTH_COLUMN, "1431");
//            dirList.add(temp3);
//
//            temp4 = new HashMap();
//            temp4.put(FIRST_COLUMN, "Victor Basili");
//            temp4.put(SECOND_COLUMN, "52690");
//            temp4.put(THIRD_COLUMN, "basili@cs.umd.edu");
//            temp4.put(FOURTH_COLUMN, "3175");
//            dirList.add(temp4);
//
//            temp = new HashMap();
//            temp.put(FIRST_COLUMN, "Ben Bederson");
//            temp.put(SECOND_COLUMN, "HBK 53394");
//            temp.put(THIRD_COLUMN, "bederson@cs.umd.edu");
//            temp.put(FOURTH_COLUMN, "HBK 2117D");
//            dirList.add(temp);
//
//            temp1 = new HashMap();
//            temp1.put(FIRST_COLUMN, "Bobby Bhattacharjee");
//            temp1.put(SECOND_COLUMN, "51658");
//            temp1.put(THIRD_COLUMN, "bobby@cs.umd.edu");
//            temp1.put(FOURTH_COLUMN, "4143");
//            dirList.add(temp1);
//
//            temp2 = new HashMap();
//            temp2.put(FIRST_COLUMN, "Marine Carpuat");
//            temp2.put(SECOND_COLUMN, "58801");
//            temp2.put(THIRD_COLUMN, "rama@cfar.umd.edu");
//            temp2.put(FOURTH_COLUMN, "3157");
//            dirList.add(temp2);
//
//            temp4 = new HashMap();
//            temp4.put(FIRST_COLUMN, "Ramalingam Chellappa");
//            temp4.put(SECOND_COLUMN, "53656");
//            temp4.put(THIRD_COLUMN, "rama@cfar.umd.edu");
//            temp4.put(FOURTH_COLUMN, "4411");
//            dirList.add(temp4);
//
//            temp = new HashMap();
//            temp.put(FIRST_COLUMN, "Agrawala Ashok");
//            temp.put(SECOND_COLUMN, "52525");
//            temp.put(THIRD_COLUMN, "agrawala@cs.umd.edu");
//            temp.put(FOURTH_COLUMN, "4149");
//            dirList.add(temp);
//
//            temp1 = new HashMap();
//            temp1.put(FIRST_COLUMN, "John Aloimonos");
//            temp1.put(SECOND_COLUMN, "51743");
//            temp1.put(THIRD_COLUMN, "yiannis@cs.umd.edu");
//            temp1.put(FOURTH_COLUMN, "4475");
//            dirList.add(temp1);
//
//            temp2 = new HashMap();
//            temp2.put(FIRST_COLUMN, "Alexander Barg");
//            temp2.put(SECOND_COLUMN, "57135");
//            temp2.put(THIRD_COLUMN, "abarg@umd.edu");
//            temp2.put(FOURTH_COLUMN, "2361");
//            dirList.add(temp2);
//
//            temp3 = new HashMap();
//            temp3.put(FIRST_COLUMN, "Rajeev Barua");
//            temp3.put(SECOND_COLUMN, "58137");
//            temp3.put(THIRD_COLUMN, "barua@eng.umd.edu");
//            temp3.put(FOURTH_COLUMN, "1431");
//            dirList.add(temp3);
//
//            temp4 = new HashMap();
//            temp4.put(FIRST_COLUMN, "Victor Basili");
//            temp4.put(SECOND_COLUMN, "52690");
//            temp4.put(THIRD_COLUMN, "basili@cs.umd.edu");
//            temp4.put(FOURTH_COLUMN, "3175");
//            dirList.add(temp4);
//
//            temp = new HashMap();
//            temp.put(FIRST_COLUMN, "Ben Bederson");
//            temp.put(SECOND_COLUMN, "HBK 53394");
//            temp.put(THIRD_COLUMN, "bederson@cs.umd.edu");
//            temp.put(FOURTH_COLUMN, "HBK 2117D");
//            dirList.add(temp);
//
//            temp1 = new HashMap();
//            temp1.put(FIRST_COLUMN, "Bobby Bhattacharjee");
//            temp1.put(SECOND_COLUMN, "51658");
//            temp1.put(THIRD_COLUMN, "bobby@cs.umd.edu");
//            temp1.put(FOURTH_COLUMN, "4143");
//            dirList.add(temp1);
//
//            temp2 = new HashMap();
//            temp2.put(FIRST_COLUMN, "Marine Carpuat");
//            temp2.put(SECOND_COLUMN, "58801");
//            temp2.put(THIRD_COLUMN, "rama@cfar.umd.edu");
//            temp2.put(FOURTH_COLUMN, "3157");
//            dirList.add(temp2);
//
//            temp4 = new HashMap();
//            temp4.put(FIRST_COLUMN, "Ramalingam Chellappa");
//            temp4.put(SECOND_COLUMN, "53656");
//            temp4.put(THIRD_COLUMN, "rama@cfar.umd.edu");
//            temp4.put(FOURTH_COLUMN, "4411");
//            dirList.add(temp4);
            //adapter = new listviewAdapter(this, dirList);
            //lview.setAdapter(adapter);
        }else{
            HashMap temp = new HashMap();
            temp.put(FIRST_COLUMN, "Name");
            temp.put(SECOND_COLUMN, "Phone Number");
            temp.put(THIRD_COLUMN, "Email");
            temp.put(FOURTH_COLUMN, "Room Number");
            dirList.add(temp);
        }
    }



//    public ArrayList<String> populateDirectoryList(){
//        ArrayList<String> dirList = new ArrayList<String>();
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        dirList.add("test1");
//        dirList.add("test2");
//        dirList.add("test3");
//        return dirList;
//    }


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


