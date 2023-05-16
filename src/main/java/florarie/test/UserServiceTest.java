
package florarie.test;

import florarie.exceptions.UsernameAlreadyExists;
import florarie.model.User;
import florarie.services.FileSystemService;
import florarie.services.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertThat;


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
        FileUtils.cleanDirectory(FileSystemService.getPathToFile().toFile());
        UserService.loadUsersFromFile();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }


    @Test
    @DisplayName("Database is initialized, and there are no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getUsers()).isNotNull());
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

}