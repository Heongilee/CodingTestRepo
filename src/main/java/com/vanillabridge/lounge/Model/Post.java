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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postTitle;
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person postAuthor;

    private String ImageUrl;

    @ManyToMany(mappedBy = "personApplies")
    private List<Person> postApplies;
}