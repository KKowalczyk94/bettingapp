package com.example.demo.services;

import com.example.demo.Entities.ActionItem;
import com.example.demo.Entities.Bet;
import com.example.demo.Entities.user.User;
import com.example.demo.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public User updateUser(UUID id, User user) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setBets(user.getBets());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public User createRandomUser() {
        Faker faker = new Faker();
        // Generate random User
        User user = new User();
        user.setUsername(faker.name().username());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());

        // Generate random Bets
        List<Bet> bets = new ArrayList<>();
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            Bet bet = new Bet();
            bet.setDescription(faker.lorem().sentence());

            // Generate random ActionItems for each Bet
            List<ActionItem> actionItems = new ArrayList<>();
            for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
                ActionItem actionItem = new ActionItem();
                actionItem.setName(faker.commerce().productName());
                actionItem.setPrice(faker.number().randomDouble(2, 10, 100));
                actionItem.setQuantity(faker.number().numberBetween(1, 10));
                actionItems.add(actionItem);
            }

            bet.setActionItems(actionItems);
            bets.add(bet);
        }

        user.setBets(bets);

        // Save the user to the repository
        return userRepository.save(user);
    }


}
