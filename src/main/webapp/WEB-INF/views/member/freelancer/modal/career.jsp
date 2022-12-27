<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



    <div id="title">경력사항</div>
    <div class="modal_body">
    	<span class="modal_close2">x</span>

    <div id="careerInputMain">
        
        <div>
            <div class="item">회사명</div>
            <div>
                <input type="text" name="careerCompanyName" id="careerCompanyName" class="input2">
            </div>
        </div>
        <div>
            <div class="item">근무부서</div>
            <div>
                <input type="text" name="careerCompanyDepartment" id="careerDepartment" class="input2">
            </div>
        </div>
        <div>
            <div class="item">직위</div>
            <div>
                <input type="text" name="careerCompanyPosition" id="careerPosition" class="input2">
            </div>
        </div>
        <div>
            <div class="item">근무지</div>
            <div>
                <input type="text" name="careerCompanyRegion" id="careerRegion" class="input2">
            </div>
        </div>
        <div>
            <div class="item">근무기간</div>
            <div>
                <select name="careerCompanyPeriod1" id="careerCompanyPeriod" class="input2">
                    <option value="0">년</option>
                    <option value="1">1년</option>
                    <option value="2">2년</option>
                    <option value="3">3년</option>
                    <option value="4">4년</option>
                    <option value="5">5년</option>
                </select>
                <select name="careerCompanyPeriod2" id="careerCompanyPeriod" class="input2">
                    <option value="0">개월</option>
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
                    <option value="12">12개월</option>
                </select>
                
            </div>
        </div>
        <div>
            <button id="sendContent2">적용</button>

        </div>
    </div>
    <%-- <script src="/resources/js/member/freelancer/enrollFreelancerPopup.js"></script> --%>
