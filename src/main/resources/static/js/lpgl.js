$(function () {
    lpgl(1);
});
//模糊搜索
$("#ss").bind('input propertychange', function () {
    $("#ssts").empty();
    ss = $(this).val();
    lpgl(pageNum);
});

$("#yes").click(function () {
    sta = "0";
    lpgl(pageNum);
});
$("#not").click(function () {
    sta = "1";
    lpgl(pageNum);
});

var sta = '0';
var ss = '';

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
        data: {'pn': pn, 'ss': ss, 'sel': sel, 'sta': sta},
        type: 'get',
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                //提示没有搜索到
                $("#ssts").append($("<h1>哦...没有记录!</h1>"))
            } else {
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

var sel = '';
//选择每页条数
$("#xzts").change(function () {
    sel = $("#xzts select").val();
    if (sel == 'all') {
        sel = total;
    }
    lpgl(pageNum);
});

//表格信息
function tabody(list) {
    //先清空表格
    $("tbody").empty();
    $.each(list, function (index, ints) {
        var id = $("<td></td>").append(ints.id);
        var lpPeople = $("<td></td>").append(ints.lpPeople);
        var lpMoney = $("<td></td>").append(ints.lpMoney);
        var lpTime = $("<td></td>").append(ints.lpTime);
        var lpStatus = $("<td></td>").append(ints.lpStatus==0?'未赔':'已赔');
        var status = $("<td></td>").append(ints.status==0?'有效':'失效');
        //编辑,删除按钮
        var upd = $("<button class='btn-info upd'><span class='glyphicon glyphicon-pencil'></span>编辑</button>").attr("updIds", ints.id);
        var cz = $("<td></td>").append(upd).append(" ");

        var tr = $("<tr></tr>").append(id)
            .append(lpPeople).append(lpMoney).append(lpTime).append(lpStatus).append(status)
            .append(cz)
         if(ints.lpStatus == '0'){
             tr.css("background-color","white");
         }else{
             tr.css({"background-color":"lightgrey","opacity":"0.7"});
         }
        tr.appendTo($("#showAll tbody"));
    })
}

//分页信息
function infoPage() {
    $("#infoPage").empty();//清空之前信息
    $("#infoPage").append("当前页:").append($("<span style='color: red;'></span>").text(pageNum)).append("页<br>")
        .append("总页数").append($("<span style='color: red;'></span>").text(pages)).append("页<br>")
        .append("总记录:").append($("<span style='color: red;'></span>").text(total)).append("条")
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

//点击编辑按钮
$(document).on("click", ".upd", function () {
    //清除之前的
    $("#upd_id").text("");
    $("#upd_lpMoney").text("");
    $("#upd_lpPeople").val("");
    $("#upd_lpStatus").val("");
    $("#upd_lpTime").val("");
    $("#upd_status").val("");

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
            $("#upd_lpMoney").text(lpgl.lpMoney);
            $("#upd_lpPeople").val(lpgl.lpPeople);
            $("#upd_lpStatus").val([lpgl.lpStatus]);
            $("#upd_status").val([lpgl.status]);
            $("#upd_lpTime").val(lpgl.lpTime);
        }
    });
}

//点击确认编辑
$("#updateForm").click(function () {
    var udp = $("#updateModal form").serialize();
    udp = decodeURIComponent(udp);
    udp += '&id=' + $("#upd_id").text() + '&lpMoney=' + $("#upd_lpMoney").text();
    $.ajax({
        url: '/updLpgl',
        type: 'put',
        data: udp,
        success: function (result) {
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

//批量删除
// $("#dels").click(function () {
//     //首先获取用户点击的多选框的id
//     var td = $(".check:checked").parent().next();
//     var dels = '';
//     $.each(td,function () {
//         dels+="_"+$(this).text();
//     });
//     dels = dels.substring(1, dels.length);
//     $.ajax({
//         url: '/dels',
//         type: 'delete',
//         data: 'dels='+dels,
//         success:function (result) {
//             if (result.code == 100) {
//                 lpgl(pageNum);
//                 alert("删除成功!");
//             } else {
//                 alert("出现异常,删除失败!")
//             }
//         }
//     });
// });





