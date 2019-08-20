$(function () {
    lpgl(1);
});
//模糊搜索
$("#ss").bind('input propertychange', function () {
    $("#ssts").empty();
    ss = $(this).val();
    lpgl(pageNum);
});
var ss = '';
var desc = '';
var ord = '';

var d1 = 0;
var d2 = 0;
var d3 = 0;
$("#ordss").click(function () {
    $("#ordpf").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    $("#ordtime").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    d2 = 0;
    d3 = 0;
    ord = " ss_money";
    if(d1 == 0){
        desc = " desc";
        d1 = d1-180;
        $(this).css({"transform":"rotate("+d1+"deg)","transtion-duration":"1s"});
    }else{
        desc = " asc";
        d1 = d1+180;
        $(this).css({"transform":"rotate("+d1+"deg)","transtion-duration":"1s"});
    }
    lpgl(pageNum);
})

$("#ordpf").click(function () {
    $("#ordss").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    $("#ordtime").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    d1 = 0;
    d3 = 0;
    ord = " pf_money";
    if(d2 == 0){
        desc = " desc";
        d2 = d2-180;
        $(this).css({"transform":"rotate("+d2+"deg)","transtion-duration":"1s"});
    }else{
        desc = " asc";
        d2 = d2+180;
        $(this).css({"transform":"rotate("+d2+"deg)","transtion-duration":"1s"});
    }
    lpgl(pageNum);
})

$("#ordtime").click(function () {
    $("#ordss").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    $("#ordpf").css({"transform":"rotate(0deg)","transtion-duration":"1s"});
    d1 = 0;
    d2 = 0;
    ord = " lp_time";
    if(d3 == 0){
        desc = " desc";
        d3 = d3-180;
        $(this).css({"transform":"rotate("+d3+"deg)","transtion-duration":"1s"});
    }else{
        desc = " asc";
        d3 = d3+180;
        $(this).css({"transform":"rotate("+d3+"deg)","transtion-duration":"1s"});
    }
    lpgl(pageNum);
})

var pageNum;
var pages;
var total;
var size;
var navigatepageNums;

function lpgl(pn) {
    $("tbody").empty();
    //清楚全选样式
    $("#allChoice").prop("checked", false);
    $.ajax({
        url: '/lpgls',
        data: {'pn': pn, 'ss': ss, 'desc': desc, 'ord': ord},
        type: 'get',
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                //提示没有搜索到
                $("#ssts").append($("<h1>哦...没有记录!</h1>"))
            }else{
                pageNum = result.map.page.pageNum;
                pages = result.map.page.pages;
                total = result.map.page.total;
                size = result.map.page.size;
                navigatepageNums = result.map.page.navigatepageNums;
                //填充表格内容
                tabody(result.map.page.list);
                //填充分页信息
                infoPage();
                //填充分页条
                pagePilot(result.map.page);
            }
        }
    });
}

//表格信息
function tabody(list) {
    //先清空表格
    $("tbody").empty();
    $.each(list, function (index, ints) {
        var checks = $("<td></td>").append($("<input type='checkbox' name='ch'/>").addClass("check"));
        var id = $("<td></td>").append(ints.id);
        var xmName = $("<td></td>").append(ints.xmName);
        var ssMoney = $("<td></td>").append(ints.ssMoney);
        var pfMoney = $("<td></td>").append(ints.pfMoney);
        var lpId = $("<td></td>").append(ints.lpId);
        var lqPeople = $("<td></td>").append(ints.lqPeople);
        var lpFs = $("<td></td>").append(ints.lpFs);
        var lpSh = $("<td></td>").append(ints.lpSh);
        var lpTime = $("<td></td>").append(ints.lpTime);
        //编辑,删除按钮
        var upd = $("<button class='btn-info upd'><span class='glyphicon glyphicon-pencil'></span>编辑</button>").attr("updIds", ints.id);
        var del = $("<button class='btn-danger del'><span class='glyphicon glyphicon-trash'></span>删除</button>").attr("del_id", ints.id);
        var cz = $("<td></td>").append(upd).append(" ").append(del);

        var tr = $("<tr></tr>").append(checks).append(id).append(xmName)
            .append(ssMoney).append(pfMoney).append(lpId).append(lqPeople).append(lpFs)
            .append(lpSh).append(lpTime).append(cz).appendTo($("#showAll tbody"));
    })
}

//分页信息
function infoPage() {
    $("#infoPage").empty();//清空之前信息
    $("#infoPage").append("当前页:").append(pageNum).append("总页数")
        .append(pages).append("总记录:").append(total).append("条");
}

//分页条信息
function pagePilot(page) {
    $("#pagePilot ul").empty();//清空之前信息
    var first = $("<li></li>").append($("<a></a>").append("首页"));
    first.click(function () {//跳首页 及时绑定方法,不用on
        lpgl(1);
    });
    var before = $("<li></li>").append($("<a></a>").append("&laquo;"));
    before.click(function () {//跳上一页
        lpgl(pageNum - 1);
    });
    if (!page.hasPreviousPage) {//如果没有上一页了,就失效
        first.addClass("disabled");
        before.addClass("disabled");
    }
    $("#pagePilot ul").append(first).append(before);

    $.each(navigatepageNums, function (index, num) {
        var li = $("<li></li>").append($("<a></a>").append(num));
        if (num == pageNum) {//若为当前页,则高亮
            li.addClass("active");
        }
        li.click(function () {//点击指定页跳转
            lpgl(num);
        });
        $("#pagePilot ul").append(li);
    });

    var next = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var last = $("<li></li>").append($("<a></a>").append("尾页"));
    if (!page.hasNextPage) {//如果没有下一页了,就失效
        next.addClass("disabled");
        last.addClass("disabled");
    }
    next.click(function () {//跳下一页
        lpgl(pageNum + 1);
    });
    last.click(function () {//跳尾页
        lpgl(pages);
    });
    $("#pagePilot ul").append(next).append(last);
}

//删除单条
$(document).on("click", ".del", function () {
    $.ajax({
        url: '/lpgl/' + $(this).attr("del_id"),
        type: 'delete',
        success: function (result) {
            if (result.code == 100) {
                lpgl(pageNum);
            } else {
                alert("出现异常,删除失败!")
            }
        }
    });
});

//全选按钮
$("#allChoice").click(function () {
    var status = ($(this).prop("checked"));
    $(".check").prop("checked", status);
});
//单选按钮
$(document).on("click", ".check", function () {
    if ($(".check:checked").length == size) {//如果选中当前页所有记录,则自动勾选全选
        $("#allChoice").prop("checked", true);
    } else {//否则取消全选
        $("#allChoice").prop("checked", false);
    }
});

//点击添加
$("#insert").click(function () {
    //弹出框之前先清除之前的选择
    $("#ins_xmName").val("");
    $("#ins_ssMoney").val("");
    $("#ins_pfMoney").val("");
    $("#ins_lqPeople").val("");
    $("#ins_lpFs").val("");
    $("#ins_lpSh").val("");
    $("#ins_lpTime").val("");

    $("#ins_lpTime_span").text("");
    $('#insertModal').modal({
        backdrop: true
    })
});

//点击添加提交按钮
$("#insertForm").click(function () {
    var ins_xmName = $("#ins_xmName").val();
    var ins_ssMoney = $("#ins_ssMoney").val();
    var ins_pfMoney = $("#ins_pfMoney").val();
    var ins_lqPeople = $("#ins_lqPeople").val();
    var ins_lpFs = $("#ins_lpFs").val();
    var ins_lpSh = $("#ins_lpSh").val();
    var ins_lpTime = $("#ins_lpTime").val();

    var s1 = $("#ins_xmName_span").text();
    var s2 = $("#ins_ssMoney_span").text();
    var s3 = $("#ins_pfMoney_span").text();
    var s4 = $("#ins_lqPeople_span").text();
    var s5 = $("#ins_lpFs_span").text();
    var s6 = $("#ins_lpSh_span").text();
    var s7 = $("#ins_lpTime_span").text();

    if (ins_lpFs == null) {
        $("#ins_lpFs_span").text("请选择").css("color", "red");
    } else {
        $("#ins_lpFs_span").text("");
    }
    if (ins_lpSh == null) {
        $("#ins_lpSh_span").text("请选择").css("color", "red");
    } else {
        $("#ins_lpSh_span").text("");
    }
    if (ins_lpTime == '') {
        $("#ins_lpTime_span").text("请选择").css("color", "red");
    } else {
        $("#ins_lpTime_span").text("");
    }
    if ((s1 != "" || s2 != "" || s3 != "" || s4 != "" || s5 != "" || s6 != "" || s7 != "")
        || (ins_xmName == "" || ins_ssMoney == "" || ins_pfMoney == "" || ins_lqPeople == "" || ins_lpFs == "" || ins_lpSh == "" || ins_lpTime == "")
    ) {
        alert("请正确填写表单");
    } else {
        //获取表单中用户填写的数据
        var insert = $("#insertModal form").serialize();
        insert = decodeURIComponent(insert);
        $.ajax({
            url: '/insertLpgl',
            type: 'post',
            data: insert,
            success: function (result) {
                if (result.lpTime != null) {
                    $("#ins_lpTime_span").text(result.lpTime).css("color", "red");
                } else if (result.code == 100) {
                    lpgl(total);
                    $("#insertModal").modal("hide");
                } else {
                    alert("出现异常,添加失败!")
                }
            }
        });
    }
});

//点击编辑按钮
$(document).on("click", ".upd", function () {
    //清除之前的
    $("#upd_id").text("");
    $("#upd_lpId").text("");
    $("#upd_xmName").val("");
    $("#upd_ssMoney").val("");
    $("#upd_pfMoney").val("");
    $("#upd_lqPeople").val("");
    $("#upd_lpFs").val("");
    $("#upd_lpSh").val("");
    $("#upd_lpTime").val("");

    $("#upd_lpTime_span").text("");
    //表单信息回显
    var updIds = $(this).attr("updIds");
    upd_msg(updIds);
    //弹出编辑模态框
    $('#updateModal').modal({
        backdrop: true
    })
});

//查询指定id信息
function upd_msg(upd_id) {
    $.ajax({
        url: '/findLpgl/' + upd_id,
        type: 'get',
        success: function (result) {
            var lpgl = result.map.lpgl;
            console.log(lpgl);
            $("#upd_id").text(lpgl.id);
            $("#upd_lpId").text(lpgl.lpId);
            $("#upd_xmName").val(lpgl.xmName);
            $("#upd_ssMoney").val(lpgl.ssMoney);
            $("#upd_pfMoney").val(lpgl.pfMoney);
            $("#upd_lqPeople").val(lpgl.lqPeople);
            $("#upd_lpFs").val([lpgl.lpFs]);
            $("#upd_lpSh").val([lpgl.lpSh]);
            $("#upd_lpTime").val(lpgl.lpTime);
        }
    });
}

//点击确认编辑
$("#updateForm").click(function () {
    var upd_xmName = $("#upd_xmName").val();
    var upd_ssMoney = $("#upd_ssMoney").val();
    var upd_pfMoney = $("#upd_pfMoney").val();
    var upd_lqPeople = $("#upd_lqPeople").val();
    var upd_lpFs = $("#upd_lpFs").val();
    var upd_lpSh = $("#upd_lpSh").val();
    var upd_lpTime = $("#upd_lpTime").val();

    var s1 = $("#upd_xmName_span").text();
    var s2 = $("#upd_ssMoney_span").text();
    var s3 = $("#upd_pfMoney_span").text();
    var s4 = $("#upd_lqPeople_span").text();
    var s5 = $("#upd_lpFs_span").text();
    var s6 = $("#upd_lpSh_span").text();
    var s7 = $("#upd_lpTime_span").text();

    if (upd_lpFs == null) {
        $("#upd_lpFs_span").text("请选择").css("color", "red");
    } else {
        $("#upd_lpFs_span").text("");
    }
    if (upd_lpSh == null) {
        $("#upd_lpSh_span").text("请选择").css("color", "red");
    } else {
        $("#upd_lpSh_span").text("");
    }
    if (upd_lpTime == '') {
        $("#upd_lpTime_span").text("请选择").css("color", "red");
    } else {
        $("#upd_lpTime_span").text("");
    }
    if ((s1 != "" || s2 != "" || s3 != "" || s4 != "" || s5 != "" || s6 != "" || s7 != "")
        || (upd_xmName == "" || upd_ssMoney == "" || upd_pfMoney == "" || upd_lqPeople == "" || upd_lpFs == "" || upd_lpSh == "" || upd_lpTime == "")
    ) {
        alert("请正确填写表单");
    } else {
        var udp = $("#updateModal form").serialize();
        udp = decodeURIComponent(udp);
        udp += '&id=' + $("#upd_id").text() + '&lpId=' + $("#upd_lpId").text();
        $.ajax({
            url: '/updLpgl',
            type: 'put',
            data: udp,
            success: function (result) {
                if (result.lpTime != null) {
                    $("#upd_lpTime_span").text(result.lpTime).css("color", "red");
                } else if (result.code == 100) {
                    lpgl(pageNum);
                    alert("修改成功!");
                    $("#updateModal").modal("hide");
                } else {
                    alert("出现异常,修改失败!");
                }
            }
        });
    }
});

//增加框正则验证
$("#ins_xmName").blur(function () {
    var name = $(this).val();
    var yz_name = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!name.match(yz_name) && name != '') {
        $("#ins_xmName_span").text("项目名必须是中文或字母!")
    } else {
        $("#ins_xmName_span").text("");
    }
});
$("#ins_xmName").focus(function () {
    $("#ins_xmName_span").text("");
});

$("#ins_ssMoney").blur(function () {
    var ssmoney = $(this).val();
    var yz_ssmoney = /^[0-9]+(.[0-9]{2})?$/;
    if (!ssmoney.match(yz_ssmoney) && ssmoney != '') {
        $("#ins_ssMoney_span").text("金额可以是两位小数的数字").css("color", "red")
    } else {
        $("#ins_ssMoney_span").text("");
    }
});
$("#ins_ssMoney").focus(function () {
    $("#ins_ssMoney_span").text("");
});

$("#ins_pfMoney").blur(function () {
    var pfmoney = $(this).val();
    var yz_pfmoney = /^[0-9]+(.[0-9]{2})?$/;
    if (!pfmoney.match(yz_pfmoney) && pfmoney != '') {
        $("#ins_pfMoney_span").text("金额可以是两位小数的数字").css("color", "red")
    } else {
        $("#ins_pfMoney_span").text("");
    }
});
$("#ins_pfMoney").focus(function () {
    $("#ins_pfMoney_span").text("");
});

$("#ins_lqPeople").blur(function () {
    var lqPeople = $(this).val();
    var yz_lqPeople = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!lqPeople.match(yz_lqPeople) && lqPeople != '') {
        $("#ins_lqPeople_span").text("用户名必须是中文或字母!").css("color", "red")
    } else {
        $("#ins_lqPeople_span").text("");
    }
});
$("#ins_lqPeople").focus(function () {
    $("#ins_lqPeople_span").text("");
});

$("#ins_lpFs").focus(function () {
    $("#ins_lpFs_span").text("");
})
$("#ins_lpSh").focus(function () {
    $("#ins_lpSh_span").text("");
})
$("#ins_lpTime").focus(function () {
    $("#ins_lpTime_span").text("");
})

//修改框正则验证
$("#upd_xmName").blur(function () {
    var name = $(this).val();
    var yz_name = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!name.match(yz_name) && name != '') {
        $("#upd_xmName_span").text("项目名必须是中文或字母!").css("color", "red")
    } else {
        $("#upd_xmName_span").text("");
    }
});
$("#upd_xmName").focus(function () {
    $("#upd_xmName_span").text("");
});

$("#upd_ssMoney").blur(function () {
    var ssmoney = $(this).val();
    var yz_ssmoney = /^[0-9]+(.[0-9]{2})?$/;
    if (!ssmoney.match(yz_ssmoney) && ssmoney != '') {
        $("#upd_ssMoney_span").text("金额可以是两位小数的数字").css("color", "red")
    } else {
        $("#upd_ssMoney_span").text("");
    }
});
$("#upd_ssMoney").focus(function () {
    $("#upd_ssMoney_span").text("");
});

$("#upd_pfMoney").blur(function () {
    var pfmoney = $(this).val();
    var yz_pfmoney = /^[0-9]+(.[0-9]{2})?$/;
    if (!pfmoney.match(yz_pfmoney) && pfmoney != '') {
        $("#upd_pfMoney_span").text("金额可以是两位小数的数字").css("color", "red")
    } else {
        $("#upd_pfMoney_span").text("");
    }
});
$("#upd_pfMoney").focus(function () {
    $("#upd_pfMoney_span").text("");
});

$("#upd_lqPeople").blur(function () {
    var lqPeople = $(this).val();
    var yz_lqPeople = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!lqPeople.match(yz_lqPeople) && lqPeople != '') {
        $("#upd_lqPeople_span").text("用户名必须是中文或字母!").css("color", "red")
    } else {
        $("#upd_lqPeople_span").text("");
    }
});
$("#upd_lqPeople").focus(function () {
    $("#upd_lqPeople_span").text("");
});

$("#upd_lpFs").focus(function () {
    $("#upd_lpFs_span").text("");
})
$("#upd_lpSh").focus(function () {
    $("#upd_lpSh_span").text("");
})
$("#upd_lpTime").focus(function () {
    $("#upd_lpTime_span").text("");
})








