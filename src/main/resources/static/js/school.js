$(function(){
    var province = null;
    var proSchool = null;
    $.ajax({
        url : "/province/list",	//请求url
        type : "GET",	//请求类型  post|get
        dataType : "json",  //返回数据的 类型 text|json|html--
        success : function(josn){	//回调函数 和 后台返回的 数据
            province = josn.data;
            if (province!= null && proSchool!= null){
                initSchool(province,proSchool);
            }
        }
    });

    $.ajax({
        url : "/college/list",	//请求url
        type : "GET",	//请求类型  post|get
        dataType : "json",  //返回数据的 类型 text|json|html--
        success : function(josn){	//回调函数 和 后台返回的 数据
            proSchool = josn.data;
            if (province!= null && proSchool!= null){
                initSchool(province,proSchool);
            }
        }
    });

});

function initSchool(province, proSchool){
    //province;
    //proSchool;
    //学校名称 激活状态
    $("#school").click(function(){
        var top = $(this).position().top+$(this).height()+2;
        var left = $(this).position().left;
        $("div[class='provinceSchool']").css({top:top,left:left});
        $("div[class='provinceSchool']").show();
    });
    //初始化省下拉框
    var provinceArray = "";
    var provicneSelectStr = "";
    for(var i=0,len=province.length;i<len;i++){
        provinceArray = province[i];
        provicneSelectStr = provicneSelectStr + "<option value='"+i+"'>"+provinceArray.name+"</option>"
    }
    $("div[class='proSelect'] select").html(provicneSelectStr);
    //初始化学校列表
    var selectPro = $("div[class='proSelect'] select").val();
    var schoolUlStr = "";
    var schoolListArray = proSchool[selectPro].colleges;
    var tempSchoolName = "";
    for(var i=0,len=schoolListArray.length;i<len;i++){
        tempSchoolName = schoolListArray[i].name;
        if(tempSchoolName.length>13){
            schoolUlStr = schoolUlStr + "<li class='DoubleWidthLi' title="+tempSchoolName+" id='"+schoolListArray[i].id+"'>"+tempSchoolName+"</li>"
        }else {
            schoolUlStr = schoolUlStr + "<li id='"+schoolListArray[i].id+"'>"+tempSchoolName+"</li>"
        }
    }
    $("div[class='schoolList'] ul").html(schoolUlStr);
    //省切换事件
    $("div[class='proSelect'] select").change(function(){
        if("99"!=$(this).val()){
            $("div[class='proSelect'] span").show();
            $("div[class='proSelect'] input").hide();
            schoolUlStr = "";
            schoolListArray = proSchool[$(this).val()].colleges;
            for(var i=0,len=schoolListArray.length;i<len;i++){
                tempSchoolName = schoolListArray[i].name;
                if(tempSchoolName.length>13){
                    schoolUlStr = schoolUlStr + "<li class='DoubleWidthLi' title="+tempSchoolName+" id='"+schoolListArray[i].id+"'>"+tempSchoolName+"</li>"
                }else {
                    schoolUlStr = schoolUlStr + "<li id='"+schoolListArray[i].id+"'>"+tempSchoolName+"</li>"
                }
            }
            $("div[class='schoolList'] ul").html(schoolUlStr);
        }
        else {
            $("div[class='schoolList'] ul").html("<span class='entertext'>请在输入框内手动输入学校！</span>");
            $("div[class='proSelect'] span").hide();
            $("div[class='proSelect'] input").show();
        }
    });
    //学校列表mouseover事件
    $("div[class='schoolList'] ul").on("mouseover",'li',function(){
        $(this).css("background-color","#60A411");
    });
    //学校列表mouseout事件
    $("div[class='schoolList'] ul").on("mouseout",'li',function(){
        $(this).css("background-color","");
    });
    //学校列表点击事件
    $("div[class='schoolList'] ul").on("click",'li',function(){

        $("#school").val($(this).html());
        $("div[class='provinceSchool']").hide();
        window.location.href="/?collectId="+this.id;
    });
    //按钮点击事件
    $("div[class='button']").on("click",'button',function(){
        var flag = $(this).attr("flag");
        if("0"==flag){
            $("div[class='provinceSchool']").hide();
        }else if("1"==flag){
            var selectPro = $("div[class='proSelect'] select").val();
            if("99"==selectPro){
                $("#school").val($("div[class='proSelect'] input").val());
            }
            $("div[class='provinceSchool']").hide();
        }
    });
}
