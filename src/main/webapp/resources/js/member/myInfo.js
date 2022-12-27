const profileImage=document.getElementById("profile-image");
const deleteImage=document.getElementById("delete-image");
const imageInput=document.getElementById("image-input");

// 초기 프로필 이지 상태를 저장하는 변수
//(true : 업로드된 이미지 있음, false : 기본 이미지)
let initCheck;

// 이미지가 업로드 되었거나 삭제되었음을 나타내는 변수 
// -1 : 초기값(취소), 0 : 프로필 삭제(x버튼), 1 : 새 이미지 업로드
let deleteCheck=-1;


const originalImage=profileImage.getAttribute("src");

// 프로필 수정 화면일 경우
if(imageInput!=null){

    // 해당 화면 진입시 프로필 이미지 상태를 저장(initCheck)
    if(profileImage.getAttribute("src")=="/resources/images/루피.jpg"){
        initCheck=false;
    }else{
        initCheck=true;
    }

    // 이미지가 선택되었을 때 미리보기 

    // * input type="file" 요소는 값이 없을 때 ''(빈칸)
    // * input type="file" 요소는 이전에 선택한 파일이 있어도 취소하면 다시 ''(빈칸)
    // * input type="file" 요소로 파일을 선택하면 change 이벤트가 발생한다.


    imageInput.addEventListener("change",e=>{
        // 선택된 파일의 목록
        console.log(e.target.files); 
        console.log(e.target.files[0]); 

        // 선택된 파일이 있을 경우 
        if(e.target.files[0]!=undefined){

            const reader=new FileReader();
            // FileReader
            // - 웹 애플리케이션이 
            // 비동기적으로 데이터를 읽기 위하여 
            // 읽을 파일을 가리키는 File 객체 
            // - 읽어들이 파일을 사용자 컴퓨터에 저장할 수 있다. 
    
            reader.readAsDataURL(e.target.files[0]);
            // FileReader.readAsDataURL("파일정보")
            // -> 지정된 파일을 읽기 시작함
    
            // FileReader.onload : 파일 읽기가 완료 되었을 때 
            reader.onload = event => {
                // console.log(event.target);
                // event.target.result : 읽어진 이미지 결과(실제 이미지 파일)의 경로 
                
                // img 태그의 src 속성으로 읽은 이미지 파일 경로 추가
                // == 이미지 미리보기
                profileImage.setAttribute("src",event.target.result);

                deleteCheck=1;
            }

        }else{ // 취소가 눌러진 경우 

            // 초기 이미지로 다시 변경
            profileImage.setAttribute("src",originalImage);
            deleteCheck=-1;
        }

    })
    
    // x 버튼이 클릭됐을 경우 -> 기본이미지로 변경
    deleteImage.addEventListener("click",event=>{

       
        profileImage.setAttribute("src","/resources/images/루피.png");
        imageInput.value="";
        deleteCheck=0;

    })
}

function profileValidate(){
    // 이미지가 없음 -> 있음
    if(!initCheck && deleteCheck==1 ){
        return true;
    }

    // 이미지가 있음 -> 없음(x버튼)
    if(initCheck && deleteCheck==0 ){
        return true;
    }

    // 이미지가 있음 -> 있음(새로운 이미지 업로드)
    if(initCheck && deleteCheck==1 ){
        return true;
    }

    // alert("이미지 변경 후 클릭하세요");
    return true;
    // 그니까 false 가 나올 때 프로필 변경 없이 정보 수정만 되게 어떻게 하지??????

    
}



// 변수명.key 또는 변수명["key"]를 이용하면 객체 속성 접근 가능
const checkObj={
                "memberNickname":true,
                "memberTel":true
            };



// 내정보 수정 양식이 제출 되었을 때 
document.getElementsByName("myPage-frm")[0].addEventListener("submit",function(event){


   
    for(key in checkObj){
        let str;

        if(!checkObj[key]){
            switch(key){
                case "memberNickname": str="닉네임이 유효하지 않습니다."; break;
                case "memberTel": str="전화번호 유효하지 않습니다."; break;
            }

            alert(str); // 대화상자 출력 
            // 유효하지 않은 입력으로 포커스 이동 
            document.getElementById(key).focus();
            
            event.preventDefault(); // 제출 이벤트 제거 
            return; // 함수 종료
        }
    }

})

// 닉네임 유효성 검사
const memberNickname=document.getElementById("memberNickname");
const originNickname=memberNickname.value;
const nickMessage=document.getElementById("nickMessage");

memberNickname.addEventListener("input",function(){

    if(memberNickname.value==originNickname){
        nickMessage.innerText="한글, 영어, 숫자로만 2~10글자";
        nickMessage.classList.remove("error","confirm");
        // memberNickname.value="";

        checkObj.memberNickname=true;
        // return;
    }

    const reqEx=/^[가-힣\w]{2,10}$/;

    if(reqEx.test(memberNickname.value)){// 유효한 경우 
        // ** 닉네임 중복 검사 코드 추가 예정 **
        
        const param={"memberNickname":memberNickname.value};

        $.ajax({
            url:'/nicknameDupCheck',
            data:param,
            type:"GET", // type 미작성시 기본값 GET
            success:(res)=>{
                // 매개변수 res == 서버 비동기 통신 응답 데이터


                // console.log("res : " +res);
                if(res==0){ // 중복 아님
                    nickMessage.innerText="사용 가능한 닉네임 입니다.";
                    nickMessage.classList.add("confirm");
                    nickMessage.classList.remove("error");
                    checkObj.memberNickname=true;
                }else if(memberNickname.value==originNickname){
                    nickMessage.innerText="한글, 영어, 숫자로만 2~10글자";
                    nickMessage.classList.add("confirm");
                    nickMessage.classList.remove("error");
                    checkObj.memberNickname=true;
                }else{
                    nickMessage.innerText="이미 사용중인 닉네임입니다.";
                    nickMessage.classList.add("error");
                    nickMessage.classList.remove("confirm");
                    checkObj.memberNickname=false;
                }
            },
            error:()=>{
                console.log("닉네임 중복 검사 실패");
            },
            complete:tempFn
        });
        
    }else{
        nickMessage.innerText="닉네임 형식이 유효하지 않습니다.";
        nickMessage.classList.add("error");
        nickMessage.classList.remove("confirm");

        checkObj.memberNickname=false;
    }

   

});

function tempFn(){
    console.log("닉네임 검사 완료");
};

// 전화번호 유효성 검사 
const memberTel = document.getElementById("memberTel");
const originTel=memberTel.value;
const telMessage=document.getElementById("telMessage");

memberTel.addEventListener("input",function(){
    // 문자가 입력되지 않은 경우 
    if(memberTel.value==originTel){
        telMessage.innerText="전화번호를 입력해주세요(- 제외)";
        telMessage.classList.remove("confirm","error");
        checkObj.memberTel=true;
        // return;
    }else{
        checkObj.memberTel=false;
    }

    // 전화번호 정규 표현식 검사
    const regEx=/^0(1[01679]|2|[3-6][1-5]|70)[1-9]\d{2,3}\d{4}$/;

    if(regEx.test(memberTel.value)){ // 유효한 경우
        telMessage.innerText="유효한 전화번호 형식입니다";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel=true;
    }else if(memberTel.value==originTel){
        telMessage.innerText="전화번호를 입력해주세요(- 제외)";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel=true;
    }else{
        telMessage.innerText="전화번호 형식이 유효하지 않습니다";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");

        checkObj.memberTel=false;
    }
});

// 변하지 않는 경우도 추가하기!