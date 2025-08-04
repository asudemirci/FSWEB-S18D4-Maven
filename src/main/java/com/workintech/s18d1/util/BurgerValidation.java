package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
public static void checkName(String name) {
    if (name == null || name.isEmpty()) {
        throw new BurgerException("Burger name cannot be null or empty", HttpStatus.BAD_REQUEST);
    }

    // İsim sadece harf ve boşluk içerebilir
    if (!name.matches("[a-zA-Z ]+")) {
        throw new BurgerException("Burger name can only contain letters and spaces", HttpStatus.BAD_REQUEST);
    }

    // İsim en az 3 karakter olmalı
    if (name.length() < 3) {
        throw new BurgerException("Burger name must be at least 3 characters", HttpStatus.BAD_REQUEST);
    }
}

public static void checkPrice(Double price) {
    if (price == null || price <= 0) {
        throw new BurgerException("Price must be greater than 0", HttpStatus.BAD_REQUEST);
    }
}

public static void checkContents(String contents) {
    if (contents == null || contents.isEmpty()) {
        throw new BurgerException("Contents cannot be null or empty", HttpStatus.BAD_REQUEST);
    }
}

public static void validateBurger(Burger burger) {
    checkName(burger.getName());
    checkPrice(burger.getPrice());
    checkContents(burger.getContents());
}

}