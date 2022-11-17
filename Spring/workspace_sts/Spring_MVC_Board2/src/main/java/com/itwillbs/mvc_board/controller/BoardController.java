package com.itwillbs.mvc_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.mvc_board.service.BoardService;
import com.itwillbs.mvc_board.vo.BoardVO;
import com.itwillbs.mvc_board.vo.PageInfo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 글쓰기 폼
	@RequestMapping(value = "/BoardWriteForm.bo", method = RequestMethod.GET)
	public String writeForm() {
		return "board/qna_board_write";
	}
	
	// 글쓰기 비즈니스 로직
	// => 게시물 작성 정보를 전달받아 저장하기 위해 BoardVO 타입 파라미터 필요
	// => 실패 시 이동하는 페이지에 메세지 전달을 위해 Model 타입 파라미터 필요
	@RequestMapping(value = "/BoardWritePro.bo", method = RequestMethod.POST)
	public String writePro(BoardVO board, Model model) {
		// BoardService 객체의 writeBoard() 메서드를 호출하여 글 쓰기 작업 요청
		// => 파라미터 : BoardVO 객체   리턴타입 : int(insertCount)
		int insertCount = service.writeBoard(board);
		
		System.out.println(insertCount);
		
		// 글쓰기 실패 시 "글 쓰기 실패!" 메세지를 담아 fail_back.jsp 페이지로 포워딩
		if(insertCount == 0) {
			model.addAttribute("msg", "글 쓰기 실패!");
			return "fail_back";
		}
		
		// 리다이렉트 방식 포워딩으로 BoardList.bo 서블릿 주소 요청
		return "redirect:/BoardList.bo";
	}
	
	
	// 글 목록 조회 비즈니스 로직
	// => 파라미터로 전달되는 pageNum 파라미터가 없을 경우를 대비하여 기본값 1 로 설정
	// => 검색 기능 추가 시 파라미터(searchType, keyword) 에 대한 기본값 "" 으로 설정 
	// => 글 목록을 저장하기 위해 Model 타입 파라미터 필요
	@RequestMapping(value = "/BoardList.bo", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "1") int pageNum, 
						@RequestParam(defaultValue = "") String searchType, 
						@RequestParam(defaultValue = "") String keyword, 
						Model model) {
		
		// 총 게시물 수 조회를 위해 BoardService 객체의 getBoardListCount() 메서드 호출
		// => 파라미터 : 검색타입(searchType), 검색어(keyword)   리턴타입 : int(listCount)
		// => 검색어의 경우 "%" 문자열 결합 필요
		int listCount = service.getBoardListCount(searchType, "%" + keyword + "%");
//		System.out.println(listCount);
		
		// 페이징 처리를 위한 변수 선언
		int listLimit = 10; // 한 페이지 당 표시할 게시물 수
		int pageLimit = 10; // 한 페이지 당 표시할 페이지 목록 수
		
		// 페이징 처리를 위한 계산 작업
		// 1. 현재 페이지에서 표시할 전체 페이지 수 계산
		int maxPage = (int)Math.ceil((double)listCount / listLimit);

		// 2. 현재 페이지에서 보여줄 시작 페이지 번호(1, 11, 21 등의 시작 번호) 계산
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;

		// 3. 현재 페이지에서 보여줄 끝 페이지 번호(10, 20, 30 등의 끝 번호) 계산
		int endPage = startPage + pageLimit - 1;

		// 4. 만약, 끝 페이지(endPage)가 현재 페이지에서 표시할 총 페이지 수(maxPage)보다 클 경우
		// 끝 페이지 번호를 총 페이지 수로 대체
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 5. 현재 페이지 번호를 활용하여 조회 시 시작행 번호 계산
		int startRow = (pageNum - 1) * listLimit;
		
		// 페이징 처리 정보를 PageInfo 객체에 저장
		PageInfo pageInfo = 
				new PageInfo(pageNum, maxPage, startPage, endPage, listCount, startRow, listLimit);
		
		// Service 객체의 getBoardList() 메서드를 호출하여 게시물 목록 조회
		// => 파라미터 : 검색타입(searchType), 검색어(keyword), 페이지정보(PageInfo 객체)
		//    리턴타입 : List<BoardVO>(boardList)
		// => 검색어의 경우 "%" 문자열 결합 필요
		List<BoardVO> boardList = service.getBoardList(searchType, "%" + keyword + "%", pageInfo);
		
		// Model 객체에 게시물 목록과 페이지정보 저장
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		return "board/qna_board_list";
	}
	
	// 글 상세정보 조회 비즈니스 로직
	@RequestMapping(value = "/BoardDetail.bo", method = RequestMethod.GET)
	public String detail(@RequestParam int board_num, Model model) {
		// Service 객체의 increaseReadcount() 메서드 호출하여 게시물 조회수 증가 작업 요청
		// => 파라미터 : 글번호(board_num)
		service.increaseReadcount(board_num);
		
		// Service 객체의 getBoardDetail() 메서드를 호출하여 게시물 상세 정보 조회 작업 요청
		// => 파라미터 : 글번호(board_num)   리턴타입 : BoardVO(board)
		BoardVO board = service.getBoardDetail(board_num);
		
		// Model 객체에 "board" 라는 이름으로 BoardVO 객체 저장
		model.addAttribute("board", board);

		// board/qna_board_view 페이지로 포워딩(Dispatcher)
		return "board/qna_board_view";
	}
	
	// 글 삭제 폼 요청
	@RequestMapping(value = "/BoardDeleteForm.bo", method = RequestMethod.GET)
	public String deleteForm() {
		return "board/qna_board_delete";
	}
	
	// 글 삭제 비즈니스 로직
	@RequestMapping(value = "/BoardDeletePro.bo", method = RequestMethod.POST)
	public String deletePro(
			BoardVO board, @RequestParam(defaultValue = "1") int pageNum, Model model) {
		// Service 객체의 removeBoard() 메서드 호출하여 글 삭제 작업 요청
		// => 파라미터 : BoardVO 객체(board)   리턴타입 : int(deleteCount)
		int deleteCount = service.removeBoard(board);
		
		// 삭제 실패 시 "패스워드 틀림!" 메세지 저장 후 fail_back.jsp 페이지로 포워딩
		if(deleteCount == 0) {
			model.addAttribute("msg", "패스워드 틀림!");
			return "fail_back";
		}
		
		// 리다이렉트 방식으로 글목록(BoardList.bo) 페이지 요청 => 파라미터 : 페이지번호
		return "redirect:/BoardList.bo?pageNum=" + pageNum;
	}
	
	// 글 수정 폼
	@RequestMapping(value = "/BoardModifyForm.bo", method = RequestMethod.GET)
	public String modifyForm(@RequestParam int board_num, Model model) {
		// 글 상세정보 조회 작업을 재사용하여 수정할 내용 가져오기
		// Service 객체의 getBoardDetail() 메서드를 호출하여 게시물 상세 정보 조회 작업 요청
		// => 파라미터 : 글번호(board_num)   리턴타입 : BoardVO(board)
		BoardVO board = service.getBoardDetail(board_num);
		
		// Model 객체에 "board" 라는 이름으로 BoardVO 객체 저장
		model.addAttribute("board", board);
		
		return "board/qna_board_modify";
	}
	
	// 글 수정 비즈니스 로직
	// => 파라미터 : BoardVO(board), 페이지번호(pageNum)
	@RequestMapping(value = "/BoardModifyPro.bo", method = RequestMethod.POST)
	public String modifyPro(
			BoardVO board, @RequestParam(defaultValue = "1") int pageNum, Model model) {
		// Service 객체의 modifyBoard() 메서드 호출하여 글 수정 작업 요청
		// => 파라미터 : BoardVO(board)   리턴타입 : int(updateCount)
		int updateCount = service.modifyBoard(board);
		
		// 수정 실패 시 "패스워드 틀림!" 메세지 저장 후 fail_back.jsp 페이지로 포워딩
		if(updateCount == 0) {
			model.addAttribute("msg", "패스워드 틀림!");
			return "fail_back";
		}
		
		// 글 상세정보 페이지(BoardDetail.bo)로 포워딩(Redirect)
		// => 파라미터로 글번호, 페이지번호 전달
//		return "redirect:/BoardDetail.bo?board_num=" + board.getBoard_num() + "&pageNum=" + pageNum;
		
		// Redirect 방식도 Model 객체를 통해 파라미터 전달 가능함
		model.addAttribute("board_num", board.getBoard_num());
		model.addAttribute("pageNum", pageNum);
		
		return "redirect:/BoardDetail.bo";
		
	}
	
	// 답글 작성 폼 - GET방식 replyForm()
	// => 파라미터 : 글번호, Model
	@RequestMapping(value = "/BoardReplyForm.bo", method = RequestMethod.GET)
	public String replyForm(@RequestParam int board_num, Model model) {
		// 글 상세정보 조회 작업을 재사용하여 수정할 내용 가져오기
		// Service 객체의 getBoardDetail() 메서드를 호출하여 게시물 상세 정보 조회 작업 요청
		// => 파라미터 : 글번호(board_num)   리턴타입 : BoardVO(board)
		BoardVO board = service.getBoardDetail(board_num);
		
		// Model 객체에 "board" 라는 이름으로 BoardVO 객체 저장
		model.addAttribute("board", board);
		
		return "board/qna_board_reply";
	}
	
	// 답글 작성 비즈니스 로직
	// => 파라미터 : BoardVO(board), 페이지번호(pageNum)
	@RequestMapping(value = "/BoardReplyPro.bo", method = RequestMethod.POST)
	public String replyPro(
			BoardVO board, @RequestParam(defaultValue = "1") int pageNum, Model model) {
		// Service 객체의 writeReplyBoard() 메서드 호출하여 답글 작성 작업 요청
		// => 파라미터 : BoardVO 객체   리턴타입 : int(insertCount)
		int insertCount = service.writeReplyBoard(board);
		
		// 글쓰기 실패 시 "답글 등록 실패!" 메세지 저장 후 fail_back.jsp 페이지로 포워딩
		if(insertCount == 0) {
			model.addAttribute("msg", "답글 등록 실패!");
			return "fail_back";
		}
		
		// 글 목록 페이지(BoardList.bo)로 포워딩(Redirect)
		// => 파라미터로 페이지번호 전달
		model.addAttribute("pageNum", pageNum);
		
		return "redirect:/BoardList.bo";
	}
	
	
}














