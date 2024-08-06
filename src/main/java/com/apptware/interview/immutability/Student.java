/**
 * This class is expected to be immutable. Please make necessary changes.
 */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public final class Student {
    private final String name;
    private final Date dateOfBirth;
    private final List<String> courses;

    public Student(String name, Date dateOfBirth, List<String> courses) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.dateOfBirth = new Date(Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null").getTime());
        this.courses = List.copyOf(Objects.requireNonNull(courses, "courses must not be null"));
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', dateOfBirth=" + dateOfBirth + ", courses=" + courses + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && dateOfBirth.equals(student.dateOfBirth) && courses.equals(student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, courses);
    }
}


