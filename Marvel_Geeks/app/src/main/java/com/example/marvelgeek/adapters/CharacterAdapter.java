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

import java.util.ArrayList;

public class CharacterAdapter  extends BaseAdapter {
    private Context mContext;
    private ArrayList<Characters> mCharactersList;
    private static final String IMAGE_ENDPOINT = "/portrait_small.jpg";
    public CharacterAdapter(Context _context, ArrayList<Characters> _charactersList) {
        mContext =_context;
        mCharactersList = _charactersList;
    }

    @Override
    public int getCount() {
        if (mCharactersList != null){
            return mCharactersList.size();
        }
        return 0;    }

    @Override
    public Object getItem(int position) {
        if( mCharactersList!= null && mCharactersList.size() > position){
            return mCharactersList.get(position);
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
        if (mCharactersList != null) {
            Characters character = mCharactersList.get(position);
            vh.textHolder.setText(character.getCharacterName());

            Picasso
                    .get()
                    .load(character.getCharacterUrl()+IMAGE_ENDPOINT)
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
            this.imageHolder = layout.findViewById(R.id.iv_category_home);
            this.textHolder = layout.findViewById(R.id.tv_title_home);
        }
    }
}


