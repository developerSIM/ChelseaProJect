package korweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
@Entity // 엔티티
@Table( name = "category") // 테이블명
public class CategoryEntity extends BaseTime  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int cno; // 1. 카테고리번호

    @Column( nullable = false , columnDefinition = "varchar(50)" )
    private String cname; // 2. 카테고리명

}
