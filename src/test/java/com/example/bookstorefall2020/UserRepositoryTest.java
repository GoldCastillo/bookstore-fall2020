package com.example.bookstorefall2020;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstorefall2020.model.User;
import com.example.bookstorefall2020.model.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    
    
    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("user");
        assertThat(user).isNotNull();
        assertThat(user.getPasswordHash()).isEqualTo("$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("User1", "user1", "user@gmail.com", "user");
    	repository.save(user);
    	assertThat(user).isNotNull();
    }
    @Test
    public void DeleteUser() {
    	User user = repository.findByUsername("user");
        repository.deleteById(user.getId());
        User deletedUser = repository.findByUsername("user");
    	 assertThat(deletedUser).isNull();
    }
    }


