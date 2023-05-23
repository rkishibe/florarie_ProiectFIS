package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.BouquetDoesntExistException;
import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.model.User;
import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import org.dizitart.no2.Filter;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import static org.dizitart.no2.Document.createDocument;
import static org.dizitart.no2.filters.Filters.eq;

public class BouquetService {
    private static Nitrite db;
   public static ObjectRepository<Bouquet> flowerRepository;

    private static NitriteCollection flowerCollection;
    public static void loadBouquetsFromDatabase() {
        db = Nitrite.builder()
                .compressed()
                .filePath("flowers.db")
                .openOrCreate();

        flowerCollection = db.getCollection("test");
    }

    public static Cursor findBouquet(){
        return flowerCollection.find();
    }

    public static void addBouquet(Document doc) {
        //Bouquet bouquet = new Bouquet();
       // bouquet.fromDocument(doc);
      //  if (bouquet.getName().isBlank() || bouquet.getQuantity() < 0 || bouquet.getPrice() < 0) {
        //     throw new CouldNotWriteBouquetException();

            flowerCollection.insert(doc);
            BouquetService.closeDatabase();

    }

    public static void removeBouquet(String name) throws NullPointerException {

           try {
                flowerCollection.remove(eq("name", name));
           } catch (NullPointerException e) {

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

    public static void modifyBouquet(String selectedBouquet, Bouquet modifiedBouquet) {
        try {
            Document existingBouquet = flowerCollection.find(eq("name", selectedBouquet)).firstOrDefault();
            if (existingBouquet != null) {
                flowerCollection.update(eq("name", selectedBouquet), createDocument("quantity", modifiedBouquet.getQuantity()));
                flowerCollection.update(eq("name", selectedBouquet), createDocument("price", modifiedBouquet.getPrice()));
            }
        } catch (BouquetDoesntExistException e) {
            e.printStackTrace();
            throw new BouquetDoesntExistException();
        }
    }



    public static void closeDatabase() {
        db.close();
    }

    public static NitriteCollection getFlowerCollection() {
        return flowerCollection;
    }
}
