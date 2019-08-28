package com.epam.training.service;

import com.epam.training.entity.Client;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientServiceTest {

    @Test
    public void testAddClient() {
        List<Client> expectedClientList = new ArrayList<>();
        Client client1 = new Client("Fred", 0.0);
        Client client2 = new Client("Mike", 0.0);
        Client client3 = new Client("Joji", 0.0);

        expectedClientList.add(client1);
        expectedClientList.add(client2);
        expectedClientList.add(client3);


        List<Client> actualClientList = new ArrayList<>();


        actualClientList.add(client1);
        actualClientList.add(client2);

        ClientService clientService = new ClientService();

        assertEquals(expectedClientList, actualClientList);
    }

}