
const goToList = document.getElementById("goToListbtn");

goToList.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/userInquiryList" + queryString;

        location.href = url;

});


const division = document.getElementById("division");

division.addEventListener("change",()=>{

        

});