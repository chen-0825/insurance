$(function () {
    lpgl(1);
});
var pageNum;
var pages;
var total;
var size;
var navigatepageNums;

function lpgl(pn) {
    //清楚全选样式
    $("#allChoice").prop("checked", false);
    $.ajax({
        url: '/lpgls',
        data: 'pn=' + pn,
        type: 'get',
        success: function (result) {
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
        var upd = $("<button class='btn-info upd'><span class='glyphicon glyphicon-pencil'></span>编辑</button>").attr("upd_id", ints.id);
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

    $('#insertModal').modal({
        backdrop: true
    })
});

//点击添加提交按钮
$("#insertForm").click(function () {
    //获取表单中用户填写的数据
    var insert = $("#insertModal form").serialize();
    alert(insert);
    insert = decodeURIComponent(insert);
    $.ajax({
        url: '/insertOne',
        type: 'post',
        data: insert,
        success: function (result) {
            if (result.code == 100) {
                lpgl(total);
                $("#insertModal").modal("hide");
            } else {
                alert("出现异常,添加失败!")
            }
        }
    });
});

//点击编辑按钮
$(document).on("click", ".upd", function () {
    //清除之前的
    $("#upd_itrgtId").text("");//主键
    $("#upd_teacherId").val("");
    $("#upd_userId").val("");
    $("#startTime_span").text("");
    $("#endTime_span").text("");
    $("#upd_Price").val("");
    var upd_id = $(this).attr("upd_id");
    //表单信息回显
    upd_msg(upd_id);
    //弹出编辑模态框
    $('#updateModal').modal({
        backdrop: true
    })
});

//查询指定id信息
function upd_msg(upd_id) {
    $.ajax({
        url: '/findOne/'+upd_id,
        type: 'get',
        success:function (result) {
            var int = result.map.interrogation;
            $("#upd_itrgtId").text(int.itrgtId);//主键
            $("#upd_teacherId").val([int.itrgtTeacherId]);
            $("#upd_userId").val([int.itrgtUserId]);
            $("#upd_startTime").val(int.itrgtStartTime);
            $("#upd_endTime").val(int.itrgtEndTime);
            $("#upd_Price").val(int.itrgtTotalPrice);
        }
    });
}

//点击确认编辑
$("#updateForm").click(function () {
    var udp = $("#updateModal form").serialize();
    udp = decodeURIComponent(udp);
    udp += '&itrgtId='+$("#upd_itrgtId").text();
    $.ajax({
        url: '/updOne',
        type: 'put',
        data: udp,
        success:function (result) {
            if (result.code == 100) {
                lpgl(pageNum);
                alert("修改成功!");
                $("#updateModal").modal("hide");
            } else {
                alert("出现异常,修改失败!");
            }
        }
    });
});



