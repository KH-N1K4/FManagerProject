

const suggestionTable = document.getElementById("suggestionTable");


document.getElementById("chooseBtn").addEventListener("click", e=>{

    // 확인을 클릭할 경우
    if(confirm("해당 제안을 채택하시겠습니까?")){

        $.ajax({

            url : '/member/myProject/myReceiveList',
            type : 'POST',
            data : { 'inputComment': inputComment,
                        'memberNo': memberNo},
            success : (result) => {

                if(result != null) {
                    document.getElementById("proposalStatus").remove();
                    const th = document.createElement("th");
                    const span = document.createElement("span");
                    th.setAttribute("class","tc");
                    // th.setAttribute("id","proposalStatus");
                    span.setAttribute("class","text");
                    // span.innerText = 'proposalAdoptStatus'; 
                    suggestionTable.append("th");
                    th.append("span");
                }

            },
            error:()=>{

                console.log("채택 실패");
            }

        })

    // 취소를 클릭할 경우
    } else{
        e.preventDefault();
    }

});
