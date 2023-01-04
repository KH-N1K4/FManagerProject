$('.detailMenu').click(function(){
  console.log(document.getElementById('sub'+this.title+'Box'));
  console.log('sub'+this.title+'Box');
  document.getElementById('sub'+this.title+'Box').classList.toggle('subMenu');
});