package com.springsecurity.Repository;

import com.springsecurity.Entity.FileUpDownlode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUplodeDownlodeRepository extends CrudRepository<FileUpDownlode,Integer> {
}
