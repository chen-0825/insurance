$(function(){
	var index;
	$("li").click(function(){
		index = $(this).index(this);
		$(this).css({"background-color":""});
		$(this).eq(index).css({"background-color":"rgb(237, 81, 80)"});
	})
})