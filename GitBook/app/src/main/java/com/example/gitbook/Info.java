package com.example.gitbook;

public class Info {
    String name,writer,Indroduce;
    Integer image_src;

    public Info(String name, String writer, String Indroduce, int image_src) {
        this.image_src=image_src;
        this.name=name;
        this.writer=writer;
        this.Indroduce=Indroduce;
    }


    public String getName() {
        return name;
    }
    public Integer getImage_src(){
        return image_src;
    }
    public String getWriter(){return writer;}
    public String getIndroduce(){return  Indroduce;}

    public void setName(String name) {
        this.name = name;
    }
    public void setImage_src(Integer image_src) {
        this.image_src = image_src;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


    public void setIndroduce(String indroduce) {
        Indroduce= indroduce;
    }

}