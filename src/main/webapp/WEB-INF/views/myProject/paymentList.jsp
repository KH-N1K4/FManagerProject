<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>결제 내역</title>

  <link rel="stylesheet" href="/resources/css/myProject/paymentList.css">
  <style>
    body{
        margin:0;
    }

    #logo{
        width: 200px;
        height: 100px; 
        position: absolute;
        left: 60px;
        top:40px;
        /* border:1px solid black; */
    }

    #header{
        background-color: #538126;
    }

    #logo>img{
        width: 100%;
    }

    #header1{
        width: 1200px;
        height: 160px;
        margin:auto;
        position: relative;    
    }

    .header-top{
        position: absolute;
        right:0;
        top:20px;
        align-items: center;
        display: flex;
    }
    
    .header-top span{
        margin:0 12px;
        cursor: pointer;
        color:white !important;
    }
    .header-top img{
        border-radius: 45%;
    }

</style>
</head>
<body>

  <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/>

  <main>
    <!-- hearder -->
    <!-- <div id="header">
      <div id="header1">
          <div id="logo"><img src="../resources/images/final_logo.png" alt=""></div>
          <div class="header-top">
            <a><span>전문가 전환</span></a>
            <a><span>메세지</span></a>
            <a><span>홈으로</span></a>
            <a><img style="width: 32px; height: 32px;" src="../resources/images/프로필.PNG"></a>
          </div>
      </div>
    </div> -->
    <!-- hearder -->
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProjectSide.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
              <div class="container_header">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span>결제 내역</span>
                    <span>
                      <select name="" id="">
                        <option value="0" selected="">전체</option>
                        <option value="1">디자인</option>
                        <option value="2">IT·프로그래밍</option>
                        <option value="3">영상</option>
                        <option value="4">사진</option>
                        <option value="5">음향</option>
                      </select>
                      <input type="date">
                      <input type="date">
                    </span>
                  
                  </div>
                  <!--------------------------------->
              </div>
            
              <table>
                <tr>
                    <th style="width: 100px;">번호</th>
                    <th style="width: 100px;">구분</th>
                    <th style="width: 700px;">서비스명</th>
                    <th style="width: 100px;">날짜</th>
                    <th style="width: 100px;">금액</th>
                </tr>
                <tr>
                  <td>1</td>
                  <td>구분</td>
                  <td>서비스명서비스명</td>
                  <td>12/20</td>
                  <td>50000</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>구분</td>
                  <td>서비스명서비스명</td>
                  <td>12/20</td>
                  <td>50000</td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>구분</td>
                  <td>서비스명서비스명</td>
                  <td>12/20</td>
                  <td>50000</td>
                </tr>
                
              </table>
            
                
            </div>
          
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
</body>
</html>