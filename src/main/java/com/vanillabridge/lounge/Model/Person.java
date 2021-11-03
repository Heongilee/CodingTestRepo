package com.vanillabridge.lounge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Enumerated(EnumType.STRING)
    private Gender personGender;
    @Enumerated(EnumType.STRING)
    private Region personRegion;
    private Integer personAge;
    @Builder.Default
    private Integer personPointAmount = 0;

    @OneToMany(mappedBy = "postAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> personPosts;

    @ManyToMany
    @JoinTable(
            name = "post_person",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> personApplies;

}


