<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="member" value="${member}" />

<link rel="stylesheet" href="/resources/css/manager/userProfilePopup.css">



	<div class="member-info">


		<section>
			<div id="titleArea">
				<div id="title">회원 정보</div>
				<div class="modal_close">&times;</div>
			</div>
			<div id="infoArea">
				<div>
					<div id="content">
						<div class="profile-image-area">
							<img id="profile-image" src="" alt=""> 
							<span id="delete-image">&times;</span>
						</div>
						<div class="profile-btn-area"></div>
					</div>
				</div>
				<div id="inputArea">
					<div>
						<div class="item">닉네임</div>
						<div>
							<input type="text" name="" id="memberNickname" class="input" readonly>
						</div>
					</div>
					<div>
						<div class="item">이메일</div>
						<div>
							<input type="text" name="" id="memberEmail" class="input" readonly>
						</div>
					</div>
					<div>
						<div class="item">휴대폰</div>
						<div>
							<input type="text" name="" id="memberTel" class="input" readonly>
						</div>
					</div>
					<div>
						<div class="item">직업</div>
						<div>
							<input type="text" name="" id="memberJob" class="input" readonly>
						</div>
					</div>
					<div>
						<div class="item">관심사 선택</div>
						<div id="checkbox">
							<input type="checkbox" name="" id="1" disabled> <label for="design" class="checkbox"> <span></span>디자인
							</label> <input type="checkbox" name="" id="2" disabled> <label for="it" class="checkbox"> <span></span>IT.프로그래밍
							</label> <br> <input type="checkbox" name="" id="3" disabled> <label for="video" class="checkbox"> <span></span>영상
							</label> <input type="checkbox" name="" id="4" disabled> <label for="photo" class="checkbox"> <span></span>사진
							</label> <input type="checkbox" name="" id="5" disabled> <label for="sound" class="checkbox"> <span></span>음향
							</label>
						</div>
					</div>

				</div>

			</div>
			<div class="freelancerArea">
				<div>
					<div>
						<div class="item">자기소개</div>
						<div>
							<textarea name="" id="freelancerIntroduction" cols="77" rows="8" readonly></textarea>
						</div>
					</div>
					<div class="itemTitle">
						<div class="item">지역</div>
						<div>
							<span id="freelancerRegionName"></span>
						</div>
					</div>
					<div class="itemTitle">
						<div class="item">전문 분야</div>
						<div class="field">
							<input type="checkbox" name="" id="design"> <label for="design" class="checkbox"> <span></span>디자인
							</label> <input type="checkbox" name="" id="it"> <label for="it" class="checkbox"> <span></span>IT.프로그래밍
							</label> <input type="checkbox" name="" id="video"> <label for="video" class="checkbox"> <span></span>영상
							</label> <input type="checkbox" name="" id="photo"> <label for="photo" class="checkbox"> <span></span>사진
							</label> <input type="checkbox" name="" id="sound"> <label for="sound" class="checkbox"> <span></span>음향
							</label>
						</div>
					</div>
					<div class="itemTitle">
						<div class="item">기간</div>
						<div><span id="freelancerPeriod"></span>년</div>
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
							<span id="freeContactTime1"></span> 시 ~ <span id="freeContactTime2"></span> 시
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
							</select> <input type="text" name="" id="account" value="110-412-549956" readonly style="background-color: gainsboro;">
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
				</div>
			</div>
			<div class="btnArea">
				<a href="/memberDelete">탈퇴</a>
			</div>


		</section>


	</div>

