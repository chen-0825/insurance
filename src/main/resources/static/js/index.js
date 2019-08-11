$(function(){
	var L1 = $("#L1,#L2,#L3,#L4,#L5,#L6,#L7");
	var index;
	L1.click(function(){
		index = L1.index(this);
		L1.css({"background-color":""});
		L1.eq(index).css({"background-color":"rgb(237, 81, 80)"});
	})
})