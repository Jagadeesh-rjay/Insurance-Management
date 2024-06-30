package com.cms.user.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cms.user.dao.UserDao;
import com.cms.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplDiffblueTest {
    @MockBean
    private UserDao userDao;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#registerUser(User)}
     */
    @Test
    void testRegisterUser() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.save(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setAge(1);
        user2.setCity("Oxford");
        user2.setContact("Contact");
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPincode("Pincode");
        user2.setRole("Role");
        user2.setStatus(1);
        user2.setStreet("Street");

        // Act
        User actualRegisterUserResult = userServiceImpl.registerUser(user2);

        // Assert
        verify(userDao).save(isA(User.class));
        assertSame(user, actualRegisterUserResult);
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(User)}
     */
    @Test
    void testUpdateUser() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.save(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setAge(1);
        user2.setCity("Oxford");
        user2.setContact("Contact");
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPincode("Pincode");
        user2.setRole("Role");
        user2.setStatus(1);
        user2.setStreet("Street");

        // Act
        User actualUpdateUserResult = userServiceImpl.updateUser(user2);

        // Assert
        verify(userDao).save(isA(User.class));
        assertSame(user, actualUpdateUserResult);
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(int)}
     */
    @Test
    void testGetUserById() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        Optional<User> ofResult = Optional.of(user);
        when(userDao.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        User actualUserById = userServiceImpl.getUserById(1);

        // Assert
        verify(userDao).findById(eq(1));
        assertSame(user, actualUserById);
    }

    /**
     * Method under test:
     * {@link UserServiceImpl#getUserByEmailAndPassword(String, String)}
     */
    @Test
    void testGetUserByEmailAndPassword() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.findByEmailIdAndPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(user);

        // Act
        User actualUserByEmailAndPassword = userServiceImpl.getUserByEmailAndPassword("jane.doe@example.org", "iloveyou");

        // Assert
        verify(userDao).findByEmailIdAndPassword(eq("jane.doe@example.org"), eq("iloveyou"));
        assertSame(user, actualUserByEmailAndPassword);
    }

    /**
     * Method under test:
     * {@link UserServiceImpl#getUserByEmailAndPasswordAndRole(String, String, String)}
     */
    @Test
    void testGetUserByEmailAndPasswordAndRole() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.findByEmailIdAndPasswordAndRole(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(user);

        // Act
        User actualUserByEmailAndPasswordAndRole = userServiceImpl.getUserByEmailAndPasswordAndRole("jane.doe@example.org",
                "iloveyou", "Role");

        // Assert
        verify(userDao).findByEmailIdAndPasswordAndRole(eq("jane.doe@example.org"), eq("iloveyou"), eq("Role"));
        assertSame(user, actualUserByEmailAndPasswordAndRole);
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.findByEmailId(Mockito.<String>any())).thenReturn(user);

        // Act
        User actualUserByEmail = userServiceImpl.getUserByEmail("jane.doe@example.org");

        // Assert
        verify(userDao).findByEmailId(eq("jane.doe@example.org"));
        assertSame(user, actualUserByEmail);
    }

    /**
     * Method under test:
     * {@link UserServiceImpl#getUsersByRoleAndStatus(String, int)}
     */
    @Test
    void testGetUsersByRoleAndStatus() {
        // Arrange
        ArrayList<User> userList = new ArrayList<>();
        when(userDao.findByRoleAndStatus(Mockito.<String>any(), anyInt())).thenReturn(userList);

        // Act
        List<User> actualUsersByRoleAndStatus = userServiceImpl.getUsersByRoleAndStatus("Role", 1);

        // Assert
        verify(userDao).findByRoleAndStatus(eq("Role"), eq(1));
        assertTrue(actualUsersByRoleAndStatus.isEmpty());
        assertSame(userList, actualUsersByRoleAndStatus);
    }

    /**
     * Method under test:
     * {@link UserServiceImpl#getUserByEmailAndRole(String, String)}
     */
    @Test
    void testGetUserByEmailAndRole() {
        // Arrange
        User user = new User();
        user.setAge(1);
        user.setCity("Oxford");
        user.setContact("Contact");
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setId(1);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPincode("Pincode");
        user.setRole("Role");
        user.setStatus(1);
        user.setStreet("Street");
        when(userDao.findByEmailIdAndRole(Mockito.<String>any(), Mockito.<String>any())).thenReturn(user);

        // Act
        User actualUserByEmailAndRole = userServiceImpl.getUserByEmailAndRole("jane.doe@example.org", "Role");

        // Assert
        verify(userDao).findByEmailIdAndRole(eq("jane.doe@example.org"), eq("Role"));
        assertSame(user, actualUserByEmailAndRole);
    }
}
