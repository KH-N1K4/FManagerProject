const goToListbtn = document.getElementById("goToListbtn");

goToListbtn.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/manager/projectRequestList" + queryString;

        location.href = url;

});

