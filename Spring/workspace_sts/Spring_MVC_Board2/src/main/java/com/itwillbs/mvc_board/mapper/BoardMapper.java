package com.itwillbs.mvc_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.mvc_board.vo.BoardVO;
import com.itwillbs.mvc_board.vo.PageInfo;

public interface BoardMapper {

	// 1. 게시물 중 가장 큰 번호 조회
	public Integer selectMaxBoardNum();

	// 2. 글 쓰기
	public int insertBoard(BoardVO board);

	// 3. 글 목록 갯수 조회
	// => Mapper.xml 파일 내에서 조건문 등을 사용하여 파라미터로 데이터 사용 시
	//    파라미터가 복수개일 경우 @Param 어노테이션을 통해 파라미터로 사용할 이름을 지정
	public int selectBoardListCount(
			@Param("searchType") String searchType, @Param("keyword") String keyword);

	// 4. 글 목록 조회
	public List<BoardVO> selectBoardList(@Param("searchType") String searchType, 
			@Param("keyword") String keyword, @Param("pageInfo") PageInfo pageInfo);

	// 5. 글 조회수 증가
	public void updateReadcount(int board_num);

	// 6. 글 상세정보 조회
	public BoardVO selectBoardDetail(int board_num);

	// 7. 글 삭제
	public int deleteBoard(BoardVO board);

	// 8. 글 수정
	public int updateBoard(BoardVO board);

	// 9. 기존 답글 순서번호 조정
	public void updateBoardReSeq(BoardVO board);

}























