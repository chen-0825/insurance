$(function(){
	var index = 0;
	$("li").click(function(){
		index = $("li").index(this);
		$("li").css({"background-color":""});
		$("li").eq(index).css({"background-color":"rgb(237, 81, 80)"});
	})
})