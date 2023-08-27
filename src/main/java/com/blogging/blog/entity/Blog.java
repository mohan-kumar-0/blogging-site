package com.blogging.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    private String blogId;
    @Column(nullable = false)
    private String content;
    @Column
    private String image;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    private User user;
}
