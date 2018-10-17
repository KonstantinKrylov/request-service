package com.example.requestservice.listener;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.repository.RequestRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RequestListenerTest {

    @Autowired
    private RequestListener requestListener;

    @Autowired
    private RequestRepository repository;

    @Before
    public void setUp() throws Exception {
        deleteAll();
    }

    @Test
    public void listen() throws Exception {
        AnotherRequestDto dto = new AnotherRequestDto(UUID.randomUUID().toString(), "test", 1);

        requestListener.listen(dto);

        RequestEntry entry = repository.findById(dto.getId()).retry(10).block();
        assertThat(entry, instanceOf(AnotherRequestEntry.class));

        AnotherRequestEntry another = (AnotherRequestEntry) entry;
        assertEquals(another.getId(), dto.getId());
        assertEquals(another.getAnotherStringField(), dto.getAnotherStringField());
        assertEquals(another.getAnotherIntegerField(), dto.getAnotherIntegerField());
    }

    @After
    public void tearDown() throws Exception {
        deleteAll();
    }

    private void deleteAll(){
        repository.deleteAll().block();
    }

}