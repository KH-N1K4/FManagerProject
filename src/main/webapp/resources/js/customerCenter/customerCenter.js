function hiddenFile(o){
    let file = '';
    file += '<input type="file" name="file" id="'+o.id+'"/>';
    return file;
  }
  
  function file(o){
    let type = '';
    if(o.ext === 'pptx' || o.ext === 'ppt'){
      type = 'powerpoint';
    }else if(o.ext === 'png' || o.ext === 'jpg'){
      type = 'image';
    }else if(o.ext === 'xlsx'){
      type = 'excel';
    }else if(o.ext === 'pdf'){
      type = 'pdf';
    }else {
      type = 'alt';
    }
  
    let fileThumbnail = '';
    fileThumbnail += '<div class="thumbnail">';
    fileThumbnail += '  <i class="far fa-file-'+type+'"></i>';
    fileThumbnail += '  <p class="name">'+o.name+'</p>';
    fileThumbnail += '  <a href="#'+o.id+'" class="delete"><i class="far fa-minus-square"></i></a>';
    fileThumbnail += '</div>';
    return fileThumbnail;
  }
  
  function addFile(o){
    $('.file-hidden-list').append(hiddenFile(o));
    $('#' + o.id).click();
    $('#' + o.id).on('change', function(e){
        const arr1 = e.target.value.split('\\');
        const name = arr1[arr1.length-1];
        o.name = name;

        const arr2 = e.target.value.split('.');
        const ext = arr2[arr2.length-1];
        o.ext = ext;

        $('.file-list').append(file(o));
    });
}

function makeid(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
}

$(document).on('click', '#addFile', function(){
    addFile({id:makeid(10)});
});
$(document).on('click', '.delete', function(){
    const id = $(this).attr('href');
    $(id).remove();
    $(this).parent().remove();
});