<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신고내역</title>
    <link rel="stylesheet" href="/resources/css/manager/reportDetail.css">

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
        <div class="table-title">신고 내역 상세보기</div>
        <div class="question-table-title">
            <span>1</span>
            <span>제목</span>
            <span>거래번호</span>
            <span>345</span>
        </div>

        <table class="question-table">
        
            <tr>
                <td class="table-column-title">작성자</td>
                <td colspan="3">이메일@example.com</td>
            </tr>
            <tr>
                <td class="table-column-title">구분</td>
                <td colspan="3">이메일@example.com</td>
            </tr>
            <tr>
                <td class="table-column-title">내용</td>
                <td colspan="3" class="content-detail">
                    <input type="text" >
                </td>
            </tr>
           
        </table>


    </div> <!-- main -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>