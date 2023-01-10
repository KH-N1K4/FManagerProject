const projectRequestfrm =  document.getElementById("projectRequestfrm");

if(projectRequestfrm != null ){

    projectRequestfrm.addEventListener("submit",function(event){

        const srchOption1 =  document.getElementById("srchOption1");
        if (srchOption1.value.trim().length == 0) {
            alertAndFocus(srchOption1, "카테고리를 선택해주세요.");
            event.preventDefault();  
            return;
        }
        const Title =  document.getElementById("projectRequestTitle");
        if (Title.value.trim().length == 0) {
            alertAndFocus(Title, "제목을 입력해주세요.");
            event.preventDefault();  
            return;
        }

        const Summary =  document.getElementById("projectRequestSummary");
        if (Summary.value.trim().length == 0) {
            alertAndFocus(Summary, "의뢰 한줄 요약을 입력해주세요.");
            event.preventDefault();  
            return;
        }

        const Content =  document.getElementById("projectRequestContent");
        if (Content.value.trim().length == 0) {
            alertAndFocus(Content, "의뢰 사항을 입력해주세요.");
            event.preventDefault();  
            return;
        }
        
        const File =  document.getElementById("myProjectFile");
        if (File.value == 0) {
            alertAndFocus(File, "첨부파일을 선택해주세요.");
            event.preventDefault();  
            return;
        }
        const Budget =  document.getElementById("budget");
        if (Budget.value == 0) {
            alertAndFocus(Budget, "예산을 입력해주세요.");
            event.preventDefault();  
            return;
        }
        const recruitEndDateInput =  document.getElementById("recruitEndDateInput");
        if (recruitEndDateInput.value.trim().length == 0) {
            alertAndFocus(recruitEndDateInput, "모집마감일을 선택해주세요.");
            event.preventDefault();  
            return;
        }
        const workEndDateInput =  document.getElementById("workEndDateInput");
        if (workEndDateInput.value.trim().length == 0) {
            alertAndFocus(workEndDateInput, "작업마감일을 선택해주세요.");
            event.preventDefault();  
            return;
        }
        const dateOption =  document.getElementById("dateOption");
        if (dateOption.value.trim().length == 0) {
            alertAndFocus(dateOption, "작업기간을 선택해주세요.");
            event.preventDefault();  
            return;
        }
    })


    // 경고창 출력 + 포커스 이동 + 값 삭제 
    function alertAndFocus(input, str) {
        alert(str);
        input.focus();
        input.value;
    }


}



/* 카테고리 */
$(function () {
    $('select[name="mainCategoryNo"] ').on('change', function () {
        let optionType = $("select[name='thirdCategoryNo']");
        optionType.empty();


        $("option:selected", this).each(function () {
            var selectValue = $(this).val(); //main category 에서 선택한 값
            optionType.append("<option value='' selected='' disabled>전체</option>");
            if (selectValue == 0) {
                for (var i = 0; i < listSize; i++) {
                    optionType.append("<option value='" + list[i].thirdCategoryNo + "'>" + list[i].thirdCategoryName + "</option>");
                }
            } else {

                for (var i = 0; i < listSize; i++) {
                    console.log(list[i]);
                    if (selectValue == list[i].mainCategoryNo) {
                        optionType.append("<option value='" + list[i].thirdCategoryNo + "'>" + list[i].thirdCategoryName + "</option>");

                    }
                }

            }
        });

    });
});


var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("recruitEndDateInput").setAttribute("min", today); //min날짜를 today로 하면 어제 날짜부터 선택 불가
document.getElementById("workEndDateInput").setAttribute("min", today);