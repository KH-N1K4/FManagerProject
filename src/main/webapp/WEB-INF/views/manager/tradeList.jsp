<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매내역</title>

    <link rel="stylesheet" href="/resources/css/manager/tradeList.css">

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

            right: 20px;
            top:20px;
        }
        
        .header-top>span{
            margin:0 20px;

            cursor: pointer;
            color:black;
        }
        #nav{
            height: 40px;
            background-color: black;
        }

        #nav>ul{
            width: 1200px;
            margin:auto;
        }

        #nav>ul>li{
            list-style: none;
            float: left;
            margin:12px 30px;
            color:white;
        }

       

    </style>
</head>
<body>
    
      <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>


    <div class="main">
        <div id="manager-buy-title-area">
            <div id="manager-buy-title">구매 내역 관리
            <span class="search">
                <input type="text" class="buy-search-input" name="buy-search-input" id ="search-input">
            </span>
            </div>
        </div>

        <div id="manager-buy-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="manager-buy-table-column">
                <div class="manager-num">번호</div>
                <div class="manager-trade-num">거래번호</div>
                <div class="manager-service-name">서비스 명</div>
                <div class="manager-expert">전문가</div>
                <div class="manager-customer">의뢰자</div>
                <div class="manager-work-status">작업 상태</div>
                <div class="manager-division">구분</div>
                <div class="manager-option">
                    
                </div>
            </div>

            <!-- 테이블 내용 -->
            <div class="manager-buy-table-content">
                <div class="manager-num">1</div>
                <div class="manager-trade-num">456</div>
                <div class="manager-service-name">서비스 명 동일</div>
                <div class="manager-expert">나나</div>
                <div class="manager-customer">김지윤</div>
                <div class="manager-work-status">환불 완료</div>
                <div class="manager-division">입금</div>
                <div class="manager-option">
                    <span>정산</span>
                    <span>환불</span>
                </div>
            </div>
            <div class="manager-buy-table-content">
                <div class="manager-num">1</div>
                <div class="manager-trade-num">456</div>
                <div class="manager-service-name">서비스 명 동일</div>
                <div class="manager-expert">나나</div>
                <div class="manager-customer">김지윤</div>
                <div class="manager-work-status">환불 완료</div>
                <div class="manager-division">입금</div>
                <div class="manager-option">
                    <span>정산</span>
                    <span>환불</span>
                </div>
            </div>
            

        </div> <!-- buy-table -->

    </div> <!-- main -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    

</body>
</html>