package com.six.million.service.impl;

import com.six.million.dao.RecordMapper;
import com.six.million.domain.Record;
import com.six.million.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    @Async("asyncExecutor")
    public void insert() {
        Random random = new Random();
        int size = 0;
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        while (size < 125000) {
            calendar.add(calendar.MINUTE, 1);//把日期往后增加n天.正数往后推,负数往前移动
            Record[] arr = new Record[100];
            for (int i = 0; i < 100; i++) {
                Record record = new Record();
                record.setTime(calendar.getTime());
                record.setDeviceId(random.nextInt(1000));
                record.setVal0(random.nextDouble());
                record.setVal1(random.nextDouble());
                record.setVal2(random.nextDouble());
                record.setVal3(random.nextDouble());
                record.setVal4(random.nextDouble());
                record.setVal5(random.nextDouble());
                record.setVal6(random.nextDouble());
                record.setVal7(random.nextDouble());
                record.setVal8(random.nextDouble());
                record.setVal9(random.nextDouble());
                arr[i] = record;
            }
            recordMapper.insertForeach(arr);
            size++;
        }
    }
}
