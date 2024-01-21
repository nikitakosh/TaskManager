package com.nikitakosh.TaskManager.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {
    private static final String EMAIL_REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    @Override
    public boolean test(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}