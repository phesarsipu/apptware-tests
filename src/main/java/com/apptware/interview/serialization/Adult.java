package com.apptware.interview.serialization;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
public class Adult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private Integer age;

    /**
     * This class has a constructor validation that restricts illegal Adult instances which doesn't
     * work during deserialization. Modify the code in this file so that we can also restrict illegal
     * Adult instances during deserialization.
     */
    public Adult(String firstName, String lastName, Integer age) {
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }

        if (Objects.isNull(age) || age < 18) {
            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isBlank(firstName)) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (Objects.isNull(age) || age < 18) {
            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
        }
        this.age = age;
    }
}

