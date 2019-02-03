package by.subota.max.util;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;

/**
 * Cookie finder
 */
public final class CookieFinder {
    private CookieFinder() {}

    public static Optional<String> getValueByName(String cookieName, Cookie[] cookies) {

        if (cookieName == null || cookies == null) {
            return Optional.empty();
        }

        return Arrays.stream(cookies)
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .map(Cookie::getName)
                .findFirst();
    }
}
