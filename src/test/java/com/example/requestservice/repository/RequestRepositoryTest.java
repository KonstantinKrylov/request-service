package com.example.requestservice.repository;

import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository repository;

    @Test
    public void name() throws Exception {
        SomeRequestEntry entry = new SomeRequestEntry("test", 1);
        AnotherRequestEntry test = new AnotherRequestEntry("Test", 2);

        SomeRequestEntry block = repository.save(entry).block();
        AnotherRequestEntry block1 = repository.save(test).block();
        System.out.println("block = " + block);
        System.out.println("block1 = " + block1);

        repository.count().subscribe(aLong -> System.out.println("aLong = " + aLong));
        RequestEntry block2 = repository.findById(block.getId()).block();
        System.out.println("block2 = " + block2);

    }
}
