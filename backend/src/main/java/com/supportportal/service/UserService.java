package com.supportportal.service;

import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firsName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage);

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String NewEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage);

    void deleteUser(long id);

    void resetPassword(String email);

    User updateProfileImage(String username, MultipartFile profileImage);
}
