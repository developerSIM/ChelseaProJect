package korweb.model.entity;

import jakarta.persistence.*;
import korweb.model.dto.BoardDto;
import lombok.*;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
@Entity // 엔티티
@Table( name = "board") // 테이블명
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int bno; // 1. 게시물번호 (PK)

    @Column( nullable = false , columnDefinition = "varchar(255)" )
    private String btitle;  // 2. 게시물제목

    @Column( columnDefinition = "longtext" )
    private String bcontent; // 3. 게시물내용

    // 4. 게시물조회수
    @Column
    private int bview;

    // 5. 작성자번호(FK) : 단방향
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "mno")
    private MemberEntity memberEntity;

    // 6. 카테고리번호(FK)  : 단방향
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "cno")
    private CategoryEntity categoryEntity;

    // + entity --> Dto 변환 메소드
    // 데이터베이스에 저장된 entity 를 조회한 후 dto로 변환해야 하므로 필요하다.
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bcontent( this.bcontent )
                .bview( this.bview )
                .mno( this.memberEntity.getMno() )
                .cno( this.categoryEntity.getCno() )
                .mid( this.memberEntity.getMid() )
                .cname( this.categoryEntity.getCname() )
                .cdate( this.getCdate().toString() )
                .build();
    }

}












