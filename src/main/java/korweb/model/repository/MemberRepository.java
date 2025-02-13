package korweb.model.repository;

import korweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity , Integer> {
    /*
    // 인터페이스는 추상메소드를 가질 수 있는 타입 이다.
    // DAO 특정 값 조회 : select * from 테이블명 where 필드명 = ?
    // JPA 특정 값 조회 : 반환엔티티 findBy필드명( 타입 매개변수명 )
        // 1. 필드명을 이용한 엔티티 검색 : 반환엔티티 findBy필드명( 타입 매개변수명 );
        // 2. 필드명을 이용한 엔티티 존재여부 : boolean existsBy필드명( 타입 매개변수명 );
        * 2개 이상의 밀드명을 넣을경우 카멜표기법
            -> 첫글자를 소문자로 시작하고 다음 단어의 첫문자만 대문자
            예] mycar -> myCar , studentscorelist -> studentScoreList
    예1 ] 아이디 중복 검사
        DAO : select * from member where mid = ?
        JPA : boolean existsByMid( String mid )
    예2 ] 로그인 , 아이디와 비밀번호 일치 여부 검사
        DAO : select * from member where mid = ? and mpwd = ?
        JPA : boolean existsByMidAndMpwd( String mid , String mpwd )
    예3 ] 아이디 또는 이메일이 중복 일치 여부 검사
        DAO : select * from member where mid = ? or memail = ?
        JPA : boolean existsByMidOrMemail( String mid , String memail )
    예4] 아이디로 엔티티 검색
        DAO : select * from member where mid = ?
        JPA : MemberEntity findByMid( String mid );
    */

    // [1] 로그인 추상메소드 : existsBy필드명And필드명
        // DAO : select * from member where mid = ? and mpwd = ?
    boolean existsByMidAndMpwd( String mid , String mpwd );

    // [2] 아이디로 엔티티 조회 : findBy필드명
        // DAO : select * from member where mid = ?
    MemberEntity findByMid( String mid );

} // i end























