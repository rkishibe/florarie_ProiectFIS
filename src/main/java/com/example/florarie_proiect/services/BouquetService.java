package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.exceptions.BouquetDoesntExistException;
import com.example.florarie_proiect.model.Bouquet;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import static org.dizitart.no2.Document.createDocument;
import static org.dizitart.no2.filters.Filters.eq;

public class BouquetService {
    private static Nitrite db;
  /*  private static ObjectRepository<Bouquet> flowerRepository;

    public static void loadBouquetsFromDatabase() {
        db = Nitrite.builder()
                .compressed()
                .filePath("flowers.db")
                .openOrCreate();

        flowerRepository = db.getRepository(Bouquet.class);
    }


    public static void addBouquet(Bouquet bouquet) {

        if(bouquet.getName().isBlank() || bouquet.getQuantity()<0 || bouquet.getPrice()<0){
            throw new CouldNotWriteBouquetException();
        }
        flowerRepository.insert(bouquet);
        BouquetService.closeDatabase();
    }

    public static void removeBouquet(String name) throws BouquetDoesntExistException {
        try{
            flowerRepository.remove(ObjectFilters.eq("name", name));
        }catch(BouquetDoesntExistException e){
            e.printStackTrace();
        }
    }

    public static double getBouquetPrice(String name) throws BouquetDoesntExistException{
        try {
            Bouquet flower = flowerRepository.find(ObjectFilters.eq("name", name)).firstOrDefault();
            if (flower != null) {
                return flower.getPrice();
            }
        } catch (BouquetDoesntExistException e){
            e.printStackTrace();
        }

        return 0;
    }

    public static void modifyBouquet(Bouquet bouquet) {
        try {
            Bouquet existingBouquet = flowerRepository.find(ObjectFilters.eq("name", bouquet.getName())).firstOrDefault();
            if (existingBouquet != null) {
                existingBouquet.setQuantity(bouquet.getQuantity());
                existingBouquet.setPrice(bouquet.getPrice());

                addBouquet(existingBouquet);
            }
        } catch (BouquetDoesntExistException e) {
            e.printStackTrace();
            throw new BouquetDoesntExistException();
        }
    }

   */

    private static NitriteCollection flowerCollection;
    public static void loadBouquetsFromDatabase() {
        db = Nitrite.builder()
                .compressed()
                .filePath("flowers.db")
                .openOrCreate();

        flowerCollection = db.getCollection("test");
    }







    public static void addBouquet(Document doc) {

        //// if(doc.getName().isBlank() || bouquet.getQuantity()<0 || bouquet.getPrice()<0){
        // throw new CouldNotWriteBouquetException();

        flowerCollection.insert(doc);
        BouquetService.closeDatabase();
    }

    public static void removeBouquet(String name) throws BouquetDoesntExistException {
        try{
            flowerCollection.remove(ObjectFilters.eq("name", name));
        }catch(BouquetDoesntExistException e){
            e.printStackTrace();
        }
    }

    public static double getBouquetPrice(String name) throws BouquetDoesntExistException{
        try {
            Document flower = flowerCollection.find(ObjectFilters.eq("name", name)).firstOrDefault();
            if (flower != null) {
                return  99 ;//flower.getPrice();
            }
        } catch (BouquetDoesntExistException e){
            e.printStackTrace();
        }

        return 0;
    }

    public static void modifyBouquet(Bouquet bouquet) {
        try {
            Document existingBouquet = flowerCollection.find(ObjectFilters.eq("name", bouquet.getName())).firstOrDefault();
            if (existingBouquet != null) {

                flowerCollection.update(eq("name", bouquet.getName() ), createDocument("quantity", bouquet.getQuantity()));
                flowerCollection.update(eq("name", bouquet.getName() ), createDocument("price", bouquet.getPrice()));

                //addBouquet(existingBouquet);
            }
        } catch (BouquetDoesntExistException e) {
            e.printStackTrace();
            throw new BouquetDoesntExistException();
        }
    }


    public static void closeDatabase() {
        db.close();
    }
}
