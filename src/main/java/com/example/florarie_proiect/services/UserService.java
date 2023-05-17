package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
import com.example.florarie_proiect.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserService {

    private static Nitrite db;
    private static ObjectRepository<User> userRepository;

    public static void loadUsersFromDatabase() {
        // Open or create the Nitrite database
        db = Nitrite.builder()
                .compressed()
                .filePath("user-database.db")
                .openOrCreate();

        // Get the user repository
        userRepository = db.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExists {
        checkUserDoesNotAlreadyExist(username);
        User user = new User(username, encodePassword(username, password), role);

        // Insert the user into the Nitrite database
        userRepository.insert(user);
        closeDatabase();
    }


    public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExists {
        // Use Nitrite's API to check if the username already exists in the database
        User existingUser = userRepository.find(ObjectFilters.eq("username", username))
                .firstOrDefault();

        if (existingUser != null) {
            throw new UsernameAlreadyExists(username);
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder encodedPassword = new StringBuilder();
        for (byte b : hashedPassword) {
            encodedPassword.append(String.format("%02x", b));
        }

        return encodedPassword.toString();
    }


    public static boolean checkPassword(String salt, String username, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        User user = userRepository.find(ObjectFilters.eq("username", username))
                .firstOrDefault();

        if (user == null) {
            // User not found
            return false;
        }

        // Hash the input password with the user's salt
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // Convert the byte array to a String using UTF-8 encoding
        String hashedPasswordString = new String(hashedPassword, StandardCharsets.UTF_8);

        // Compare the two hashes to see if they match
        return hashedPasswordString.equals(user.getPassword());
    }


    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static List<User> getUsers() {
        // Retrieve all users from the Nitrite database
        return userRepository.find().toList();
    }
    public static void closeDatabase(){
        db.close();
    }
}
