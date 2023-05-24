package com.example.florarie_proiect.services;

import com.example.florarie_proiect.exceptions.CouldNotWriteUsersException;
import com.example.florarie_proiect.exceptions.EmptyUsernameOrPasswordException;
import com.example.florarie_proiect.exceptions.UserDoesNotExistException;
import com.example.florarie_proiect.exceptions.UsernameAlreadyExistsException;
import com.example.florarie_proiect.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectFilter;
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

        try{
            checkUserDoesNotAlreadyExistOrIsNull(username);
            User user = new User(username, encodePassword(username, password), role);
            userRepository.insert(user);
        } catch (CouldNotWriteUsersException | EmptyUsernameOrPasswordException e){
            e.printStackTrace();
        }

        closeDatabase();
    }


    public static boolean checkUserDoesNotAlreadyExistOrIsNull(String username) throws UsernameAlreadyExistsException, EmptyUsernameOrPasswordException {
        // Use Nitrite's API to check if the username already exists in the database
        if(username.isBlank()){
            throw new EmptyUsernameOrPasswordException();
        }
        User existingUser = userRepository.find(ObjectFilters.eq("username", username)).firstOrDefault();

        return existingUser != null;
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


    public static boolean checkPasswordAndRole(String salt, String username, String password, String role) {
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

        if(encodedPassword.toString().equals(user.getPassword()) && role.equals(user.getRole()))
            return true;
        else
            return false;
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
        //userRepository.remove(ObjectFilters.ALL);
        db.close();
    }
}
