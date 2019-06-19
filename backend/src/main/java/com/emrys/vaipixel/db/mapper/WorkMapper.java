package com.emrys.vaipixel.db.mapper;

import com.emrys.vaipixel.db.model.Work;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface WorkMapper {
    @Insert("INSERT INTO works()")
    void insert(Work work);

    @Select("SELECT * FROM works")
    void getAll();
}
