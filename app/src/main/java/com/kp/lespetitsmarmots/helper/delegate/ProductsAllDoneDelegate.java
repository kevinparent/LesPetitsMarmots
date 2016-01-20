package com.kp.lespetitsmarmots.helper.delegate;

import com.kp.lespetitsmarmots.model.Product;

import java.util.ArrayList;

/**
 * Created by kevin on 2016-01-20.
 */
public interface ProductsAllDoneDelegate extends ProductDelegate {
    void ProductTaskCompletionResult(ArrayList<Product> listProducts);
}
