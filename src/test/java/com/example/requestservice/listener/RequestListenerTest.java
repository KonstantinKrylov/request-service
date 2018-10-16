package com.example.requestservice.listener;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RequestListenerTest {

    @Autowired
    private RequestListener requestListener;

    @Test
    public void listen() throws Exception {
        AnotherRequestDto dto = new AnotherRequestDto("test", 1);
        requestListener.listen(dto);
    }

}