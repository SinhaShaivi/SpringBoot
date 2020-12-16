package com.cg.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.ems.bean.*;
@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer>
{
@Query("from Employee order by name")
List<Employee> giveSortedOrder();

@Query("from Employee where name=:ename order by id desc")
List<Employee> updateNameWithId(@Param("ename") String name);
}
