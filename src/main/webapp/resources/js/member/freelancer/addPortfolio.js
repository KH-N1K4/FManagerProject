document.getElementById("image-input1").addEventListener('change', function(){

    var filename1 = document.getElementById('fileName1');
    if(this.files[0] == undefined){
        filename1.innerText ='선택된 파일 없음';
        return;
    }
    filename1.innerText = this.files[0].name;

});

document.getElementById("image-input2").addEventListener('change', function(){

    var filename2 = document.getElementById('fileName2');
    if(this.files[0] == undefined){
        filename2.innerText ='선택된 파일 없음';
        return;
    }
    filename2.innerText = this.files[0].name;

});

// 유효성체크
const portfolioTitle = document.getElementById('portfolioTitle');
const portfolioContent = document.getElementById('portfolioContent');
const fileName1 = document.getElementById("fileName1");
const fileName2 = document.getElementById("fileName2");

const button = document.getElementById('addButton');

button.addEventListener('click', function(){
    if((portfolioTitle.value.trim()!=0 && portfolioContent.value.trim()!=0) 
    && fileName2.innerText == '선택된 파일없음' 
    && fileName1.innerText == '선택된 파일없음'){
        alert('썸네일파일과 첨부파일을 첨부해주세요.');
    }
})

button.addEventListener('click', function(){
    if(fileName2.innerText != '선택된 파일없음' && fileName1.innerText == '선택된 파일없음'){
        alert('썸네일 파일을 첨부해주세요.');
    }
})

button.addEventListener('click', function(){
    if(fileName1.innerText != '선택된 파일없음' && fileName2.innerText == '선택된 파일없음'){
        alert('첨부 파일을 첨부해주세요.');
    }
})


