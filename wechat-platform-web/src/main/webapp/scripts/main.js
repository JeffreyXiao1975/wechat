$(function() {
	//设置鼠标悬停/点击时的菜单样式变化
	$("#menu li").mouseover(function() {
		$(this).addClass("hover");
	}).mouseout(function() {
		$(this).removeClass("hover");
	}).click(function() {
		$(this).addClass("select").siblings().removeClass("select");
	});
});

//退出系统
function logout() {
	window.opener=null;
	window.open("","_self");
	window.close();
}

//弹出层tr颜色变换
$(function() {
	//设置鼠标悬停/点击时的菜单样式变化
	$(".data_tab tr:odd").css("background-color","#f7f7f7");
	$(".data_tab tr:even").css("background-color","#e2eaf8");
});