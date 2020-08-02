package com.example.marvelgeek.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Marvel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Marvel> mMarvelList;
    public DisplayAdapter(Context _context, ArrayList<Marvel> _charactersList) {
        mContext =_context;
        mMarvelList = _charactersList;
    }

    @Override
    public int getCount() {
        if (mMarvelList != null){
            return mMarvelList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if( mMarvelList!= null && mMarvelList.size() > position){
            return mMarvelList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.gv_display_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        if (mMarvelList != null) {
            Marvel obj = mMarvelList.get(position);
            vh.textHolder.setText(obj.getName());

            Picasso
                    .get()
                    .load(obj.getImageUrl()+FragmentUtils.LARGE_IMAGE_ENDPOINT)
                    .resize(200,200)
                    .into(vh.imageHolder,new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });

            return convertView;
        }
        return null;
    }


    static class ViewHolder{
        final ImageView imageHolder;
        final TextView textHolder;

        public ViewHolder(View layout) {
            this.imageHolder = layout.findViewById(R.id.iv_category_display);
            this.textHolder = layout.findViewById(R.id.tv_title_display);
        }
    }
}


