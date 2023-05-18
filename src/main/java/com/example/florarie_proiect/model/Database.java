package com.example.florarie_proiect.model;

import com.example.florarie_proiect.model.Bouquet;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class Database {
    private Nitrite db;
    private ObjectRepository<Bouquet> flowerRepository;

    public Database() {
        db = Nitrite.builder()
                .filePath("src/main/database/flower.db")
                .openOrCreate();

        flowerRepository = db.getRepository(Bouquet.class);
    }

    public void addFlower(String name, int quantity, int price) {
        Bouquet flower = new Bouquet(name,quantity, price);
        flowerRepository.insert(flower);
    }

    public void removeFlower(String name) {
        flowerRepository.remove(ObjectFilters.eq("name", name));
    }

    public double getFlowerPrice(String name) {
        Bouquet flower = flowerRepository.find(ObjectFilters.eq("name", name)).firstOrDefault();
        if (flower != null) {
            return flower.getPrice();
        }
        return 0.0; // Sau aruncă o excepție pentru a semnala că floarea nu există în baza de date
    }

    public void closeDatabase() {
        db.close();
    }
}
