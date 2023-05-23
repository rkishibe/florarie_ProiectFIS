package com.example.florarie_proiect.model;

import org.dizitart.no2.Document;

public class Bouquet {
        private String name;
        private int price;
        private int quantity;

        public Bouquet(String name, int quantity, int price) {
            this.name = name;
            this.quantity = quantity;
            this.price=price;
        }

    public static Bouquet fromDocument(Document document) {
        String name = document.get("name", String.class);
        int quantity = document.get("quantity", Integer.class);
        int price = document.get("price", Integer.class);
        return new Bouquet(name, quantity, price);
    }


    // getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity(){
            return quantity;
        }

        public void setQuantity(int quantity){
            this.quantity=quantity;
        }

        public Document toDocument() {
        Document document = new Document();
        document.put("name", getName());
        document.put("quantity", getQuantity());
        document.put("price", getPrice());
        return document;
    }
}
