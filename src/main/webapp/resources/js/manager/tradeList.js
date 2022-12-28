

/* 작업 상태 구분 */
function selectChange(){

    const selectWorkStatus = document.getElementById("selectWorkStatus")
    const status = (selectWorkStatus.options[selectWorkStatus.selectedIndex].value);
    const tradeListTable = document.querySelector('#manager-buy-table');
    const pagination = document.querySelector(".pagination");

}