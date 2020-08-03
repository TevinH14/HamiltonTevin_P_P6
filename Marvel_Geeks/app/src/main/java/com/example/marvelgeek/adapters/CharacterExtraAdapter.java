package com.example.marvelgeek.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelgeek.R;
import com.example.marvelgeek.models.Characters;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class CharacterExtraAdapter extends BaseAdapter {
    private final String[] mTitleArray;
    private final int[] mImageArray;
    private final Context mContext;
    private final Characters mCharacter;

    public CharacterExtraAdapter(Context mContext, Characters mCharacter ,
                                 HashMap<String, Integer> availableExtras) {
        this.mContext = mContext;
        this.mCharacter = mCharacter;

        mTitleArray = new String[availableExtras.size()];
        mImageArray = new int[availableExtras.size()];
        int counter = 0;
        for (HashMap.Entry<String, Integer> entry : availableExtras.entrySet()) {
            if(counter < availableExtras.size()) {
                mTitleArray[counter] = entry.getKey();
                mImageArray[counter] = entry.getValue();
                counter += 1;
            }
        }
    }

    @Override
    public int getCount() {
        if (mTitleArray != null){
            return mTitleArray.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if( mTitleArray!= null && mTitleArray.length > position){
            return mTitleArray[position];
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
                    .inflate(R.layout.gv_cd_extra_display, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        if (mTitleArray != null) {

            vh.titleHolder.setText(mTitleArray[position]);
            String availableString = "Available:"+ getAvailableData(mTitleArray[position]);
            vh.availableHolder.setText(availableString);
            Picasso
                    .get()
                    .load(mImageArray[position])
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

    private String getAvailableData(String string){
        String returnString = "";
        switch (string) {
            case "Comics":
                returnString = String.valueOf(mCharacter.getAvailableComics());
                break;
            case "Events":
                returnString = String.valueOf(mCharacter.getAvailableEvents());
                break;
            case "Series's":
                returnString = String.valueOf(mCharacter.getAvailableSeries());
                break;
            case "Stories":
                returnString = String.valueOf(mCharacter.getAvailableStories());
                break;
        }
        return returnString;
    }
    static class ViewHolder{
        final ImageView imageHolder;
        final TextView titleHolder;
        final TextView availableHolder;

        ViewHolder(View layout) {
            this.imageHolder = layout.findViewById(R.id.iv_cdExtra);
            this.titleHolder = layout.findViewById(R.id.tv_cdExtra_title);
            this.availableHolder = layout.findViewById(R.id.tv_cdExtra_available);
        }
    }
}
