package com.vitsen.short_url.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class URL {
    private String fullUrl;
    private String shortUrl;
}
