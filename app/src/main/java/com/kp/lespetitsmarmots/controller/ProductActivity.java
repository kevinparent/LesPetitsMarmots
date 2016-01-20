package com.kp.lespetitsmarmots.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.kp.lespetitsmarmots.R;
import com.kp.lespetitsmarmots.action.ProductAction;
import com.kp.lespetitsmarmots.helper.delegate.ProductByIdDoneDelegate;
import com.kp.lespetitsmarmots.helper.task.DownloadImageTask;
import com.kp.lespetitsmarmots.model.Product;

/**
 * Created by kevin on 2016-01-20.
 */
public class ProductActivity extends AppCompatActivity implements ProductByIdDoneDelegate {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewStub vs = (ViewStub) findViewById(R.id.layout_stub);
        vs.setInflatedId(R.id.layout_stub);
        vs.setLayoutResource(R.layout.content_product);
        vs.inflate();

        Bundle b = getIntent().getExtras();
        String id = b.getString("productId");

        getProductData(id);
    }

    @Override
    public void productByIdDoneCompletionResult(Product product) {
        showProduct(product);
    }

    public void showProduct(Product product) {
        ImageView iv1 = (ImageView) findViewById(R.id.image);
        TextView tt1 = (TextView) findViewById(R.id.title);
        TextView tt2 = (TextView) findViewById(R.id.content);

        tt1.setText(product.getTitle());
        tt2.setText(product.getContent());
        new DownloadImageTask(iv1, product.getUrlPath())
                .execute();

    }

    public void getProductData(String id) {
        ProductAction productAction = new ProductAction(this);
        productAction.getProductById(id);
    }

}
