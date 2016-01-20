package com.kp.lespetitsmarmots.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kp.lespetitsmarmots.action.ProductAction;
import com.kp.lespetitsmarmots.helper.adapter.ProductAdapter;
import com.kp.lespetitsmarmots.R;
import com.kp.lespetitsmarmots.helper.delegate.ProductsAllDoneDelegate;
import com.kp.lespetitsmarmots.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductsAllDoneDelegate {

    private GridView products;
    private List<Product> listProducts;
    private ProductAdapter adapter;
    private ProductAction productAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewStub vs = (ViewStub) findViewById(R.id.layout_stub);
        vs.setInflatedId(R.id.layout_stub);
        vs.setLayoutResource(R.layout.content_main);
        vs.inflate();

        products = (GridView)findViewById(R.id.listProducts);

        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("productId", listProducts.get(position).getId());
                startActivity(intent);
            }
        });

        listProducts = new ArrayList<>();
        adapter = new ProductAdapter(this, R.layout.itemlistrow, listProducts);
        products.setAdapter(adapter);

        refreshProductList();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void ProductTaskCompletionResult(ArrayList<Product> products) {
        listProducts.addAll(products);
        adapter.notifyDataSetChanged();
    }

    public void refreshProductList() {
        productAction = new ProductAction(this);
        productAction.getAllProducts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
