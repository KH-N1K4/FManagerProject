<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의 내역</title>

    <link rel="stylesheet" href="/resources/css/manager/userInquiryList.css">

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
        <div id="question-list-title-area">
            
                <span id="question-list-title">문의 내역</span>
                <span class="select-area">
                    <select class="select-area-input" name="" id="">
                        <option value="전체">전체</option>
                        <option value="문의">문의</option>
                        <option value="신고">신고</option>
                    </select>
                </span>
            
        </div>

        <div id="question-list-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="question-list-table-column">
                <div class="question-num">번호</div>
                <div class="question-type">구분</div>
                <div class="question-title">제목</div>
                <div class="question-status">상태
                

                </div>
            </div>

            <!-- 테이블 내용 -->
            <div class="question-list-table-content">
                <div class="question-num">1</div>
                <div class="question-type">문의</div>
                <div class="question-title"><a href="/manager/userInquiry/1">제목1</a></div>
                <div class="question-status">
                    <span class="question-answer">답변 완료</span>
                </div>
                
            </div>
            <div class="review-manage-table-content">
                <div class="question-num">2</div>
                <div class="question-type">신고</div>
                <div class="question-title">제목2</div>
                <div class="question-status">
                    <span class="question-tempo">보류중</span>
                </div>
                
            </div>
            <div class="review-manage-table-content">
                <div class="question-num">2</div>
                <div class="question-type">신고</div>
                <div class="question-title">제목3</div>
                <div class="question-status">
                    <span class="question-wating">대기중</span>
                </div>
                
            </div>
            <div class="review-manage-table-content">
                <div class="question-num">1</div>
                <div class="question-type">문의</div>
                <div class="question-title">제목1</div>
                <div class="question-status">
                    <span class="question-answer">답변 완료</span>
                </div>
                
            </div>
        
            

        </div> <!-- buy-table -->

    </div> <!-- main -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    

</body>
</html>