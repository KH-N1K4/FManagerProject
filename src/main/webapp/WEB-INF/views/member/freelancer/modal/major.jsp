<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <div class="modal_body">
        <span class="modal_close1">x</span>
        <div id="majorInputMain">
                <div>
                    <div class="item">학교명</div>
                    <div>
                        <input type="text" name="AcademyName" id="AcademyName" class="input1">
                    </div>
                </div>
                <div>
                    <div class="item">전공</div>
                    <div>
                        <input type="text" name="majorName" id="majorName" class="input1">
                    </div>
                </div>
                <div>
                    <div class="item">상태</div>
                    <div>
                        <select name="graduateStatus" id="graduateStatus" class="input1 ">
                            <option value="0">선택해주세요</option>
                            <option value="재학">재학</option>
                            <option value="휴학">휴학</option>
                            <option value="이수">이수</option>
                            <option value="졸업">졸업</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button id="sendContent1">적용</button>
                
                </div>
        </div>
    </div>
    <%-- <script src="/resources/js/member/freelancer/enrollFreelancerPopup.js"></script> --%>

