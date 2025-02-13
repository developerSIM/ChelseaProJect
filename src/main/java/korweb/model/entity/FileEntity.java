package korweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
@Entity // 엔티티
@Table( name = "file") // 테이블명
public class FileEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int fno; // 1. 첨부파일번호(pk)

    @Column( nullable = false , columnDefinition = "varchar(255)" )
    private String fname;   // 2. 첨부파일명

    // 3. 첨부파일이 위치할 게시물번호 : 게시물번호(FK) : 단방향
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "bno")
    private BoardEntity boardEntity;

}
