package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExistsException;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.model.User;
import org.dizitart.no2.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.dizitart.no2.Document.createDocument;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class BouquetServiceTest {
    public static final String NUME = "NumeBouquet";
    public static final String QUANTITY="10";
    public static final String PRICE="3";

    @BeforeEach
    void setUp() {
        BouquetService.loadBouquetsFromDatabase();
    }

    @AfterEach
    void tearDown() {

        BouquetService.closeDatabase();
    }

    @Test
    @DisplayName("Baza de date cu Buchete e initializata")
    void testBazaDeDateEsteInitializata() {
        assertThat(BouquetService.getBouquet()).isNotNull();
        assertThat(BouquetService.getBouquet()).isEmpty();
    }

    @DisplayName("Buchet adaugat in baza de date")
    @Test
    void testBuchetAdaugatInBazaDeDate(){
        Document doc= createDocument("name", NUME)
                .put("quantity", QUANTITY)
                .put("price", PRICE);
        BouquetService.addBouquet(doc);
        assertThat(BouquetService.getBouquet()).isNotEmpty();
        assertThat(BouquetService.getBouquet()).size().isEqualTo(1);
        Bouquet buchet = Bouquet.fromDocument(BouquetService.getBouquet().get(0));
        assertThat(buchet).isNotNull();
        assertThat(buchet.getName()).isEqualTo(NUME);
        assertThat(buchet.getPrice()).isEqualTo(PRICE);
        assertThat(buchet.getQuantity()).isEqualTo(QUANTITY);
    }

}