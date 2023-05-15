package com.example.florarie_proiect.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.florarie_proiect.exceptions.CouldNotWriteUsers;
import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
import com.example.florarie_proiect.model.User;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class UserService {

    private static List<User> users;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExists {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(username, encodePassword(username, password), role));
        persistUsers();
    }

    public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExists {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExists(username);
        }
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsers();
        }
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    public static boolean checkPassword(String salt, String username, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        // Find the user with the given username
        User user = null;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                user = u;
                break;
            }
        }

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

    private static byte[] hashPassword(String password, String salt) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
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
        return users;
    }
}
