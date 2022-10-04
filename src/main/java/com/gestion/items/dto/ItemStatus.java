package com.gestion.items.dto;

import com.gestion.items.entidades.Item;

public class ItemStatus {


    private Item item;
    private String status;//progress,completed
    private String message;

    public ItemStatus(Item item, String status, String message) {
        this.item = item;
        this.status = status;
        this.message = message;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
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
