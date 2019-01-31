package com.six.million.dao;

import com.six.million.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordMapper {
    int insert(Record record);

    int insertSelective(Record record);

    void insertForeach(@Param("arr") Record[] arr);
}