package edu.gsu.eventplanner.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", columnDefinition = "VARCHAR(50) COMMENT 'name' ")
    private String username;


    @Column(name="nickname", columnDefinition = "VARCHAR(50) COMMENT 'nickname' ")
    private String nickname;

    @Column(name="password", columnDefinition = "VARCHAR(30) COMMENT 'password' ")
    private String password;

    @Column(name="email", columnDefinition = "VARCHAR(50) COMMENT 'email' ")
    private String email;

    @Column(name="contact_number", columnDefinition = "VARCHAR(20) COMMENT 'contact number' ")
    private String contactNumber;

    @Column(name="bio", columnDefinition = "VARCHAR(255) COMMENT 'bio' ")
    private String bio;

    @Column(name="created_at", columnDefinition = "DATETIME(6) COMMENT 'created At' ")
    private LocalDateTime createdAt;

    @Column(name="updated_at", columnDefinition = "DATETIME(6) COMMENT 'updated At' ")
    private LocalDateTime updatedAt;

    @Column(name="last_login_at", columnDefinition = "DATETIME(6) COMMENT 'last login at' ")
    private LocalDateTime lastLoginAt;

    @Column(name="accessToken", columnDefinition = "VARCHAR(255) COMMENT 'accessToken' ")
    private String accessToken;

    public static Member signup(String username,
                                String nickname,
                                String password,
                                String email,
                                String contactNumber,
                                String bio
    ){
        Member member = new Member();
        member.username = username;
        member.nickname=nickname;
        member.password=password;
        member.email=email;
        member.contactNumber=contactNumber;
        member.bio=bio;
        member.createdAt = LocalDateTime.now();

        return member;
    }

    //command handler pattern
    public void login(){
        String accessToken = UUID.randomUUID().toString();
        this.accessToken = accessToken;
        this.lastLoginAt = LocalDateTime.now();
    }

    public boolean isValidPassword(String inputPassword){
        return Objects.equals(this.password, inputPassword);
    }

    public void logout(){
        this.accessToken = null;
    }

    public Member updateMemberDetail(String inputNickname, String  inputContactNumber, String inputBio){
        this.nickname = inputNickname;
        this.contactNumber = inputContactNumber;
        this.bio= inputBio;
        this.updatedAt =LocalDateTime.now();
        return this;
    }


}
