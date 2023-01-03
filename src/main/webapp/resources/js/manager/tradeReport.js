
const goToListbtn = document.getElementById("goToListbtn");

goToListbtn.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/manager/tradeReportList" + queryString;

        location.href = url;

});



