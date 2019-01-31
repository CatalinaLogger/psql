package com.six.million.service.impl;

import com.six.million.service.IRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class RecordServiceImplTest {

    @Autowired
    private IRecordService recordService;

    @Test
    public void insert() {
        int size = 8;
        while (size > 0) {
            recordService.insert();
            size--;
        }
    }
}