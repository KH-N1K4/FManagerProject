
const goToList = document.getElementById("goToList");

goToList.addEventListener("click",() => {

        const pathname = location.pathname;
        const queryString = location.search;
        const url = pathname.substring(0, pathname.lastIndexOf("/")) + queryString;

        location.href = url;
});