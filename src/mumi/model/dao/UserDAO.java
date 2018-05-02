package mumi.model.dao;

public interface UserDAO{
	
	//전역변수에 MemberDTO를 저장한다.
	//저장된 MemberDTO에서 memberID, addr, phone등을 가져와 사용한다.
	
	/**
	 * 로그인
	 * @param memberid
	 * @param pwd
	 * @return 인트로 리턴 or 불리으로 리
	 */
	public int loginFunction(String memberid, String pwd);
	
	/**
	 * 회원가입
	 * @param memberid
	 * @param pwd
	 * @param name
	 * @param phone
	 * @param addr
	 * @param memberDTO 위의 값들을 받는 생성자 생성필요.
	 * @return int값으로 리턴, 0이면 true, 1이면 false
	 */
	public int registerMember(MemberDTO memberDTO); 
	
	/**
	 * 회원정보 수정 메소드 
	 * @param memberDTO
	 * @return
	 */
	public int userInfoUpdate(MemberDTO memberDTO);
	
	/**
	 * 회원탈퇴 
	 * @return
	 */
	public int userLeave();
	
	/**
	 * 전체상품조회 
	 * @return 전체리스트 조회 
	 */
	public List<ProductDTO> goodsRead();
	
	/**
	 * 상세상품조회 
	 * @param pCode 
	 * @return
	 */
	public ProductDTO goodsDetailRead(String pCode);
	
	/**
	 * 가격별 정렬 	
	 * @return 정렬된 리스트리턴
	 */
	public List<ProductDTO> goodsSortByPrice();
	
	/**
	 * 인기순정렬 
	 * @return 리스트리턴 
	 */
	public List<ProductDTO> goodsSortByPopularity();
	
	/**
	 * 최신상품순 
	 * @return 리스트리턴 
	 */
	public List<ProductDTO> goodsSortByNew();
	
	/**
	 * 장바구니전체조회 
	 * @return 리스트로 전체 리턴 
	 * memberID는 전역변수에 저장되어 있는 값을 가져온다.
	 */
	public List<OrderDTO> cartShowAll();
	
	/**
	 * 장바구니추가 
	 * @param pCode 상품코드 
	 * @param pSize 상품사이즈 
	 * @param pEA 상품개수 
	 * @param productDTO pCode, pSize, pEA를 받는다.
	 * @param 위 값들 중에 pCode만 받아와서 해당하는 코드를 order테이블에 넣는다. 
	 * @return 추가되었다(1)/안되었다(0)
	 */
	public int cartInsert(String pCode);
	
	/**
	 * 장바구니수정 
	 * @param oIndexNo 주문인덱스넘버 
	 * @param oEA 주문개수 
	 * @param orderDTO에 들어올 값들을 인수로 받아온다. 
	 * @return 수정됬다/안됬다.
	 */
	public int cartUpdate(OrderDTO orderDTO);
	
	/**
	 * 장바구니수정용 정보조회메소드.
	 * @param oIndexNo
	 * @return
	 */
	public OrderDTO cartDetailForUpdate(String oIndexNo);
	
	/**
	 * 장바구니삭제 
	 * @param oIndexNo
	 * @return 삭제되었다/안되었다.
	 */
	public int cartDelete(String oIndexNo);

	/**
	 * 소비자의 상세정보 가져오기(주문결제용) 
	 * @return
	 * MemberDTO를 전역변수에 저장하고 or 해당하는값들을 불러와서 OrderDTO에 넣어서 리턴? 
	 * 해당하는 값들을 불러와서 주소,번호에 저장.
	 */
	public OrderDTO userOrderContactInfo();
	
	/**
	 * 결제완료메소드 
	 * @param oIndexNo 해당하는 값들의 o_status를 업데이트해준다. 
	 * @return 결제완료성공/실패.
	 */
	public int userOrderComplete(String oIndexNo);
	
	/**
	 * 전체공지조회 
	 * @return
	 */
	public List<NoticeDTO> noticeRead();
	
	/**
	 * 상세공지조회 
	 * @param nIndexNo
	 * @return
	 */
	public NoticeDTO noticeDetailRead(String nIndexNo);
	
	/**
	 * 주문한(o_status값이 0인 자료들)내역 조회 
	 * @return
	 */
	public List<OrderDTO> orderListRead();
	
	/**
	 * QA조회메소드 
	 * @return 리스트로 리턴해준다.
	 * 전역변수에 저장되어있는 MemberID를 불러와서 조회한다.
	 */
	public List<QADTO> userQARead();
	
	/**
	 * Q&A게시판 등록 메소드 
	 * @param qADTO
	 * @return
	 * 
	 */
	public int userQAInsert(QADTO qADTO);
	
	/**
	 * Q&A게시판 수정 메소드 
	 * @param qADTO
	 * @return 수정되었다/안되었다.
	 */
	public int userQAUpdate(QADTO qADTO);
	
	/**
	 * 게시판수정용정보가져오기 
	 * @param qIndexNo
	 * @return 정보뿌려주기.
	 */
	public QADTO userQAReadForUpdate(String qIndexNo);
	
	/**
	 * Q&A게시판 삭제 메소드 
	 * @param qADTO
	 * @return 삭제되었다/됬다.
	 * 
	 */
	public int userQADelete(String bIndexNo);
	
	/**
	 * 리뷰조회메소드 
	 * @param pCode 상품코드 가져와서 해당하는 값의 리뷰들을 뿌려준다. 
	 * @return
	 */
	public List<ReviewDTO> userReviewRead(String pCode);
	
	/**
	 * 리뷰삽입메소드 
	 * @param reviewDTO 
	 * @return
	 */
	public int userReviewInsert(ReviewDTO reviewDTO);
	
	/**
	 * 리뷰업데이트 메소드 
	 * @param reviewDTO
	 * @return
	 */
	public int userReviewUpdate(ReviewDTO reviewDTO);
	
	/**
	 * 리뷰업데이트용 정보 가져오기 메소드 
	 * @param rIndexNo
	 * @return
	 */
	public ReviewDTO userReviewReadForUpdate(String rIndexNo);
	
	/**
	 * 리뷰 삭제메소드 
	 * @param rIndexNo
	 * @return
	 */
	public int userReviewDelete(String rIndexNo);
}
