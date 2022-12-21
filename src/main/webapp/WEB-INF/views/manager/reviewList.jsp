<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰관리</title>

    <link rel="stylesheet" href="/resources/css/manager/reviewList.css">

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
        <div id="review-manage-title-area">
            <div id="review-manage-title">리뷰 관리
           
            </div>
        </div>

        <div id="review-manage-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="review-manage-table-column">
                <div class="review-num">댓글번호</div>
                <div class="review-content">리뷰 내용</div>
                <div class="review-writer">구분</div>
                <div class="review-delete">삭제
                </div>
            </div>

            <!-- 테이블 내용 -->
            <div class="review-manage-table-content">
                <div class="review-num">1</div>
                <div class="review-content">리뷰 내용</div>
                <div class="review-writer">구분</div>
                <div class="review-delete">
                    <span>삭제</span>
                </div>
            </div>
            <div class="review-manage-table-content">
                <div class="review-num">1</div>
                <div class="review-content">리뷰 내용</div>
                <div class="review-writer">구분</div>
                <div class="review-delete">
                    <span>삭제</span>
                </div>
            </div>
            <div class="review-manage-table-content">
                <div class="review-num">1</div>
                <div class="review-content">리뷰 내용</div>
                <div class="review-writer">구분</div>
                <div class="review-delete">
                    <span>삭제</span>
                </div>
            </div>
            
        
            

        </div> <!-- buy-table -->

    </div> <!-- main -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>