

suggestionModal();

// 채택하기 모달
function suggestionModal(){

    const chooseBtn = document.querySelectorAll('.chooseBtn');
    const body = document.querySelector('body');
    const suggestionModal = document.querySelector('.suggestionModal');
    const suggestionModalClose = document.querySelector('.deleteBox');


    for(let cc of chooseBtn){
    
        cc.addEventListener("click",e=>{
                
            // modal 창에 show가 있으면 생성 없으면 삭제 
            suggestionModal.classList.toggle("show"); 

            if (suggestionModal.classList.contains('show')) {
                body.style.overflow = 'hidden';
            }

            console.log(e.target.nextElementSibling);

            document.getElementById("text1").innerText = e.target.nextElementSibling.innerText;
            document.getElementById("text2").innerText = e.target.nextElementSibling.nextElementSibling.innerText;
            document.getElementById("text3").innerText = e.target.nextElementSibling.nextElementSibling.nextElementSibling.innerText + "일";
            document.getElementById("text4").innerText = e.target.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerText + "원";

            suggestionModalClose.addEventListener("click", ()=>{

                if (suggestionModal.classList.contains('show')) {
                    suggestionModal.classList.remove('show');
                }
                if (!suggestionModal.classList.contains('show')) {
                    body.style.overflow = 'visible';
                }

            })
    
        });
        
    }
}

const projectRequestTitle = document.getElementById("projectRequestTitle").innerText;
const freelancerName = document.getElementById("freelancerName").innerText;
const projectWorkPeriod = document.getElementById("projectWorkPeriod").innerText;
const proposalPrice = document.getElementById("proposalPrice").innerText;
const projectRequestStatus = document.getElementById("projectRequestStatus").innerText;
const proposalEditNum = document.getElementById("proposalEditNum").innerText;
const freelancerNo = document.getElementById("freelancerNo").innerText;
const proposalNo = document.getElementById("proposalNo").innerText;
const memberEmail = document.getElementById("memberEmail").innerText;
const memberName = document.getElementById("memberName").innerText;
const memberTel = document.getElementById("memberTel").innerText;

// 구매하기 클릭 
// const title=document.getElementById("serviceContent").children[0].innerText;
// const cost=document.getElementById("serviceCost").children[0].innerText;
// const tradeRequest=document.getElementsByName("tradeRequest")[0];
// const serviceCost=document.getElementById("serviceCost").children[0];


    // function iamport(){
    //     var IMP = window.IMP; // 생략가능
    //     IMP.init('imp13226416'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    //     var msg;
        
    //     IMP.request_pay({
    //         pg : 'kakaopay',
    //         pay_method : 'card',
    //         merchant_uid : 'merchant_' + new Date().getTime(), // 구매번호 
    //         name : '프매니저'+projectRequestTitle, 
    //         amount : proposalPrice, //실제 결제되는 가격
    //         buyer_email : memberEmail,
    //         buyer_name : memberName,
    //         buyer_tel : memberTel,
    //         buyer_addr : '서울 강남구 도곡동',
    //         buyer_postcode : '123-456'
    //         //m_redirect_url : 'http://www.naver.com'
    //     }, function(rsp) {
    //         if ( rsp.success ) {

    //         alert("결제 성공"+serviceNo);
    //             //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
    //             $.ajax({
    //                 url: "/service/payComplete/", //cross-domain error가 발생하지 않도록 주의해주세요
    //                 type: 'POST',
    //                 dataType: 'json',
    //                 data: {
    //                     imp_uid : rsp.imp_uid,
    //                     "servicePrice":serviceCost.innerText



    //                 },success:(result)=>{

    //                 console.log(result);
    //                 if(result>0){
    //                     //성공시 이동할 페이지
    //                     location.href="/service/payComplete/"+result;
    //                 }
    //                 else{

    //                 }
    //                 }
                

    //             });
                
          
    //         } else {
    //             msg = '결제에 실패하였습니다.';
    //             msg += '에러내용 : ' + rsp.error_msg;
    //             //실패시 이동할 페이지
    //             location.href="<%=request.getContextPath()%>/order/payFail";
    //             alert(msg);
    //         }
    //     });
        
    // }


