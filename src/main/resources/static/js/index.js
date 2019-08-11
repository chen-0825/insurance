$(function(){
	var L1 = $("#L1,#L2,#L3,#L4,#L5,#L6,#L7");
	// var L2 = $("#L1>i,#L2>i,#L3>i,#L4>i,#L5>i,#L6>i,#L7>i");
	var index1;
	L2.css({"display":"none"});
	L1.click(function(){
		index1 = L1.index(this);
		L1.css({"background-color":""});
		L1.eq(index1).css({"background-color":"rgb(237, 81, 80)"});
		// L2.css({"display":"none"});
		// L2.eq(index1).css({"display":"inline-block"});
	})
})