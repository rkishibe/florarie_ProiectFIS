package com.example.florarie_proiect.controllers;
import com.example.florarie_proiect.model.Bouquet;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController {
    @FXML
    private ListView<Bouquet> flowerListView;

    private ObjectRepository<Bouquet> flowerRepository;

    public void initializeList() {
        Nitrite db = Nitrite.builder()
                .filePath("src/main/database/flower.db")
                .openOrCreate();

        flowerRepository = db.getRepository(Bouquet.class);

        // Obține lista de flori din baza de date
        List<Bouquet> flowers = getAllFlowers();

        // Convertă lista de flori într-o listă observabilă
        ObservableList<Bouquet> flowerObservableList = FXCollections.observableArrayList(flowers);

        // Setează modelul de date pentru ListView
        flowerListView.setItems(flowerObservableList);
    }


    public List<Bouquet> getAllFlowers() {
        Cursor<Bouquet> cursor = flowerRepository.find();
        List<Bouquet> flowers = new ArrayList<>();
        for (Bouquet flower : cursor) {
            flowers.add(flower);
        }
        return flowers;
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle){
//        flowerListView.setCellFactory(param -> new ListCell<Bouquet>() {
//            @Override
//            protected void updateItem(Bouquet item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if (empty || item == null || item.getWord() == null) {
//                    setText(null);
//                } else {
//                    setText(item.getWord());
//                }
//            }
//        });
//    }
    public void closeDatabase() {
        flowerRepository.close();
    }
}


