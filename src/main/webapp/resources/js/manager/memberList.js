/* 회원 구분 select */
function selectChange(){
    const selectFreelancer = document.getElementById("selectFreelancer")
    const value = (selectFreelancer.options[selectFreelancer.selectedIndex].value);

    alert("프리랜서 여부 : "+value);
};