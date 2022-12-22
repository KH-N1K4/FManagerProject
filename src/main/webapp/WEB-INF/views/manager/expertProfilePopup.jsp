<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가 팝업창</title>

    <link rel="stylesheet" href="/resources/css/manager/expertProfilePopup.css">
</head>
<body>


    <div class="main">


        <section>
            <div id="title">전문가 정보</div>
            <form action="#" name="myPage-frm">
                <div>
                    <div id="content">
                        <div class="profile-image-area">
                            <img id="profile-image" src="" alt="">
                            <span id="delete-image">&times;</span>
                        </div>
                        <div class="profile-btn-area">
                            
                        </div>
                    </div>
                </div>
                <div id="inputArea">
                    <div>
                        <div class="item">닉네임</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">이메일</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">휴대폰</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">직업</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    
                
                    <!-- <div >
                        <button type="reset">취소</button>
                    </div> -->
                    <div>
                        <div>
                            <div class="item">자기소개</div>
                            <div>
                                <textarea name="" id="" cols="110" rows="8"></textarea>
                            </div>
                        </div>
                        <div class="itemTitle">
                            <div class="item">지역</div>
                            <div>
                                <span>서울</span>
                            </div>
                        </div>
                        <div class="itemTitle">
                            <div class="item">전문 분야</div>
                            <div id="checkbox">
                                <input type="checkbox" name="" id="design">
                                <label for="design" class="checkbox">
                                    <span></span>디자인
                                </label>
                                <input type="checkbox" name="" id="it">
                                <label for="it" class="checkbox">
                                    <span></span>IT.프로그래밍
                                </label>
                                <input type="checkbox" name="" id="video">
                                <label for="video" class="checkbox">
                                    <span></span>영상
                                </label>
                                <input type="checkbox" name="" id="photo">
                                <label for="photo" class="checkbox">
                                    <span></span>사진
                                </label>
                                <input type="checkbox" name="" id="sound">
                                <label for="sound" class="checkbox">
                                    <span></span>음향
                                </label>
                            </div>
                        </div>
                        <div class="itemTitle">
                            <div class="item">기간</div>
                            <div>
                                <span>18</span>년
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
                                <span>09</span> 시 ~ <span>18</span> 시
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
                                <input type="text" name="" id="account" value="110-412-549956" readonly
                                style="background-color: gainsboro;">
                            </div>
                        </div>
                    </div>
                    <div id="addArea">
                        <div class="item">포트폴리오</div>
                    </div>
                    <div id="serviceArea">
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                        <div class="service">g</div>
                    </div>
                </div>
            </form>
        
        </section>

        
    </div>
</body>
</html>