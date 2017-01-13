package com.thunisoft.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * Created by yhan219 on 2017/1/7.
 */
@SolrDocument(solrCoreName = "shop")
public class Phone implements Serializable {

    @Id
    @Field
    private String id;

    @Field
    private String cnum;

    @Field
    private String phonename;

    @Field
    private String screen;

    @Field
    private String disk;

    @Field
    private String memory;

    @Field
    private String price;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCnum() {
        return cnum;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getDisk() {
        return disk;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemory() {
        return memory;
    }

    public void setPhonename(String phonename) {
        this.phonename = phonename;
    }

    public String getPhonename() {
        return phonename;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getScreen() {
        return screen;
    }
}
