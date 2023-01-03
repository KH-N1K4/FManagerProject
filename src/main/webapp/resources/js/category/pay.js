

const title=document.getElementById("serviceContent").children[0].innerText;
const cost=document.getElementById("serviceCost").children[0].innerText;
const tradeRequest=document.getElementsByName("tradeRequest")[0];


      function iamport(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp13226416'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(), // 구매번호 
            name : '프매니저'+title, 
            amount : cost, //실제 결제되는 가격
            buyer_email : memberEmail,
            buyer_name : '구매자이름',
            buyer_tel : '010-1234-5678',
            buyer_addr : '서울 강남구 도곡동',
            buyer_postcode : '123-456'
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {

              alert("결제 성공"+serviceNo);
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                $.ajax({
                    url: "/service/payComplete/"+serviceNo, //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,
                        "serviceNo":serviceNo,
                        "memberNo":memberNo
                        ,"tradeRequest":tradeRequest.value
                    },success:(result)=>{

                      console.log(result);
                      if(result>0){
                        //성공시 이동할 페이지
                        location.href="/service/payComplete/"+result;
                      }
                      else{

                      }
                    }
                

                });
                
          
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/order/payFail";
                alert(msg);
            }
        });
        
    }