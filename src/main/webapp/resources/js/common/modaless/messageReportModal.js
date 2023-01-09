document.getElementById('reportModal_close').addEventListener('click', function() {
	//bg.remove();
	parent.window.document.getElementById('my_modal').style.display = 'none';
}); 

document.getElementById('ajaxReview').addEventListener('click', function() {
		const reportedMemberNo = document.getElementById('reportedMemberNo').value;
		const reportMemberNo = document.getElementById('reportMemberNo').value;
		const reportContent = document.getElementById('reportContent').value;
		const reportTitle = document.getElementById('reportTitle').value;
		let formData = new FormData();
		for(let i=0;i< $("#reportFilePath")[0].files.length;i++){
			formData.append("reportFile",$("#reportFilePath")[0].files[i]);
		}
    formData.append("reportedMemberNo",reportedMemberNo);
    formData.append("reportMemberNo",reportMemberNo);
    formData.append("reportContent",reportContent);
    formData.append("reportTitle",reportTitle);
		$.ajax({
        
			url: "/reportMemberSubmit",
			data : formData,
			type: "POST", 
			processData : false,
			contentType: false,
			cache: false,
			dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
			success: (result) => {
					console.log(result);
					if(result == "신고가 접수되었습니다."){
						alert(result);
						document.getElementById('reportedProfile').setAttribute("src",'');
						document.getElementById('reportedName').innerText='';
						document.getElementById('memberName').innerText='';
						document.getElementById('reportContent').innerText='';
						document.getElementById('reportTitle').innerText='';
						document.getElementById('reportFilePath').value='';
						document.getElementById('reportedMemberNo').value='';
						document.getElementById('reportMemberNo').value='';

						parent.window.document.getElementById('my_modal').style.display = 'none';
						document.getElementById('reportTitle').value ='';
						document.getElementById('reportContent').value='';
						document.getElementById('reportFilePath').value='';


					}
			},
			error: () => {
					console.log("신고 실패")
			}


	});
});