package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.CouldNotWriteUsersException;
import com.example.florarie_proiect.exceptions.UserDoesNotExistException;
import com.example.florarie_proiect.exceptions.UsernameAlreadyExistsException;
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

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException, CouldNotWriteUsersException {
        checkUserDoesNotAlreadyExist(username);
        User user = new User(username, encodePassword(username, password), role);

        // Insert the user into the Nitrite database
        try{
            userRepository.insert(user);
        } catch (CouldNotWriteUsersException e){
            e.printStackTrace();
        }

        closeDatabase();
    }


    public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        // Use Nitrite's API to check if the username already exists in the database
        User existingUser = userRepository.find(ObjectFilters.eq("username", username))
                .firstOrDefault();

        if (existingUser != null) {
            throw new UsernameAlreadyExistsException(username);
        }
    }

    public static boolean checkUserDoesNotExist(String username) throws UserDoesNotExistException {
        // Use Nitrite's API to check if the username already exists in the database
        User existingUser = userRepository.find(ObjectFilters.eq("username", username))
                .firstOrDefault();

        if (existingUser == null) {
            return false;
        }else{
            return true;
        }
    }

    public static String encodePassword(String salt, String password) {
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

        User user = userRepository.find(ObjectFilters.eq("username", username)).firstOrDefault();

        if (user == null) {
            // User not found
            return false;
        }

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder encodedPassword = new StringBuilder();
        for (byte b : hashedPassword) {
            encodedPassword.append(String.format("%02x", b));
        }

        return encodedPassword.toString().equals(user.getPassword());
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
