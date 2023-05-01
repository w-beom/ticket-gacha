package kr.co.ticketgacha.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long memberId;
    @Column
    private String id;
    @Column
    private String pw;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private boolean admin;
    @Column
    private boolean banned;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Member(String id, String pw, String name, String email, String phone, boolean admin, boolean banned) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.banned = banned;
    }
}
