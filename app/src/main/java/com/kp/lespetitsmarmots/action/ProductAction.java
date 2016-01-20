package com.kp.lespetitsmarmots.action;

import android.util.Log;

import com.kp.lespetitsmarmots.helper.delegate.ProductByIdDoneDelegate;
import com.kp.lespetitsmarmots.helper.delegate.ProductsAllDoneDelegate;
import com.kp.lespetitsmarmots.model.Product;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016-01-20.
 */
public class ProductAction {
    private ArrayList<Product> listProducts;
    private ProductsAllDoneDelegate productsDelegate;
    private ProductByIdDoneDelegate productDelegate;

    public ProductAction(ProductsAllDoneDelegate delegate) {
        this.productsDelegate = delegate;
    }

    public ProductAction(ProductByIdDoneDelegate delegate) {
        this.productDelegate = delegate;
    }

    public void getProductById(String id) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Product.getObjectName());
        query.getInBackground(id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    Product product = new Product();
                    product.setId(parseObject.getObjectId());
                    product.setTitle(parseObject.getString("title"));
                    product.setSubtitle(parseObject.getString("subtitle"));
                    product.setContent(parseObject.getString("content"));
                    product.setUrlPath(parseObject.getParseFile("icon").getUrl());

                    productDelegate.productByIdDoneCompletionResult(product);
                } else {
                    Log.d("Failed", "Failed");
                }
            }
        });
    }

    public void getAllProducts() {
        listProducts = new ArrayList<>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery(Product.getObjectName());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("List = ", "" + list.size());
                    listProducts.clear();
                    for (ParseObject p : list) {
                        Product pr = new Product();
                        pr.setId(p.getObjectId());
                        pr.setTitle(p.getString("title"));
                        pr.setSubtitle(p.getString("subtitle"));
                        pr.setUrlPath(p.getParseFile("icon").getUrl());

                        listProducts.add(pr);
                    }
                    Log.d("Marmots", "List lenght = " + listProducts.size());
                    productsDelegate.ProductTaskCompletionResult(listProducts);
                } else {
                    Log.d("Failed", "Failed");
                }
            }
        });
    }

}
