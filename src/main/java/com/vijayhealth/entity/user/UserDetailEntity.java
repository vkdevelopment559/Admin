package com.vijayhealth.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_detail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "res_id")
    private Long resId;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mediaPath")
    private String mediaPath;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "res_published_at")
    private LocalDateTime resPublishedAt;

    @Column(name = "res_updated_at")
    private LocalDateTime resUpdatedAt;

    @Column(name = "res_deleted_at")
    private LocalDateTime resDeletedAt;

    @Column(name = "res_deleted")
    private Boolean resDeleted;

}
