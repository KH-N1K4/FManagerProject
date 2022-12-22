<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가 정보</title>

    <link rel="stylesheet" href="/resources/css/freelancer/expertInfo.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <div class="main">
        
         <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>
        
        <section class="mainMenu">
            <div id="title">전문가 정보</div>
            <div>
                <div id="updateArea"><a href="" id="update">수정하기</a></div>
                <div>
                    <div class="item">자기소개</div>
                    <div>
                        <textarea name="" id="" cols="90" rows="4" readonly>미국인과 결혼하신 이모 덕에 어려서부터 영어에 대한 관심이 많았고 영어공부도 좋아했습니다. 관련해서 더 깊이있게 공부하고 대학진학을 통한 공부의 꿈을 미루고 바로 취직을 하게 됐습니다. 이후 전업주부가 되
                        </textarea>
                    </div>
                </div>
                <div class="itemTitle">
                    <div class="item">지역</div>
                    <div>
                        <select name="" id="area">
                            <option value="">전체</option>
                            <option value="">서울</option>
                            <option value="">경기</option>
                            <option value="">부산</option>
                            <option value="">대구</option>
                            <option value="">인천</option>
                            <option value="">광주</option>
                            <option value="">대전</option>
                            <option value="">울산</option>
                            <option value="">강원</option>
                            <option value="">충북</option>
                            <option value="">충남</option>
                            <option value="">전북</option>
                            <option value="">전남</option>
                            <option value="">경북</option>
                            <option value="">경남</option>
                            <option value="">제주</option>
                            <option value="">해외</option>
                        </select>
                    </div>
                </div>
                <div class="itemTitle">
                    <div class="item">전문 분야</div>
                    <div>
                        <input type="checkbox" name="" id="design">
                        <label for="design" class="checkbox">디자인</label>
                        <input type="checkbox" name="" id="it">
                        <label for="it" class="checkbox">IT.프로그래밍</label>
                        <input type="checkbox" name="" id="video">
                        <label for="video" class="checkbox">영상</label>
                        <input type="checkbox" name="" id="photo">
                        <label for="photo" class="checkbox">사진</label>
                        <input type="checkbox" name="" id="sound">
                        <label for="sound" class="checkbox">음향</label>
                    </div>
                </div>
                <div class="itemTitle">
                    <div class="item">기간</div>
                    <div>
                        <input type="text" name="" id="" class="number"> 년
                    </div>
                </div>
                <div class="itemTitle">
                    <div class="item">경력 사항</div>
                    <div></div>
                </div>
                <div class="itemTitle">
                    <div class="item">자격증</div>
                    <div></div>
                </div>
                <div class="itemTitle">
                    <div class="item">연락 가능 시간</div>
                    <div>
                        <input type="text" name="" id="" class="number"> 시 ~ <input type="text" name="" id="" class="number"> 시
                    </div>
                </div>
                <div class="itemTitle">
                    <div class="item">수익금 출금 은행</div>
                    <div>
                        <select name="" id="bankName">
                            <option value="">전체</option>
                            <option value="">신한</option>
                            <option value="">국민</option>
                            <option value="">우리</option>
                            <option value="">기업</option>
                        </select>
                        <input type="text" name="" id="account">
                    </div>
                </div>
            </div>
            <div id="addArea">
                <div class="item">포트폴리오</div>
                <div><a href="" id="add">추가하기</a></div>
            </div>
            <div id="serviceArea">
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
            </div>
             
        </section>
    </div>
</body>
</html>