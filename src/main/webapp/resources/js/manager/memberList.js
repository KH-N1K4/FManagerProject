/* 회원 구분 select */
function selectChange(){
    const selectmemberType = document.getElementById("selectmemberType")
    const value = (selectmemberType.options[selectmemberType.selectedIndex].value);

    $.ajax({
       url:'/manager/memberType',
       type:'GET',
       data: {'value': value},
       success: (map)=>{
        if(map!=null){
            console.log(map);
            const before=document.querySelectorAll('.member-manage-table-content');
            for(b of before){
                b.remove();
            }
            document.querySelector('.pagination').innerHTML="";
            
            for(member of map.memberList){
               
            }

        }
       }
    });
    alert("프리랜서 여부 : "+value);
};





/* 회원 정보 modal */
const btnOpenPopup = document.querySelectorAll('.infoBtn');
const body = document.querySelector('#mainBody');
const memberModal = document.querySelector('.member-modal');
const freelancer = document.querySelector('.freelancerArea');
const modalClose = document.querySelector('.modal_close');
for (m of btnOpenPopup) {

    
       

    m.addEventListener("click", e => {

      if (memberModal.classList.contains('show')) {
        body.style.overflow = 'hidden';
    }
        const memberNo=e.target.parentElement.previousElementSibling.innerText;
        
        $.ajax({
            url:'/manager/memberDetail',
            data: {'memberNo': memberNo},
            type:'GET',
            success: (member)=>{
                if(member!=null){
                    memberModal.classList.toggle('show');
                    document.getElementById("memberNickname").value=member.memberNickname
                    document.getElementById("memberEmail").value=member.memberEmail
                    document.getElementById("memberTel").value=member.memberTel
                    document.getElementById("memberJob").value=member.memberJob

                    $("#checkbox > input").prop("checked", false);

                    if(member.memberInterest != null){
                        interest = member.memberInterest.split(',');
                        for(i of interest){
                            document.querySelectorAll("#checkbox > input")[i-1].checked = true;
                        }
                    }
                    if(member.freelancerFlag=='Y'){
                        freelancer.classList.toggle('show');
                        document.getElementById("freelancerIntroduction").innerText=member.freelancerIntroduction;
                        document.getElementById("freelancerRegionName").innerText=member.regionName;
                        document.getElementById("freelancerPeriod").innerText=member.freelancerPeriod;
                        document.getElementById("freeContactTime1").innerText=member.freeContactTime1;
                        document.getElementById("freeContactTime2").innerText=member.freeContactTime2;
                    }   

                } else{
                    console.log('오류');
                }
            },
            error: ()=> {console.log('에러');}
        });
        
         
        

    });
}

 

modalClose.addEventListener('click', () => {
    if(memberModal.classList.contains('show')){
        memberModal.classList.remove('show');
    }
    if(freelancer.classList.contains('show')){
        freelancer.classList.remove('show');
    }

    if (memberModal.classList.contains('show')) {
        body.style.overflow = 'hidden';
    }

});



/* 회원 구분 */

