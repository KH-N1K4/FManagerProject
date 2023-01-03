modalOpen();





/* 모달 */
function modalOpen(){

    const modalBtn = document.querySelectorAll('.reviewDetail');
    const body = document.querySelector('#mainBody');
    const reviewModal = document.querySelector('.review-modal');
    const x = document.querySelector(".x");
    
    for(m of modalBtn){
        m.addEventListener("click", e=>{
    
            const reviewReportNo = e.target.parentElement.previousElementSibling.innerText;
        
            $.ajax({
                url : '/manager/reviewReportDetail',
                data: {'reviewReportNo':reviewReportNo},
                success:(reviewReport)=>{
                    if(reviewReport!=null){
        
                        if (!reviewModal.classList.contains('show')) {
                            reviewModal.classList.add('show');
                            body.style.overflow = 'hidden';
                        }
        
                        document.querySelector(".content").innerText=reviewReport.reviewContent;
                        const imageArea = document.querySelector(".review-image");
                        imageArea.setAttribute("src", reviewReport.reviewImage);
        
        
        
                    }
                }
        
            });
        
            x.addEventListener("click", () => {
        
                if (reviewModal.classList.contains('show')) {
                    reviewModal.classList.remove('show');
                }
        
                if (!reviewModal.classList.contains('show')) {
                    body.style.overflow = 'visible';
                }
            });
    
        });
    
    
    }
}