<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




    <div class="modal_body">
    	<span class="modal_close2">x</span>

    <div id="careerInputMain">
        
        <div>
            <div class="modal_item">회사명</div>
            <div>
                <input type="text" name="careerCompanyName" id="careerCompanyName" class="input2">
            </div>
        </div>
        <div>
            <div class="modal_item">근무부서</div>
            <div>
                <input type="text" name="careerCompanyDepartment" id="careerDepartment" class="input2">
            </div>
        </div>
        <div>
            <div class="modal_item">직위</div>
            <div>
                <input type="text" name="careerCompanyPosition" id="careerPosition" class="input2">
            </div>
        </div>
        <div>
            <div class="modal_item">근무지</div>
            <div>
                <input type="text" name="careerCompanyRegion" id="careerRegion" class="input2">
            </div>
        </div>
        <div>
            <div class="modal_item">근무기간</div>
            <div>
                <select name="careerCompanyPeriod1" id="careerCompanyPeriod1" class="input2">
                    
                    <%-- <c:forEach var="cont" begin="0" end="60">
                			<option value="${cont }">${cont }년</option>
                    </c:forEach> --%>
                    <option value="-1">년</option>
                    <option value="0">0년</option>
                    <option value="1">1년</option>
                    <option value="2">2년</option>
                    <option value="3">3년</option>
                    <option value="4">4년</option>
                    <option value="5">5년</option>
                    <option value="6">6년</option>
                    <option value="7">7년</option>
                    <option value="8">8년</option>
                    <option value="9">9년</option>
                    <option value="10">10년</option>
                    <option value="11">11년</option>
                    <option value="12">12년</option>
                    <option value="13">13년</option>
                    <option value="14">14년</option>
                    <option value="15">15년</option>
                    <option value="16">16년</option>
                    <option value="17">17년</option>
                    <option value="18">18년</option>
                    <option value="19">19년</option>
                    <option value="20">20년</option>
                    <option value="21">21년</option>
                    <option value="22">22년</option>
                    <option value="23">23년</option>
                    <option value="24">24년</option>
                    <option value="25">25년</option>
                    <option value="26">26년</option>
                    <option value="27">27년</option>
                    <option value="28">28년</option>
                    <option value="29">29년</option>
                    <option value="30">30년</option>
                    <option value="31">31년</option>
                    <option value="32">32년</option>
                    <option value="33">33년</option>
                    <option value="34">34년</option>
                    <option value="35">35년</option>
                    <option value="36">36년</option>
                    <option value="37">37년</option>
                    <option value="38">38년</option>
                    <option value="39">39년</option>
                    <option value="40">40년</option>

                </select>
                <select name="careerCompanyPeriod2" id="careerCompanyPeriod2" class="input2">
                    <option value="-1">개월</option>
                    <option value="0">0개월</option>
                    <option value="1">1개월</option>
                    <option value="2">2개월</option>
                    <option value="3">3개월</option>
                    <option value="4">4개월</option>
                    <option value="5">5개월</option>
                    <option value="6">6개월</option>
                    <option value="7">7개월</option>
                    <option value="8">8개월</option>
                    <option value="9">9개월</option>
                    <option value="10">10개월</option>
                    <option value="11">11개월</option>
                </select>
                
            </div>
        </div>
        <div>
            <button id="sendContent2">적용</button>

        </div>
    </div>
    <%-- <script src="/resources/js/member/freelancer/enrollFreelancerPopup.js"></script> --%>
