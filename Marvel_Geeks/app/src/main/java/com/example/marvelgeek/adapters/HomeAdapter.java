package com.example.marvelgeek.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelgeek.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class HomeAdapter extends BaseAdapter {
    private final Context mContext;

    private final int[] mImageIdArray = {
            R.drawable.iron_man,
            R.drawable.hulk_1_cover,
            R.drawable.arthur_adams,
            R.drawable.standard_incredible_event,
            R.drawable.series};

    private final String[] mTitleName = {
            "Characters",
            "Comics",
            "Creators",
            "Events",
            "Series’s"};
    public HomeAdapter(Context _context) {
       mContext = _context;
    }

    @Override
    public int getCount() {
        if (mImageIdArray != null){
            return mImageIdArray.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(mImageIdArray != null && mImageIdArray.length > position){
            return mImageIdArray[position];
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
        if (mImageIdArray != null) {
            vh.textHolder.setText(mTitleName[position]);

            Picasso
                    .get()
                    .load(mImageIdArray[position])
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
