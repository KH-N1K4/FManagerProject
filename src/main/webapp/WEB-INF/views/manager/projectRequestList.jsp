<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 의뢰 등록 내역게시판</title>

    <link rel="stylesheet" href="/resources/css/manager/projectRequestList.css">

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
        <div id="service-list-title-area">
            
                <span id="service-list-title">서비스 의뢰 등록 내역 게시판</span>
                <span class="select-area">
                    <select class="select-area-input" name="" id="">
                        <option value="전체">전체</option>
                        <option value="승인완료">승인완료</option>
                        <option value="승인대기중">승인대기중</option>
                        <option value="반려">반려</option>
                    </select>
                </span>
            
        </div>

        <div id="service-list-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="service-list-table-column">
                <div class="service-num">번호</div>
                <div class="service-title">제목</div>
                <div class="service-status">상태</div>
                <div class="service-button">
                

                </div>
            </div>

            <!-- 테이블 내용 -->
            <div class="service-list-table-content">
                <div class="service-num">1</div>
                <div class="service-title">제목1</div>
                <div class="service-status">승인대기중</div>
                <div class="service-button">
                    <span class="service-button-value">삭제</span>
                </div>
            </div>
            <div class="service-list-table-content">
                <div class="service-num">1</div>
                <div class="service-title">제목1</div>
                <div class="service-status">승인완료</div>
                <div class="service-button">
                    <span class="service-button-value">삭제</span>
                </div>
            </div>
            <div class="service-list-table-content">
                <div class="service-num">1</div>
                <div class="service-title">제목1</div>
                <div class="service-status">반려</div>
                <div class="service-button">
                    <span class="service-button-value">삭제</span>
                </div>
            </div>
           
          
                
            
        
            

        </div> <!-- buy-table -->

    </div> <!-- main -->

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    

</body>
</html>