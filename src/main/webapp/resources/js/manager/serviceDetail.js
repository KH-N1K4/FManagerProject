const goToListbtn = document.getElementById("goToListbtn");

goToListbtn.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/manager/serviceList" + queryString;

        location.href = url;

});