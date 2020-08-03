package com.example.marvelgeek.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.marvelgeek.R;
import com.example.marvelgeek.models.Creators;

import java.util.ArrayList;

public class CreatorAdapter extends BaseAdapter {
    private final ArrayList<Creators> mCreatorList;
    private final Context mContext;

    public CreatorAdapter(ArrayList<Creators> _creatorList, Context mContext) {
        mCreatorList = _creatorList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if (mCreatorList != null){
            return mCreatorList.size();
        }
        return 0;    }

    @Override
    public Object getItem(int position) {
        if( mCreatorList!= null && mCreatorList.size() > position){
            return mCreatorList.get(position);
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
                    .inflate(R.layout.creator_display_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        if (mCreatorList != null) {
            Creators c = mCreatorList.get(position);
            vh.nameHolder.setText(c.getName());
            String availableString = String.valueOf(c.getAvailableComics());
            vh.availableHolder.setText(availableString);
            return convertView;
        }
        return null;
    }

    static class ViewHolder{
        final TextView nameHolder;
        final TextView availableHolder;

        public ViewHolder(View layout) {
            this.nameHolder = layout.findViewById(R.id.tv_creatorName);
            this.availableHolder = layout.findViewById(R.id.tv_numComics);
        }
    }
}
