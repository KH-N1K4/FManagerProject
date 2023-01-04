const logoutBtn = document.querySelector(".logout");
if(logoutBtn!=null){
    logoutBtn.addEventListener("click",()=>{
        location.search="";
    });
}