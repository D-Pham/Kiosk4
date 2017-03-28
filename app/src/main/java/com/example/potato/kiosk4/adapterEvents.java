package com.example.potato.kiosk4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapterEvents extends BaseAdapter{

    Context context;
    List<Events> rowItems;

    adapterEvents(Context context, List<Events> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        ImageView pic;
        TextView name;
        TextView description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.pic = (ImageView) convertView
                    .findViewById(R.id.pic);
            holder.name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.description = (TextView) convertView.findViewById(R.id.description);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Events row_pos = rowItems.get(position);
        int id = context.getResources().getIdentifier(row_pos.getPic(), "drawable", context.getPackageName());
        System.out.println(id);
        holder.pic.setImageResource(id);
        holder.name.setText(row_pos.getName());
        holder.description.setText(row_pos.getDescription());

        return convertView;
    }
}
