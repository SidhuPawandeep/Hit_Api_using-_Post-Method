package com.example.lenovo.fetchgrouplistwithimage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lENOVO on 7/25/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHold> {

    ArrayList<FetchGroupList> data;

    public MyAdapter(ArrayList<FetchGroupList> data) {
        this.data = data;
    }

    public MyAdapter.ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new ViewHold(v);
    }


    public void onBindViewHolder(MyAdapter.ViewHold holder, int pos) {
        FetchGroupList category = data.get(pos);
        holder.id.setText(category.getId());
        String date=createdDate(category.getCreated_at());
        holder.name.setText(category.getName());
        holder.created_date.setText(date);
        String img_path=category.getImage_path();
        Glide.with(holder.mContext).load(img_path).into(holder.imageView);
        //holder.imageView.setImageResource(img_path);

    }

    public String createdDate(String time) {
        String givenDateFormat = "yyyy-MM-dd HH:mm:ss";
        String outputDateFormat = "dd-MMM-yyyy h:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(givenDateFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int getItemCount() {
        return data.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        public TextView id,name,created_date;
        public ImageView imageView;
        public  Context mContext;

        public ViewHold(View items) {
            super(items);
            id=(TextView) items.findViewById(R.id.get_id);
            name = (TextView) items.findViewById(R.id.get_name);
            created_date=(TextView) items.findViewById(R.id.get_date);
            imageView=(ImageView)items.findViewById(R.id.productImage);
            mContext=items.getContext();

        }

    }
}
