package com.example.demo;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Contact {
    @NonNull
    @Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,10}$")
    private String name;
    @NonNull
    @Pattern(message="check email" , regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\\]?)$")
    private String email;
    private String subject;
    @NonNull
    private String message;

    public Contact(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, subject);
    }
}
