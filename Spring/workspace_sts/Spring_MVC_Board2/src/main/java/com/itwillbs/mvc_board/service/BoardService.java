package com.itwillbs.mvc_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.mvc_board.mapper.BoardMapper;
import com.itwillbs.mvc_board.vo.BoardVO;
import com.itwillbs.mvc_board.vo.PageInfo;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	// 글 쓰기 작업 요청
	// => 파라미터 : BoardVO 객체   리턴타입 : int(insertCount)
	public int writeBoard(BoardVO board) {
		// 기존 게시물들의 가장 큰 번호 조회하여 새 글 번호로 설정
		// => 주의! MAX() 함수 사용 시 NULL 값 조회도 발생하므로 int 가 아닌 Integer 타입 필요
		Integer num = mapper.selectMaxBoardNum();
//		System.out.println(num);
		
		// 조회된 게시물 번호가 없을 경우 기본값 1 설정
		// 아니면, 새 글 번호는 조회된 번호 + 1 값 설정
		if(num == null) {
			board.setBoard_num(1);
		} else {
			board.setBoard_num(num + 1);
		}
		
		// 업로드 생략했으므로 파일명은 기본값 널스트링으로 설정
		// => 참조 타입의 기본값은 null 이나, DB 테이블에 NOT NULL 제약조건 때문에 널스트링으로 변경
		board.setBoard_file("");
		board.setBoard_real_file("");
		
		// 참조글번호(board_re_ref)는 새 글 이므로 새 글 번호와 동일하게 설정
		board.setBoard_re_ref(board.getBoard_num());
		
		return mapper.insertBoard(board);
	}

	// 글 목록 갯수 조회 작업 요청
	// => 파라미터 : 검색타입(searchType), 검색어(keyword)   리턴타입 : int(listCount)
	public int getBoardListCount(String searchType, String keyword) {
		return mapper.selectBoardListCount(searchType, keyword);
	}

	// 게시물 목록 조회 작업 요청
	// => 파라미터 : 검색타입(searchType), 검색어(keyword), 페이지정보(PageInfo 객체)
	//    리턴타입 : List<BoardVO>(boardList)
	public List<BoardVO> getBoardList(String searchType, String keyword, PageInfo pageInfo) {
		return mapper.selectBoardList(searchType, keyword, pageInfo);
	}

	// 조회수 증가 작업 요청
	// => 파라미터 : 글번호
	public void increaseReadcount(int board_num) {
		mapper.updateReadcount(board_num);
	}

	// 게시물 상세정보 조회 작업 요청
	// => 파라미터 : 글번호   리턴타입 : BoardVO
	public BoardVO getBoardDetail(int board_num) {
		return mapper.selectBoardDetail(board_num);
	}

	// 글 삭제 작업 요청
	// => 파라미터 : BoardVO 객체(board)   리턴타입 : int(deleteCount)
	public int removeBoard(BoardVO board) {
		return mapper.deleteBoard(board);
	}

	// 글 수정 작업 요청
	// => 파라미터 : BoardVO(board)   리턴타입 : int(updateCount)
	public int modifyBoard(BoardVO board) {
		return mapper.updateBoard(board);
	}

	// 답글 작성 작업 요청
	// => 파라미터 : BoardVO(board), 페이지번호(pageNum)
	public int writeReplyBoard(BoardVO board) {
		// 기존 원본글에 대한 답글들이 존재할 경우 순서번호(board_re_seq) 조정을 위해
		// Mapper 객체의 updateBoardReSeq() 메서드 호출
		// => 파라미터 : BoardVO(board)   리턴타입 : 없음
		mapper.updateBoardReSeq(board);
		// --------------------------------------------------------------------------
		// 기존 게시물들의 가장 큰 번호 조회하여 새 글 번호로 설정
		// => 주의! MAX() 함수 사용 시 NULL 값 조회도 발생하므로 int 가 아닌 Integer 타입 필요
		Integer num = mapper.selectMaxBoardNum();
		
		// 조회된 게시물 번호가 없을 경우 기본값 1 설정
		// 아니면, 새 글 번호는 조회된 번호 + 1 값 설정
		if(num == null) {
			board.setBoard_num(1);
		} else {
			board.setBoard_num(num + 1);
		}
		// --------------------------------------------------------------------------
		// 업로드 생략했으므로 파일명은 기본값 널스트링으로 설정
		// => 참조 타입의 기본값은 null 이나, DB 테이블에 NOT NULL 제약조건 때문에 널스트링으로 변경
		board.setBoard_file("");
		board.setBoard_real_file("");
		// --------------------------------------------------------------------------
		// 주의해야할 부분(답글 관련 번호 처리)
		// 답글에 사용될 참조글 번호(board_re_ref)는 원본글의 참조글번호와 동일(그대로 사용)
		// 들여쓰기레벨(board_re_lev)과 순서번호(board_re_seq)는 원본글의 각 번호 + 1
//		board.setBoard_re_ref(board.getBoard_re_ref()); // 값을 그대로 사용하므로 불필요
		board.setBoard_re_lev(board.getBoard_re_lev() + 1);
		board.setBoard_re_seq(board.getBoard_re_seq() + 1);
		// --------------------------------------------------------------------------
		// 실제 답글 쓰기 비즈니스 로직은 기존의 글쓰기 비즈니스 로직 재사용
		return mapper.insertBoard(board);
	}
	
}


















