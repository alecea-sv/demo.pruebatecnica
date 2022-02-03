package com.pruebatecnica.demo.utils;

public class InvokeMarvelApiService extends InvokeService {

    public final String CHARACTERS = "/characters";

    public InvokeMarvelApiService() {
        super();
        StringBuilder url = new StringBuilder();
        url.append("https://");
        url.append("gateway.marvel.com"); // host
        url.append(":");
        url.append("443"); // port
        url.append("/v1/public/"); // context
        this.endpoint = url.toString();
        this.dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss";
        this.publicKey = "14b4ff4eb69be1613b47809e4376b8e2";
        this.privateKey = "ed86fd7559eb665f1ba4be959370092028defe11";
    }

}
