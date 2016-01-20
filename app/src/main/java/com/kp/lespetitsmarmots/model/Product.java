package com.kp.lespetitsmarmots.model;

import java.io.File;

/**
 * Created by kevin on 2016-01-18.
 */
public class Product {
    private static String objectName = "_Product";

    private String id;
    private File download;
    private int order;
    private String downloadName;
    private String subtitle;
    private String title;
    private String productIdentifier;
    private String urlPath;
    private String content;

    public Product(){
    }

    public Product(String pId, String subtitle, String title) {
        this.id = pId;
        this.title = title;
        this.subtitle = subtitle;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return this.getTitle();
    }


    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public static String getObjectName() {
        return objectName;
    }

    public static void setObjectName(String objectName) {
        Product.objectName = objectName;
    }

    public File getDownload() {
        return download;
    }

    public void setDownload(File download) {
        this.download = download;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void setDownloadName(String downloadName) {
        this.downloadName = downloadName;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
}
