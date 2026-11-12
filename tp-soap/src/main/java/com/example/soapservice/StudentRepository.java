package com.example.soapservice;

import com.example.soapservice.generated.Student;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {
        add("Ahmed", 5, "Dachraoui");
        add("Iheb", 5, "Haddad");
        add("Dorra", 6, "Haddad");
        add("Mohamed", 7, "Beji");
    }

    private void add(String name, int standard, String address) {
        Student s = new Student();
        s.setName(name);
        s.setStandard(standard);
        s.setAddress(address);
        students.put(name, s);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}