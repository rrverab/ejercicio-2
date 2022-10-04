package com.gestion.items.dto;

import com.gestion.items.entidades.Items;

public class ItemStatus {


    private Items item;
    private String status;//progress,completed
    private String message;

    public ItemStatus(Items item, String status, String message) {
        this.item = item;
        this.status = status;
        this.message = message;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
