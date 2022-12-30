
const inputImage = document.getElementsByClassName("inputImage");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

// [게시글 수정 - 기존에 존재하다가 삭제된 이미지의 순서를 기록]
const deleteSet = new Set(); // 순서 X, 중복 X (로또번호 박스로 생각)


// 미리보기와 관련된 모든 요소의 개수는 동일 (5개로)
// == 인덱스번호를 통해서 하나의 그룹을 지정할 수 있음
// inputImage[0]  preview[0]  deleteImage[0]

for (let i = 0; i < inputImage.length; i++) {

    // inputImage[i] 요소의 값이 변했을 때
    inputImage[i].addEventListener("change", event => {

        // event.target.files : 선택된 파일의 정보가 배열 형태로 반환
        if (event.target.files[0] != undefined) { // 선택된 파일이 있을 경우

            const reader = new FileReader(); // 파일 읽는 객체
            reader.readAsDataURL(event.target.files[0]);
            // 지정된 input type="file"의 파일 정보를 읽어와 URL 형태로 저장

            reader.onload = e => { // 파일을 다 읽어 온 후
                // e.target == reader
                // e.target.result == 읽어 온 파일 URL

                preview[i].setAttribute("src", e.target.result);

                // 미리보기가 추가됨 == 파일이 추가되었다.
                // == 삭제하면 안된다. == deleteSet에서 해당 순번을 제거
                deleteSet.delete(i);
            };


        } else { // 취소를 누를 경우
            // 미리보기 지우기
            preview[i].removeAttribute("src"); // src 속성 제거
        }
    });

    // 미리보기 삭제 버튼 클릭 시 동작 
    deleteImage[i].addEventListener("click", () => {

        // 미리보기 이미지가 존재할 때만 삭제 
        if (preview[i].getAttribute("src") != "") {

            // 미리보기 삭제 
            preview[i].removeAttribute("src");

            // input의 값을 ""으로 만들어서 삭제
            inputImage[i].value = "";

            // deleteSet에 삭제된 이미지의 순서(i)를 추가
            deleteSet.add(i);


        }

    })
}



const inquiryInsert =  document.getElementById("inquiryInsert");

if(inquiryInsert != null ){

    inquiryInsert.addEventListener("submit",function(event){

        const titleInput =  document.getElementById("titleInput");
        if (titleInput.value.trim().length == 0) {
            alertAndFocus(titleInput, "제목을 입력해주세요.");
            event.preventDefault();  
            return;
        }

        const contentInput =  document.getElementById("contentInput");
        if (contentInput.value.trim().length == 0) {
            alertAndFocus(contentInput, "문의 내용을 입력해주세요.");
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

const goToMain = document.getElementById("goToMain");

goToMain.addEventListener("click",()=>{

    location.href = "/";
});