<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


    <link rel="stylesheet" href="/resources/css/freelancer/portfolioDetail.css">






    <div class="modal_body">
        <button class="modal_close2">x</button>

        <div id="writerInfo">
            <div id="writerPhoto">
            <img src="${portfolio.memberProfile}" alt="">
            </div>
            <div id="writerName">${portfolio.memberName}</div>
        </div>

        <div id="portfolioSection">
            <div id="portfolioTitle">${portfolio.portfolioTitle}</div>
            <div id="portfolioContent">${portfolio.portfolioContent}</div>


            <div class="portfolioPhoto">
            <img src="${portfolio.portfolioFilePath}" alt="">
            </div>

        </div>



    </div>
    
