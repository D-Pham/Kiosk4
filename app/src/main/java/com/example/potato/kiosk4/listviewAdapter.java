package com.example.potato.kiosk4;

import static com.example.potato.kiosk4.Constant.FIRST_COLUMN;
import static com.example.potato.kiosk4.Constant.SECOND_COLUMN;
import static com.example.potato.kiosk4.Constant.THIRD_COLUMN;
import static com.example.potato.kiosk4.Constant.FOURTH_COLUMN;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Context;

/**
 *
 * @author Paresh N. Mayani
 */
public class listviewAdapter extends BaseAdapter implements Filterable
{
    public ArrayList<HashMap> list;
    public ArrayList<HashMap> reslist;
    Activity activity;


    public listviewAdapter(Activity activity, ArrayList<HashMap> list) {
        super();
        this.activity = activity;
        this.list = list;
        this.reslist = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return reslist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    private class ViewHolder {
        LinearLayout llContainer;
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
        TextView txtFourth;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.llContainer = (LinearLayout)convertView.findViewById(R.id.relativeLayout1);
            holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
            holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
            holder.txtFourth = (TextView) convertView.findViewById(R.id.FourthText);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position < reslist.size()) {
            HashMap map = reslist.get(position);
            holder.txtFirst.setText((String) map.get(FIRST_COLUMN));
            holder.txtSecond.setText((String) map.get(SECOND_COLUMN));
            holder.txtThird.setText((String) map.get(THIRD_COLUMN));
            holder.txtFourth.setText((String) map.get(FOURTH_COLUMN));
        }

        holder.llContainer.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // This is a placeholder until more concrete functionality is implemented
                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.umd.edu/people/egolub"));
                //activity.startActivity(browserIntent);
                activity.setContentView(R.layout.map_tab);
                ImageView img = (ImageView) activity.findViewById(R.id.mapImage);
                img.setImageResource(R.drawable.floor_one_3);
                ((EditText) activity.findViewById(R.id.mapSearch)).setText("Evan Golub");
            }
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                reslist = (ArrayList<HashMap>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<HashMap> FilteredArrList = new ArrayList<HashMap>();

                if (list == null) {
                    list = new ArrayList<HashMap>(reslist); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = list.size();
                    results.values = list;
                } else {
                    //System.out.println(list);
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < list.size(); i++) {
                        String data1 = (String)list.get(i).get(FIRST_COLUMN);
                        String data2 = (String)list.get(i).get(SECOND_COLUMN);
                        String data3 = (String)list.get(i).get(THIRD_COLUMN);
                        String data4 = (String)list.get(i).get(FOURTH_COLUMN);
                        if (data1.toLowerCase().startsWith(constraint.toString()) || data2.toLowerCase().startsWith(constraint.toString())
                                || data3.toLowerCase().startsWith(constraint.toString()) || data4.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(new HashMap(list.get(i)));
                        }
                    }

                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    System.out.println(results.count);
                    results.values = FilteredArrList;
                }
                System.out.println(results.values);
                return results;
            }
        };
        return filter;
    }

}
