package com.kp.lespetitsmarmots.helper.delegate;

import com.kp.lespetitsmarmots.model.Product;

/**
 * Created by kevin on 2016-01-20.
 */
public interface ProductByIdDoneDelegate extends ProductDelegate {
    void productByIdDoneCompletionResult(Product product);
}
