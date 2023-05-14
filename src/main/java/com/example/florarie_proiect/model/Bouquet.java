package com.example.florarie_proiect.model;

public class Bouquet {
        private String name;
        private int price;
        private int quantity;

        public Bouquet(String name, int quantity, int price) {
            this.name = name;
            this.quantity = quantity;
            this.price=price;
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
    }
