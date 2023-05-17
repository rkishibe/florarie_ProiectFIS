package com.example.florarie_proiect.test;

/*import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
import com.example.florarie_proiect.services.FileSystemService;
import com.example.florarie_proiect.services.UserService;
import org.apache.commons.io.FileUtils;

>>>>>>> b4adcbcc5dc2a5d4038f04d30e6ab1426bdecbfc:src/main/java/com/example/florarie_proiect/test/UserServiceTest.java

class UserServiceTest {

    public static final String ADMIN = "admin";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
<<<<<<< HEAD:src/main/java/florarie/test/UserServiceTest.java
        FileUtils.cleanDirectory(FileSystemService.getPathToFile().toFile());
=======
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
>>>>>>> b4adcbcc5dc2a5d4038f04d30e6ab1426bdecbfc:src/main/java/com/example/florarie_proiect/test/UserServiceTest.java
        UserService.loadUsersFromFile();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }


    @Test
    @DisplayName("Database is initialized, and there are no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
<<<<<<< HEAD:src/main/java/florarie/test/UserServiceTest.java
        assertThat(UserService.getUsers()).isNotNull());
=======
        assertThat(UserService.getUsers()).isNotNull();
>>>>>>> b4adcbcc5dc2a5d4038f04d30e6ab1426bdecbfc:src/main/java/com/example/florarie_proiect/test/UserServiceTest.java
        assertThat(UserService.getUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is successfully persisted to Database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExists {
        UserService.addUser(ADMIN, ADMIN, ADMIN);
        assertThat(UserService.getUsers()).isNotEmpty();
        assertThat(UserService.getUsers()).size().isEqualTo(1);
        User user = UserService.getUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(ADMIN);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN, ADMIN));
        assertThat(user.getRole()).isEqualTo(ADMIN);
    }

<<<<<<< HEAD:src/main/java/florarie/test/UserServiceTest.java
}
=======
    @Test
    @DisplayName("User can not be added twice")
    void testUserCanNotBeAddedTwice() {
        assertThrows(UsernameAlreadyExists.class, () -> {
*/
