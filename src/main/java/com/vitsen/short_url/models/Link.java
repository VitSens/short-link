package com.vitsen.short_url.models;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(name = "short_url")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_url")
    @URL
    @NonNull
    private String fullUrl;

    @Column(name = "short_url")
    @NonNull
    private String shortUrl;
}
