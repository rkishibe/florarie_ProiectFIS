//package com.example.florarie_proiect.test;
//
//import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
//import com.example.florarie_proiect.model.User;
//import com.example.florarie_proiect.services.UserService;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.testfx.framework.junit5.ApplicationExtension;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.testfx.assertions.api.Assertions.assertThat;
//
//@ExtendWith(ApplicationExtension.class)
//class UserServiceTest {
//
//    public static final String ADMIN = "admin";
//
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Before Class");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("After Class");
//    }
//
//    @BeforeEach
//    void setUp() throws Exception {
//        UserService.loadUsersFromDatabase();
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("After each");
//    }
//
//
//    @Test
//    @DisplayName("Database is initialized, and there are no users")
//    void testDatabaseIsInitializedAndNoUserIsPersisted() {
//        assertThat(UserService.getUsers()).isNotNull();
//        assertThat(UserService.getUsers()).isEmpty();
//    }
//
//    @Test
//    @DisplayName("User is successfully persisted to Database")
//    void testUserIsAddedToDatabase() throws UsernameAlreadyExists {
//        UserService.addUser(ADMIN, ADMIN, ADMIN);
//        assertThat(UserService.getUsers()).isNotEmpty();
//        assertThat(UserService.getUsers()).size().isEqualTo(1);
//        User user = UserService.getUsers().get(0);
//        assertThat(user).isNotNull();
//        assertThat(user.getUsername()).isEqualTo(ADMIN);
//        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN, ADMIN));
//        assertThat(user.getRole()).isEqualTo(ADMIN);
//    }
//
//    @Test
//    @DisplayName("User can not be added twice")
//    void testUserCanNotBeAddedTwice() {
//        assertThrows(UsernameAlreadyExists.class, () -> {});
//    }
//}
