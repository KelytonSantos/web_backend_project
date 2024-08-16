package com.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.entities.Order;
import com.project.entities.User;
import com.project.repositories.OrderRepository;
import com.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@santos.com", "99991929", "1234567");
        User u2 = new User(null, "Kelyton", "Kelyton@santos.com", "996269220", "123546");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2024-08-16T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2024-08-20T15:22:14Z"), u2);
        Order o3 = new Order(null, Instant.parse("2024-08-27T09:04:37Z"), u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
