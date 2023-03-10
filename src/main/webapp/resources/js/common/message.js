// 선택한 채팅방 번호를 저장하기 위한 전역 변수
let selectChatRoomNo;
let selectClientNo;
let selectClientNickName;
let selectClientProfile;
let selectClientGrade;
let selectClientFreeContactTime;

// sockjs를 이용한 WebSocket 구현

// 로그인이 되어 있을 경우에만
// /chattingSock 이라는 요청 주소로 통신할 수 있는  WebSocket 객체 생성
let chattingSock;

//메세지창 들어가기전에 입력 누르면 메세지창을 눌러주세요 경고창 나오게
let checkAddRoomVar = false;


if(loginMemberNo != ""){
  console.log(loginMemberNo);
	chattingSock = new SockJS("/chattingSock");
}

$(document).ready(function(){
document.getElementById('my_modal').style.display = 'none';
});
// 문서 로딩 완료 후 수행할 기능
document.addEventListener("DOMContentLoaded", ()=>{
	
	// 채팅방 목록에 클릭 이벤트 추가
	roomListAddEvent(); 

	// 메세지 버튼에 이벤트 추가
	send.addEventListener("click", sendMessage);


	if(tempNo != ""){
		//selectChatRoomNo = tempNo;

		const chattingItemList = document.getElementsByClassName("chatting-item");

		for(let item of chattingItemList){
		
			// 클릭한 채팅방의 번호 얻어오기
			const id = item.getAttribute("id");
			const arr = id.split("-");

			if(arr[0] == tempNo){
				item.click();
				break;
			}
		}
	}
})




// 채팅 메세지 영역
const display = document.getElementsByClassName("display-chatting")[0];


// 채팅방 목록에 이벤트를 추가하는 함수 문제 없이 실행 완료!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
const roomListAddEvent = () => {
	const chattingItemList = document.getElementsByClassName("chatting-item");
	
	for(let item of chattingItemList){
		item.addEventListener("click", e => {
			checkAddRoomVar= true;// 입력버튼 활성화
			// 클릭한 채팅방의 번호 얻어오기
			const id = item.getAttribute("id");
			const arr = id.split("-");
			// 전역변수에 채팅방 번호, 상대 번호, 상태 프로필, 상대 이름 저장
			selectChatRoomNo = arr[0]
			selectClientNo = arr[1];
			selectClientProfile = item.children[0].children[0].children[0].getAttribute("src");
      console.log("selectClientProfile:"+selectClientProfile)
			selectClientNickName = item.children[0].children[1].children[0].innerText;
      console.log("selectClientNickName:"+selectClientNickName)

			if(item.children[1].children[0].children[1] != undefined){
				item.children[1].children[0].children[1].remove();
			}

      
			// 모든 채팅방에서 select 클래스를 제거
			for(let it of chattingItemList) it.classList.remove("select")
	
			// 현재 클릭한 채팅방에 select 클래스 추가
			item.classList.add("select");

      /* 채팅 상대방 정보보기 */
      const expert = document.getElementsByClassName('expert')[0];
      document.getElementsByClassName('outbtn')[0].classList.add("show");
			expert.children[0].innerHTML='';
			const img10 = document.createElement("img");
			expert.children[0].append(img10);
			expert.children[0].children[0].setAttribute("src","/resources/images/siren.png");
			expert.children[1].children[0].style.display ="block"
      expert.children[1].children[0].setAttribute("src",selectClientProfile);
      expert.children[2].children[0].innerText=selectClientNickName;
      selectClientGrade = item.children[1].children[1].id;
      selectClientFreeContactTime = item.children[1].children[2].id;
      if(selectClientGrade !=''){
        expert.children[3].children[0].innerText='연락 가능한 시간';
        expert.children[3].children[1].innerText=selectClientFreeContactTime;
        expert.children[3].children[3].innerText='회원 등급';
        expert.children[3].children[4].innerText=selectClientGrade;
      }else{
        expert.children[3].children[0].innerText='';
        expert.children[3].children[1].innerText='';
        expert.children[3].children[3].innerText='';
        expert.children[3].children[4].innerText='';
      }
      expert.children[5].id = selectChatRoomNo;
      expert.children[5].value = selectClientNo;
      /* 채팅 상대방 정보보기 */
      
			// 비동기로 메세지 목록을 조회하는 함수 호출
			selectChattingFn();
			document.getElementById('chatBox').scrollTop = document.getElementById('chatBox').scrollHeight; // 스크롤 제일 밑으로
		});
	}
}
var arrDayList = new Array();
var num =0;
// 비동기로 메세지 목록을 조회하는 함수
const selectChattingFn = () => {
	$.ajax({
		url : "/chatting/selectMessage",
		data : {"chatRoomNo" : selectChatRoomNo, "memberNo" : loginMemberNo},
		dataType : "JSON",
		success : messageList => {
			console.log(messageList);

			// <ul class="display-chatting">
			const ul = document.querySelector(".display-chatting");

			ul.innerHTML = ""; // 이전 내용 지우기
      var booleanDay = false;
      arrDayList = new Array();
      num =0;
			// 메세지 만들어서 출력하기
			for(let msg of messageList){

        const arrDay =msg.sendTime.split(" ");

        
        const liDay = document.createElement("li");
        const spanDay = document.createElement("span");
        spanDay.innerText = arrDay[0];
        liDay.classList.add("Daylist");
        liDay.append(spanDay);

        arrDayList[num] = arrDay[0];
        if(num !=0){
          if(arrDayList[num] !=arrDayList[num-1]){
            booleanDay = false;
          }
        }
        num = num+1;
        if(booleanDay == false){
          ul.append(liDay);
          booleanDay = true;
        }

				//<li>,  <li class="my-chat">
				const li = document.createElement("li");

				// 보낸 시간
				const span = document.createElement("span");
				span.classList.add("chatDate");
				span.innerText = arrDay[1];//msg.sendTime;

				// 메세지 내용
				const p = document.createElement("p");
				const imgContent = document.createElement("img");
				const aContent =document.createElement("a");
				const regEx = /.+.(jpg|png|gif|bmp|JPG|PNG|BMP|GIF|jfif)/;
				const regEx2 = /.+.(xls|xlsx|txt|html|htm|pdf|mp4|mpeg|mpg|avi|pptx|hwp|docx|doc|ppt)/;
				if(regEx.test(msg.chatMessage)){
					imgContent.classList.add("imgContent");
					imgContent.setAttribute("src", msg.chatMessage);
				}else{
					if(regEx2.test(msg.chatMessage)){
						aContent.classList.add("aContent");
						aContent.setAttribute("href", msg.chatMessage);

						var arSplitUrl = msg.chatMessage.split("/");
						var nArLength = arSplitUrl.length;
						var arFileName = arSplitUrl[nArLength-1];   // 나누어진 배열의 맨 끝이 파일명이다
						//var arSplitFileName = arFileName.split(".");   // 파일명을 다시 "." 로 나누면 파일이름과 확장자로 나뉜다
						aContent.innerHTML="파일 다운:" + arFileName;
					}else{
						p.classList.add("chat");
						p.innerHTML = msg.chatMessage; // br태그 해석을 위해 innerHTML
					}
					
				}


				// 내가 작성한 메세지인 경우
				if(loginMemberNo == msg.senderNo){ 
					li.classList.add("my-chat");
					li.append(span);
					if(regEx.test(msg.chatMessage)){
						li.append(imgContent);
					}else{
						if(regEx2.test(msg.chatMessage)){
							li.append(aContent);
						}else{
							li.append(p);
						}
					}
					
					
				}else{ // 상대가 작성한 메세지인 경우dateBox
					li.classList.add("target-chat");

					// 상대 프로필
					// <img src="/resources/images/프로필.PNG">
					const img = document.createElement("img");
					img.setAttribute("src", selectClientProfile);
					
					const div = document.createElement("div");

					// 상대 이름
					const b = document.createElement("b");
					b.innerText = selectClientNickName; // 전역변수

					const br = document.createElement("br");

					div.append(b, br);
					const dateBox = document.createElement("div");
					dateBox.classList.add("target-dateBox");
					if(regEx.test(msg.chatMessage)){
						dateBox.append(imgContent);
					}else{
						if(regEx2.test(msg.chatMessage)){
							dateBox.append(aContent);
						}else{
							dateBox.append(p);
						}
						
					}
					dateBox.append(span);
					div.append(dateBox);
					li.append(img,div);

				}

				ul.append(li);

			
			}
			document.getElementById('chatBox').scrollTop = document.getElementById('chatBox').scrollHeight; // 스크롤 제일 밑으로

		},
		error : () => {console.log("에러");}
	})
}



// 비동기로 채팅방 목록 조회   
const selectRoomList = () => {
	$.ajax({
		url: "/chatting/roomList",
		data : {"memberNo" : loginMemberNo},
		dataType : "JSON",
		success : roomList => {
			console.log(roomList);
			// 채팅방 리스트
			const chattingList = document.querySelector(".chatting-list");

			// 채팅방 리스트 지우기
			chattingList.innerHTML = "";

			for(let room of roomList){
				const li = document.createElement("li");
				li.classList.add("chatting-item");
				li.classList.add("chattingList");
				li.setAttribute("id", room.chatRoomNo + "-" + room.clientNo);

				if(room.chatRoomNo == selectChatRoomNo){
					li.classList.add("select");
				}

				// item-header 부분
				const itemHeader = document.createElement("div");
				itemHeader.classList.add("item-header");
        const listProfileDiv = document.createElement("div");

				const listProfile = document.createElement("img");
				listProfile.classList.add("list-profile");

				if(room.clientProfile == undefined)	
					listProfile.setAttribute("src", "/resources/images/프로필.PNG");
				else								
					listProfile.setAttribute("src", room.clientProfile);
        
        const infoDiv = document.createElement("div");
        infoDiv.setAttribute("id","info");
        
        const targetName = document.createElement("span");
				targetName.classList.add("target-name");
				targetName.innerText = room.clientNickName;
				const br = document.createElement("br");
				const recentSendTime = document.createElement("span");
				recentSendTime.classList.add("recent-send-time");
				recentSendTime.innerText = room.sendTime;
				
				infoDiv.append(targetName, br,recentSendTime);

        itemHeader.append(listProfileDiv);
        listProfileDiv.append(listProfile);
				itemHeader.append(infoDiv);//확인 완료

				// item-body 부분
				const itemBody = document.createElement("div");
				itemBody.classList.add("item-body");

        const itemContent = document.createElement("div");
        itemBody.classList.add("item-content");
				
				const recentMessage = document.createElement("p");
				recentMessage.classList.add("recent-message");

				if(room.lastMessage != undefined){
					const regEx1 = /.+.(jpg|png|gif|bmp|JPG|PNG|BMP|GIF|jfif)/;
					const regEx2 = /.+.(xls|xlsx|txt|html|htm|pdf|mp4|mpeg|mpg|avi|pptx|hwp|docx|doc|ppt)/;
					console.log(regEx1.test(room.lastMessage));
					if(regEx1.test(room.lastMessage)){
						recentMessage.innerHTML = '사진';
						console.log('사진');
					}else{
						if(regEx2.test(room.lastMessage)){
							recentMessage.innerHTML = '파일';
						}else{
							recentMessage.innerHTML = room.lastMessage;
						}
						
					}
				}
				
				itemContent.append(recentMessage);

				itemBody.append(itemContent);

				// 현재 채팅방을 보고있는게 아니고 읽지 않은 개수가 0개 이상인 경우 -> 읽지 않은 메세지 개수 출력
				if(room.notReadCount > 0 && room.chatRoomNo != selectChatRoomNo ){
				// if(room.chatRoomNo != selectChatRoomNo ){
					const notReadCount = document.createElement("p");
					notReadCount.classList.add("not-read-count");
					notReadCount.innerText = room.notReadCount;
					itemContent.append(notReadCount);
				}else{
					// 현재 채팅방을 보고있는 경우
					// 비동기로 해당 채팅방 글을 읽음으로 표시
					$.ajax({
						url : "/chatting/updateReadFlag",
						data : {"chatRoomNo" : selectChatRoomNo, "memberNo" : loginMemberNo},
						success : result => {
							console.log(result);
						}
					})
				}
				
        const inputGrade = document.createElement("input");
        inputGrade.setAttribute("type","hidden");
        inputGrade.setAttribute("id",room.clientGrade);
        const freeContactTime = document.createElement("input");
        freeContactTime.setAttribute("type","hidden");
        freeContactTime.setAttribute("id",room.clientFreeContactTime);
        itemBody.append(inputGrade);
        itemBody.append(freeContactTime);

				li.append(itemHeader, itemBody);
				chattingList.append(li);
			}

			roomListAddEvent();
		}
	})
}


// 채팅 입력
const send = document.getElementById("send");

	
const sendMessage = () => {
		const inputChatting = document.getElementById("inputChatting");
		if(checkAddRoomVar){
			if (inputChatting.value.trim().length == 0) {
				alert("채팅을 입력해주세요.");
				inputChatting.value = "";
			} else {
				var obj = {
					"senderNo": loginMemberNo,
					"clientNo": selectClientNo,
					"chatRoomNo": selectChatRoomNo,
					"chatMessage": inputChatting.value,
				};
				console.log(obj)

				// JSON.stringify() : 자바스크립트 객체를 JSON 문자열로 변환
				chattingSock.send(JSON.stringify(obj));

				inputChatting.value = "";
			}
		}else{
			alert("채팅방을 먼저 선택해주세요.");
		}
}

	// 엔터 == 제출
	// 쉬프트 + 엔터 == 줄바꿈
	inputChatting.addEventListener("keyup", e => {
		if(e.key == "Enter"){ 
			if (!e.shiftKey) {
				sendMessage();
			}
		}
	})






// WebSocket 객체 chattingSock이 서버로 부터 메세지를 통지 받으면 자동으로 실행될 콜백 함수
chattingSock.onmessage = function(e) {
	// 메소드를 통해 전달받은 객체값을 JSON객체로 변환해서 msg 변수에 저장.
	const msg = JSON.parse(e.data);
	console.log(msg);
	console.log(msg+"SSSSSSSSSS");
	// 현재 메세지를 받은 채팅방을 보고 있다면
	if(selectChatRoomNo == msg.chatRoomNo){
		console.log(msg+"SSSSSSSSSS22222222");
		const ul = document.querySelector(".display-chatting");

    const arrDay =msg.sendTime.split(" ");
    const liDay = document.createElement("li");
    const spanDay = document.createElement("span");
    spanDay.innerText = arrDay[0];
    liDay.classList.add("Daylist");
    liDay.append(spanDay);

    arrDayList[num] = arrDay[0];
    if(num !=0){
      if(arrDayList[num] !=arrDayList[num-1]){
          ul.append(liDay);
      }
    }
		if(num ==0){
			ul.append(liDay);
		}
    num = num+1;
	
		// 메세지 만들어서 출력하기
		//<li>,  <li class="my-chat">
		const li = document.createElement("li");
	
		// 보낸 시간
		const span = document.createElement("span");
		span.classList.add("chatDate");
		span.innerText = arrDay[1];//msg.sendTime;
	
		// 메세지 내용
		const p = document.createElement("p");
		const imgContent = document.createElement("img");
		const aContent =document.createElement("a");
		const regEx = /.+.(jpg|png|gif|bmp|JPG|PNG|BMP|GIF|jfif)/;
		const regEx2 = /.+.(xls|xlsx|txt|html|htm|pdf|mp4|mpeg|mpg|avi|pptx|hwp|docx|doc|ppt)/;
		if(regEx.test(msg.chatMessage)){
			imgContent.classList.add("imgContent");
			imgContent.setAttribute("src", msg.chatMessage);
		}else{
			if(regEx2.test(msg.chatMessage)){
				aContent.classList.add("aContent");
				aContent.setAttribute("href", msg.chatMessage);

				var arSplitUrl = msg.chatMessage.split("/");
				var nArLength = arSplitUrl.length;
				var arFileName = arSplitUrl[nArLength-1];   // 나누어진 배열의 맨 끝이 파일명이다
				//var arSplitFileName = arFileName.split(".");   // 파일명을 다시 "." 로 나누면 파일이름과 확장자로 나뉜다
				aContent.innerHTML="파일 다운:" + arFileName;
			}else{
				p.classList.add("chat");
				p.innerHTML = msg.chatMessage; // br태그 해석을 위해 innerHTML
			}
			
		}

	
		// 내가 작성한 메세지인 경우
		if(loginMemberNo == msg.senderNo){ 
			li.classList.add("my-chat");
			li.append(span);
			if(regEx.test(msg.chatMessage)){
				li.append(imgContent);
			}else{

				if(regEx2.test(msg.chatMessage)){
					li.append(aContent);
				}else{
					li.append(p);
				}
				
			}
			
		}else{ // 상대가 작성한 메세지인 경우
			li.classList.add("target-chat");
	
			// 상대 프로필
			// <img src="/resources/images/프로필.PNG">
			const img = document.createElement("img");
			img.setAttribute("src", selectClientProfile);
			
			const div = document.createElement("div");
	
			// 상대 이름
			const b = document.createElement("b");
			b.innerText = selectClientNickName; // 전역변수
	
			const br = document.createElement("br");
	
			div.append(b, br);
			const dateBox = document.createElement("div");
			dateBox.classList.add("target-dateBox");
			if(regEx.test(msg.chatMessage)){
				dateBox.append(imgContent);
			}else{
				if(regEx2.test(msg.chatMessage)){
					dateBox.append(aContent);
				}else{
					dateBox.append(p);
				}
						
			}
			dateBox.append(span);
			div.append(dateBox);
			li.append(img,div);
	
		}
	
		ul.append(li)
		
	}
	document.getElementById('chatBox').scrollTop = document.getElementById('chatBox').scrollHeight;// 스크롤 제일 밑으로
	console.log(selectClientNo);
	console.log(loginMemberNo);
	
	selectRoomList();
}

//나가기 버튼 누르면 실행-------------------------------------------------------------------------
$('#outbtnID').click(function(){
	if(confirm('채팅방을 나가시면 내용이 다 사라집니다. \n정말 나가시겠습니까?')){

	}else{
		return; 
	}
	checkAddRoomVar =false;
  $.ajax({
    url : "/chatting/updateOutFL",
    data : {"chatRoomNo" : selectChatRoomNo, "memberNo" : loginMemberNo},
    success : result => {
      console.log(result);

      const ul = document.querySelector(".display-chatting");
			ul.innerHTML = "";
      const expert = document.getElementsByClassName('expert')[0];
      document.getElementsByClassName('outbtn')[0].classList.remove("show"); 

			expert.children[0].innerHTML='';
      expert.children[1].children[0].setAttribute("src","");
			expert.children[1].children[0].style.display ="none"
      expert.children[2].children[0].innerText="";
      
      expert.children[3].children[0].innerText='';
      expert.children[3].children[1].innerText='';
      expert.children[3].children[3].innerText='';
      expert.children[3].children[4].innerText='';
    
      expert.children[5].id = '';
      expert.children[5].value = '';
      document.getElementById(selectChatRoomNo+"-"+selectClientNo).remove();
    },
    error: () => {
        console.log("나가기 실패")
    }
  })
});


	
document.getElementById('img0').addEventListener("change", event => {
		if(checkAddRoomVar){
			// event.target.files : 선택된 파일의 정보가 배열 형태로 반환
			if (event.target.files[0] != undefined) { // 선택된 파일이 있을 경우

					const reader = new FileReader(); // 파일을 읽는 객체

					reader.readAsDataURL(event.target.files[0]);
					// 지정된 input type="file"의 파일을 읽어와
					// URL 형태로 저장
					console.log(event.target.files[0])
					reader.onload = e => { // 파일을 다 읽어온 후
							// e.target == reader
							// e.target.result == 읽어온 파일 URL
							/* document.getElementsByClassName('preview')[0].innerText =event.target.files[0].name; */

							const formData = new FormData();
							formData.append("img0", event.target.files[0]);

							$.ajax({
						
								url: "/chatting/updatefiles",
								data : formData,
								type: "POST", 
								processData : false,
								contentType: false,
								cache: false,
								dataType: "JSON",
								success : rename => {
									console.log(rename);
									var obj = {
										"senderNo": loginMemberNo,
										"clientNo": selectClientNo,
										"chatRoomNo": selectChatRoomNo,
										"chatMessage": rename
									};
									console.log(obj)
							
									// JSON.stringify() : 자바스크립트 객체를 JSON 문자열로 변환
									chattingSock.send(JSON.stringify(obj));
								}


							});
							

							
					}

			} else { // 취소를 누를 경우
					// 미리보기 지우기
					document.getElementsByClassName('preview')[0].innerText ='';
			}
		}else{
			alert("메세지창을 먼저 선택해주세요.");
		}
});

/* 신고하기 */
function modal(id) {
	var zIndex = 9999;
	var modal = document.getElementById(id);

	// 모달 div 뒤에 희끄무레한 레이어
	/* var bg = document.createElement('div');
	bg.setStyle({
			position: 'fixed',
			zIndex: zIndex,
			left: '0px',
			top: '0px',
			width: '100%',
			height: '100%',
			overflow: 'auto',
			// 레이어 색갈은 여기서 바꾸면 됨
			backgroundColor: 'rgba(0,0,0,0.4)'
	});
	document.body.append(bg); */

	// 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
	/* modal.querySelector('.modal_close_btn').addEventListener('click', function() {
			//bg.remove();
			modal.style.display = 'none';
	});
 */
	modal.setStyle({
			position: 'fixed',
			display: 'block',
			backgroundColor: 'white',
			boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

			// 시꺼먼 레이어 보다 한칸 위에 보이기
			zIndex: zIndex + 1,

			// div center 정렬
			top: '50%',
			left: '50%',
			width: '600px',
			height: '650px',
			transform: 'translate(-50%, -50%)',
			msTransform: 'translate(-50%, -50%)',
			webkitTransform: 'translate(-50%, -50%)'
	});
}

// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function(styles) {
	for (var k in styles) this.style[k] = styles[k];
	return this;
};


/* document.getElementById('chat_ifram').contentWindow.document.getElementById("reportModal_close").addEventListener('click', function() {
	//bg.remove();
	modal.style.display = 'none';
}); */

const draggable = ($target) => {
  let isPress = false,
      prevPosX = 0,
      prevPosY = 0;
  
  $target.onmousedown = start;
  $target.onmouseup = end;
    
  // 상위 영역
  window.onmousemove = move;
 
  function start(e) {
    prevPosX = e.clientX;
    prevPosY = e.clientY;

    isPress = true;
  }

  function move(e) {
    if (!isPress) return;

    const posX = prevPosX - e.clientX; 
    const posY = prevPosY - e.clientY; 
    
    prevPosX = e.clientX; 
    prevPosY = e.clientY;
    
    $target.style.left = ($target.offsetLeft - posX) + "px";
    $target.style.top = ($target.offsetTop - posY) + "px";
  }

  function end() {
    isPress = false;
  }
}

window.onload = () => {
  const $target = document.querySelector(".draggable");
  
  draggable($target);
}


$(document).on("click",".reportBtnClass",function(){ ///WEB-INF/views/common/header_ver1.jsp
	modal('my_modal');
	const exportVar = document.getElementsByClassName('expert')[0];
	const iframeVar = document.getElementById('chat_iframe');
	iframeVar.contentDocument.getElementById('reportedProfile').setAttribute("src",exportVar.children[1].children[0].src);
	iframeVar.contentDocument.getElementById('reportedName').innerText = exportVar.children[2].children[0].innerText;
	iframeVar.contentDocument.getElementById('memberName').value = loginMemberNickName;
	iframeVar.contentDocument.getElementById('reportMemberNo').value =loginMemberNo;
	iframeVar.contentDocument.getElementById('reportedMemberNo').value =selectClientNo;
});
