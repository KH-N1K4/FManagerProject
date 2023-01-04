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


