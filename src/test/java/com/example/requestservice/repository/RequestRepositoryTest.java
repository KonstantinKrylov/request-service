package com.example.requestservice.repository;

import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository repository;

    @Before
    public void setUp() throws Exception {
        deleteAll();
    }

    @Test
    public void getFromRepository() throws Exception {
        SomeRequestEntry someRequest = new SomeRequestEntry("test", 1);
        AnotherRequestEntry anotherRequest = new AnotherRequestEntry("Test", 2);

        repository.save(someRequest).block();
        repository.save(anotherRequest).block();

        RequestEntry someRequestResponse = repository.findById(someRequest.getId()).block();
        RequestEntry anotherRequestResponse = repository.findById(anotherRequest.getId()).block();

        assertThat(someRequestResponse, instanceOf(SomeRequestEntry.class));
        assertThat(anotherRequestResponse, instanceOf(AnotherRequestEntry.class));
    }

    @After
    public void tearDown() throws Exception {
        deleteAll();
    }

    private void deleteAll(){
        repository.deleteAll();
    }
}
