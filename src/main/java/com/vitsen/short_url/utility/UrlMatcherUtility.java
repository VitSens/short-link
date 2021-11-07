package com.vitsen.short_url.utility;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class UrlMatcherUtility {
    public boolean checkUrlMatch(String fullUrl) {
        return Pattern.matches("\"(http|https)://[\\w\\W]+\\.(com|ru|org)(|/)\"", fullUrl);
    }
}
