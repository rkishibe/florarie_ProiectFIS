import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModifyBouquetTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void modifyBouquet() {
    }

    @Test
    void saveBouquetToDatabase() {

    }

    @Test
    void couldNotWriteBouquetException() {
        assertThrows(CouldNotWriteBouquetException.class, ()->{});
    }

    @AfterEach
    void tearDown() {

    }
}
