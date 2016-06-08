package com.avinash.phonecat.model;

public class PhoneCatModel {
    private String name;
    private String snippet;

    public PhoneCatModel(String name, String snippet) {
        this.name = name;
        this.snippet = snippet;
    }

    public String getName() {
        return name;
    }

    public String getSnippet() {
        return snippet;
    }

}
