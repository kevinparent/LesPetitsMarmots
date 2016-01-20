package com.kp.lespetitsmarmots.helper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kp.lespetitsmarmots.R;
import com.kp.lespetitsmarmots.helper.task.DownloadImageTask;
import com.kp.lespetitsmarmots.model.Product;

import java.util.List;

/**
 * Created by kevin on 2016-01-18.
 */
public class ProductAdapter extends ArrayAdapter<Product> {
    Product p;


    public ProductAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ProductAdapter(Context context, int resource, List<Product> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlistrow, null);
        }

        p = getItem(position);

        if (p != null) {
            ImageView iv1 = (ImageView) v.findViewById(R.id.image);
            TextView tt1 = (TextView) v.findViewById(R.id.title);
            TextView tt2 = (TextView) v.findViewById(R.id.subtitle);

            if (tt1 != null) {
                tt1.setText(p.getTitle());
            }

            if (tt2 != null) {
                tt2.setText(p.getSubtitle());
            }
            if (iv1 != null) {
                new DownloadImageTask(iv1, p.getUrlPath())
                        .execute();
            }
        }

        return v;
    }
}