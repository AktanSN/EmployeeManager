package com.aktansanhal.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aktansanhal.springboot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
