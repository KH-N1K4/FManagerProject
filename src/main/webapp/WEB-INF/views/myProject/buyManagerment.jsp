<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_suggestion</title>

  <link rel="stylesheet" href="/resources/css/myProject/buyManagerment.css">
  
</head>
<body>
  <main>
   <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <section class="sideMenu">
          <div class="aside">
            <a class="myProject_User_side" href="../html/myProject_UserPage.html">내 프로젝트</a>
            <a class="myProject_User_side" href="../html/myProject_suggestion.html">받은 제안</a>
            <a class="myProject_User_side" href="">구매 관리</a>
            <a class="myProject_User_side" href="">결제 내역</a>
          </div>
        </section>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>구매 관리</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
                <!-- 상단 selectbox -->
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" >
                    <option value="0" selected="">전체</option>
                    <option value="1">디자인</option>
                    <option value="2">IT·프로그래밍</option>
                    <option value="3">영상</option>
                    <option value="4">사진</option>
                    <option value="5">음향</option>
                  </select>
                </div>
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" >
                    <option value="0" selected="">기간</option>
                    <option value="1">디자인</option>
                    <option value="2">IT·프로그래밍</option>
                    <option value="3">영상</option>
                    <option value="4">사진</option>
                    <option value="5">음향</option>
                  </select>
                </div>
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" >
                    <option value="0" selected="">기간</option>
                    <option value="1">디자인</option>
                    <option value="2">IT·프로그래밍</option>
                    <option value="3">영상</option>
                    <option value="4">사진</option>
                    <option value="5">음향</option>
                  </select>
                </div>

                <!-- 서비스명 입력 박스 -->
                <div class="inputBox">
                  <input type="text" placeholder="     서비스명 입력">
                </div>

                <!-- 검색 버튼 -->
                <div class="buttonBox">
                  <button>검색</button>
                </div>

                <!-- 상단 selectbox -->
              </section>
            </div>
            <!--  -->
            <div class="tableArea">
              <div id="tableContent">
                <table class="tbl_lst_type">	
                  <colgroup>
                    <col width="80"><col width="300"><col width="100"><col width="100"><col width="100"><col width="200">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">전문가</strong></th>  
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">작업상태</strong></th>
                      <th scope="col" class="last"><strong class="line_n"></strong></th>
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                    <tr>
                      <td class="tc"><span class="num">1</span></td>
                      <td class="tl"><div class="td_link"><a href="#">로고 디자인 제작 요청</a></div></td>
                      <td class="tc"><div class="td_link"><a href="#">노성찬</a></div></td>
                      <td class="tc"><span class="text">수정횟수</span></td>
                      <td class="tc"><span class="text">진행 중</span></td>
                      <td class="tc">
                        <button>완료</button>
                        <button>취소</button>
                        <button id="gg">신고</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="tc"><span class="num">2</span></td>
                      <td class="tl"><div class="td_link"><a href="#">로고 디자인 제작 요청</a></div></td>
                      <td class="tc"><div class="td_link"><a href="#">김혜진</a></div></td>
                      <td class="tc"><span class="text">수정횟수</span></td>
                      <td class="tc"><span class="text">진행 중</span></td>
                      <td class="tc">
                        <button id="review">리뷰하기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="tc"><span class="num">3</span></td>
                      <td class="tl"><div class="td_link"><a href="#">로고 디자인 제작 요청</a></div></td>
                      <td class="tc"><div class="td_link"><a href="#">김정현</a></div></td>
                      <td class="tc"><span class="text">수정횟수</span></td>
                      <td class="tc"><span class="text">진행 중</span></td>
                      <td class="tc">
                        <button></button>
                        <button></button>
                        <button></button>
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>