package korweb.controller;

import korweb.model.dto.BoardDto;
import korweb.model.dto.PageDto;
import korweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BoardController {

    @Autowired private BoardService boardService; //-- Board 서비스 객체 주입

    // [1] 게시물 쓰기
    @PostMapping("/board/write.do") // { "btitle": "qwe" , "bcontent" : "qwe" , "cno" : "1"  }
    public boolean boardWrite(@RequestBody BoardDto boardDto ){
        return boardService.boardWrite( boardDto);
    }

    // [2] 카테고리별 게시물 전체 조회 + 페이징처리( vs 무한스크롤 )
    // http://localhost:8080/board/findall.do?cno=1&page=1 : 1번 (뉴스)카테고리 의 1페이지 조회
    // http://localhost:8080/board/findall.do?cno=1&page=3 : 1번 (뉴스)카테고리 의 3페이지 조회
    // http://localhost:8080/board/findall.do?cno=3&page=2 : 1번 (FAQ)카테고리 의 2페이지 조회
    @GetMapping("/board/findall.do")
    public PageDto boardFindAll(@RequestParam int cno , @RequestParam int page ){ // 조회할 카테고리번호 , 페이지 번호
        return boardService.boardFindAll( cno , page );
    }

    // [3] 게시물 특정(개별) 조회
    @GetMapping("/board/find.do")
    public BoardDto boardFind( @RequestParam int bno ){
        return boardService.boardFind( bno );
    }
    // [4] 게시물 특정(개별) 수정
    @PutMapping("/board/update.do") // { "bno": "1" , "btitle" : "qwe" , "bcontent" : "qwe" }
    public boolean boardUpdate( @RequestBody BoardDto boardDto ){
        return boardService.boardUpdate( boardDto );
    }
    // [5] 게시물 특정(개별) 삭제
    @DeleteMapping("/board/delete.do")
    public boolean boardDelete( @RequestParam int bno ){
        return boardService.boardDelete( bno );
    }

    // =============================== 댓글 ============================= //
    // [6] 댓글 쓰기
    @PostMapping("/reply/write.do")
    public boolean replyWrite( @RequestBody Map< String , String > replyDto ) { // * DTO 클래스 대신에 map 컬렉션 활용
        return boardService.replyWrite( replyDto );
    }

    // [7] 특정 게시물의 댓글 전체 조회
    @GetMapping("/reply/findall.do")
    public List< Map<String,String> > replyFindAll( @RequestParam int bno ){
        return boardService.replyFindAll( bno );
    }

} // class end