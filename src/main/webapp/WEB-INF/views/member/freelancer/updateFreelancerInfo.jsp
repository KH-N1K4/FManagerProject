<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가수정하기</title>

    <link rel="stylesheet" href="/resources/css/freelancer/updateExpertInfo.css">
    <%-- <link rel="stylesheet" href="/resources/css/freelancer/registerExpert.css"> --%>


</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
   

    <div class="main">
        
       <jsp:include page="/WEB-INF/views/member/memberSide.jsp" />
        <section class="mainMenu">
            <div id="title">수정하기</div>
            
            <form id="registerFrm" action="/member/myInfo/updateFreelancerInfo" enctype="multipart/form-data" method="POST">
                <div>
                    <div class="itemTitle">
                        <div class="item">지역</div>
                        <div>
                        
                         <select name="regionNo" id="area" class="select">
	                        <option value="0">전체</option>
	                        <option value="1" <c:if test ="${freelancer1.regionName eq '서울'}">selected="selected"</c:if>>서울</option>
	                        <option value="2" <c:if test ="${freelancer1.regionName eq '경기'}">selected="selected"</c:if>>경기</option>
	                        <option value="3" <c:if test ="${freelancer1.regionName eq '부산'}">selected="selected"</c:if>>부산</option>
	                        <option value="4" <c:if test ="${freelancer1.regionName eq '대구'}">selected="selected"</c:if>>대구</option>
	                        <option value="5" <c:if test ="${freelancer1.regionName eq '인천'}">selected="selected"</c:if>>인천</option>
	                        <option value="6" <c:if test ="${freelancer1.regionName eq '광주'}">selected="selected"</c:if>>광주</option>
	                        <option value="7" <c:if test ="${freelancer1.regionName eq '대전'}">selected="selected"</c:if>>대전</option>
	                        <option value="8" <c:if test ="${freelancer1.regionName eq '울산'}">selected="selected"</c:if>>울산</option>
	                        <option value="9" <c:if test ="${freelancer1.regionName eq '강원'}">selected="selected"</c:if>>강원</option>
	                        <option value="10" <c:if test ="${freelancer1.regionName eq '충북'}">selected="selected"</c:if>>충북</option>
	                        <option value="11" <c:if test ="${freelancer1.regionName eq '충남'}">selected="selected"</c:if>>충남</option>
	                        <option value="12" <c:if test ="${freelancer1.regionName eq '전북'}">selected="selected"</c:if>>전북</option>
	                        <option value="13" <c:if test ="${freelancer1.regionName eq '전남'}">selected="selected"</c:if>>전남</option>
	                        <option value="14" <c:if test ="${freelancer1.regionName eq '경북'}">selected="selected"</c:if>>경북</option>
	                        <option value="15" <c:if test ="${freelancer1.regionName eq '경남'}">selected="selected"</c:if>>경남</option>
	                        <option value="16" <c:if test ="${freelancer1.regionName eq '제주'}">selected="selected"</c:if>>제주</option>
	                        <option value="17" <c:if test ="${freelancer1.regionName eq '해외'}">selected="selected"</c:if>>해외</option>
	                    </select>
                            <%-- <select name="regionNo">
                            <c:forEach var="list" items="${regionList}">
                                <option value="${list.regionNumber}" 
                                <c:if test ="${freelancer.regionNo eq list.regionNumber}">selected="selected"</c:if>>${list.regionName}</option>
                            </c:forEach> 
                            </select>  --%>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">전문 분야</div>
                        <div>
                              <c:forEach var="field" items="${fn:split(freelancer1.freelancerField,',') }">
                                <c:choose>
                                    <c:when test="${field == 1}">
                                        <c:set var="field1" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 2}">
                                        <c:set var="field2" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 3}">
                                        <c:set var="field3" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 4}">
                                        <c:set var="field4" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 5}">
                                        <c:set var="field5" value="checked"/>
                                    </c:when>               
                                </c:choose> 
                            </c:forEach>

                            <input type="checkbox" name="freelancerField" id="design" value="1" ${field1}>
                            <label for="design" class="checkbox">디자인</label>
                            <input type="checkbox" name="freelancerField" id="it" value="2" ${field2}>
                            <label for="it" class="checkbox">IT.프로그래밍</label>
                            <input type="checkbox" name="freelancerField" id="video" value="3" ${field3}>
                            <label for="video" class="checkbox">영상</label>
                            <input type="checkbox" name="freelancerField" id="photo" value="4" ${field4}>
                            <label for="photo" class="checkbox">사진</label>
                            <input type="checkbox" name="freelancerField" id="sound"value="5" ${field5}>
                            <label for="sound" class="checkbox">음향</label>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">기간</div>
                        <%-- <div>
                            <input type="text" name="freelancerCont" id="" class="number" value="${freelancer1.freelancerCont}"> 년
                        </div> --%>
                        <select  name="freelancerCont" id="freelancerCont" class="number">
                        
	                		<c:forEach var="cont" begin="0" end="60">
	                			<option value="${cont }"<c:if test="${freelancer1.freelancerPeriod==cont}">selected="selected"</c:if>>${cont }</option>
	                		</c:forEach>
                		</select>년
                    </div>
                   <%--  <div class="itemTitle">
                        <div class="item">경력 사항</div>
                        <div>
                            <input style="width :300px;" type="text" name="career" id="careerPopup" class="modal" value="${freelancer.careerCompanyName}/${freelancer.careerCompanyDepartment}/${freelancer.careerCompanyPosition}/${freelancer.careerCompanyRegion}/${freelancer.careerCompanyPeriod}">
                            <input type="text" name="careerCompanyDepartment" id="" value="${freelancer.careerCompanyDepartment}">
                            <input type="text" name="careerCompanyPosition" id="" value="${freelancer.careerCompanyPosition}">
                            <input type="text" name="careerCompanyRegion" id="" value="${freelancer.careerCompanyRegion}">
                            <input type="text" name="careerPeriod" id="" value="${freelancer.careerPeriod}">
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div>
                            <input style="width :300px;" type="text" name="license" id="licensePopup" class="modal" value="${freelancer.licenseName}/${freelancer.licenseDate}/${freelancer.licenseAgency}">

                        </div>
                    </div> --%>
                    
                     <div class="itemTitle">
                		<div class="item additional">학력/전공 &nbsp;<span id="majorPopup" class="modal" >+</span>
		                	  <c:forEach var="major" items="${freelancer1.majorList }">
		                	  <c:if test="${major.majorGraduateStatus ==1}"><c:set var="majorStatus" value="재학"/> </c:if>
		                	  <c:if test="${major.majorGraduateStatus ==2}"><c:set var="majorStatus" value="휴학"/> </c:if>
		                	  <c:if test="${major.majorGraduateStatus ==3}"><c:set var="majorStatus" value="이수"/> </c:if>
		                	  <c:if test="${major.majorGraduateStatus ==4}"><c:set var="majorStatus" value="졸업"/> </c:if>
		                	 	<div class="newOne">
							       	<input type="text" name="major" class="addContent" 
							       	value="${major.majorAcademyName }/${major.majorName }/${majorStatus }" readonly/>
							       	<span class="xbtn">x</span>
				                </div>
						       </c:forEach>
						</div> 
		            </div>
		            <div class="itemTitle">
		                <div class="item additional">경력 사항 &nbsp;<span id="careerPopup" class="modal" >+</span>
		                 <c:forEach var="career1" items="${freelancer1.careerList }">
		                 	<div class="newOne">
						       	<input type="text" name="career" class="addContent" 
						       	value="${career1.careerCompanyName }/${career1.careerCompanyDepartment }/${career1.careerCompanyPosition }/${career1.careerCompanyRegion }/${career1.careerCompanyPeriod1 }" readonly/>
						       	<span class="xbtn">x</span>
			                </div>
					       </c:forEach>
		                </div>
		            </div>
		            <div class="itemTitle">
		                <div class="item additional">자격증 &nbsp;<span id="licensePopup" class="modal" >+</span>
			                 <c:forEach var="license" items="${freelancer1.licenseList }">
				                <div class="newOne">
							       	<input type="text" name="license" class="addContent"
							       	 value="${license.licenseName }/${license.licenseDate }/${license.licenseAgency }" readonly/>
							       	<span class="xbtn">x</span>
				                </div>
						       </c:forEach>
					       </div>
		            </div>
		            
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        
                         <div>
		                	<select name="contactTime1" id="contactTime1" class="number">
		                		<c:forEach var="hour1" begin="0" end="24">
		                			<option value="${hour1 }" <c:if test ="${freelancer1.contactTime1 eq hour1}">selected="selected"</c:if>>${hour1 }</option>
		                		</c:forEach>
		                	</select>시 ~
		                	<select name="contactTime2" id="contactTime2" class="number">
		                		<c:forEach var="hour2" begin="0" end="24">
		                			<option value="${hour2 }" <c:if test ="${freelancer1.contactTime2 eq hour2}">selected="selected"</c:if>>${hour2 }</option>
		                		</c:forEach>
		                	</select>시
		                </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                             <select name="bankCode" id="bankCode" class="select">
		                        <option value="0">전체</option>
		                        <option value="1" <c:if test ="${freelancer1.bankName eq '신한'}">selected="selected"</c:if>>신한</option>
		                        <option value="2" <c:if test ="${freelancer1.bankName eq '국민'}">selected="selected"</c:if>>국민</option>
		                        <option value="3" <c:if test ="${freelancer1.bankName eq '우리'}">selected="selected"</c:if>>우리</option>
		                        <option value="4" <c:if test ="${freelancer1.bankName eq '기업'}">selected="selected"</c:if>>기업</option>
		                    </select>
                            <input type="text" value="${freelancer1.bankAccountNo}"name="bankAccountNumber" id="bankAccountNumber"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required>
                        </div>
                    </div>
                    <div class="itemTitle"> 
                        <div class="item" id="intro">자기소개</div>
                        <div>
                            <%-- <input type="text" name="freelancerIntro" id="freelancerIntro" class="input" >  --%>

                            <textarea name="freelancerIntro" id="freelancerIntro" cols="72" rows="10" >${freelancer1.freelancerIntro}</textarea>
                        </div>
                    </div>
                    <div id="btnArea">
                        <button id="updateBtn">수정</button>
                    </div>
                </div>
            </form>
        </section>

      
      
	       <div class="modal_major">
	               <jsp:include page="/WEB-INF/views/member/freelancer/modal/major.jsp" /> 
	       </div>
	       <div class="modal_license">
	               <jsp:include page="/WEB-INF/views/member/freelancer/modal/license.jsp" /> 
	       </div>
	       <div class="modal_career">
	               <jsp:include page="/WEB-INF/views/member/freelancer/modal/career.jsp" /> 
	       </div>
    	</div>
    </div>
    
    
    
    
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <%-- <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/member/freelancer/updateFreelancerInfo.js"></script>  --%>

	  <script src="/resources/js/member/freelancer/enrollFreelancerPopup.js"></script> 
</body>
</html>