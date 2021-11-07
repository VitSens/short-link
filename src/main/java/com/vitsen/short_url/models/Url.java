package com.vitsen.short_url.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "short_url")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_url")
    @NonNull private String fullUrl;

    @Column(name = "short_url")
    @NonNull private String shortUrl;
}
