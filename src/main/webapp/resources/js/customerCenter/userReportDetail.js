
const goToList = document.getElementById("goToListbtn");

goToList.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/userInquiryList/userReportList/" + queryString;

        location.href = url;

});

