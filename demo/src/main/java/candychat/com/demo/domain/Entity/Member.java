package candychat.com.demo.domain.Entity;

import candychat.com.demo.domain.common.BaseEntity;
import candychat.com.demo.domain.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;    //사용자 고유 ID

        @Column(nullable = false, length = 10)
        private String name;    //사용자 이름, 이름 10자 제한

        @Column(nullable = false, length = 50)
        private String email;

        @Column(nullable = false, length = 225)
        private String password;    //비밀번호

        @Column(name = "profile_photo")
        private String profilePhoto;    //사용자 프로필 사진 URL

        @Column(nullable = false, length = 10)
        private String nickName;        //사용자 닉네임

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @Enumerated(EnumType.STRING)
        private SocialType socialType;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "coupld_id", nullable = false)
        private Couple couple;

}
