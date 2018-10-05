var websocket = null;
var a = 3;
var receiver_id;

function click_user_name(id,name) {
    receiver_id=id;
    $('#show_chater').text(name);
}
function init_websocket(){

    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://localhost:8080/webSocket");
    }
    else{
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function(){
        //setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function(event){
        //setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    websocket.onmessage = function(event){
        //setMessageInnerHTML(event.data);
        console.info(event.data);
        var json = JSON.parse(event.data);
        receiver_id=json.userId;
        $('#show_chater').text(json.userName);
        $('#chat_box').show();
        var g = json.msg;
        var e = new Date, f = "";
        f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
        var i = "<div class='message clearfix'>" + "<div class='wrap-text'>" + "<h5 class='clearfix'><a onclick='click_user_name("+json.userId+",\""+json.userName+"\")'>"+json.userName+"</a></h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div clsss='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
        ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), $("#textarea").val(""))
    }

    //连接关闭的回调方法
    websocket.onclose = function(){
        //setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }

    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }
}
function message() {

    var a = $.blinkTitle.show();
    setTimeout(function() {
            $.blinkTitle.clear(a)
        },
        8e3)

}
$(document).ready(function() {

    function e() {

        function h() {
            - 1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='images/").replace("#*", ".gif'/>"), h())
        }

        var e = new Date,
            f = "";
        f += e.getFullYear() + "-",
            f += e.getMonth() + 1 + "-",
            f += e.getDate() + "  ",
            f += e.getHours() + ":",
            f += e.getMinutes() + ":",
            f += e.getSeconds();
        //获取输入框内的值
        var g = $("#textarea").val();
        //表情用img替换
        h();
        websocket.send('{"userId":'+receiver_id+',"userName":"yuan","msg":"'+g+'"}');
        var rer = $('#show_chater').text();
        var i = "<div class='message clearfix'>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>我对"+rer+"说</h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div clsss='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
        null != g && "" != g ? ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), $("#textarea").val(""))
            : console.info("空文本")
    }

     var   b = "images/head/2024.jpg",
        c = "images/head/2015.jpg",
        d = "\u738b\u65ed";
    $(".close_btn").click(function() {

        $(".chat_Box").hide()
    }),
        $(".chat03_content li").mouseover(function() {

            $(this).addClass("hover").siblings().removeClass("hover")
        }).mouseout(function() {

            $(this).removeClass("hover").siblings().removeClass("hover")
        }),
        $(".chat03_content li").dblclick(function() {

            var b = $(this).index() + 1;
            a = b,
                c = "images/head/20" + (12 + a) + ".jpg",
                d = $(this).find(".chat03_name").text(),
                $(".chat01_content").scrollTop(0),
                $(this).addClass("choosed").siblings().removeClass("choosed"),
                $(".talkTo a").text($(this).children(".chat03_name").text()),
                $(".mes" + b).show().siblings().hide()
        }),
        $(".ctb01").mouseover(function() {

            $(".wl_faces_box").show()
        }).mouseout(function() {

            $(".wl_faces_box").hide()
        }),
        $(".wl_faces_box").mouseover(function() {

            $(".wl_faces_box").show()
        }).mouseout(function() {

            $(".wl_faces_box").hide()
        }),
        $(".wl_faces_close").click(function() {

            $(".wl_faces_box").hide()
        }),
        $(".wl_faces_main img").click(function() {

            var a = $(this).attr("src");
            $("#textarea").val($("#textarea").val() + "*#" + a.substr(a.indexOf("images/") + 7, 6) + "#*"),
                $("#textarea").focusEnd(),
                $(".wl_faces_box").hide()
        }),
        $(".chat02_bar img").click(function() {
            e()
        }),
        document.onkeydown = function(a) {

            var b = document.all ? window.event: a;
            return 13 == b.keyCode ? (e(), !1) : void 0
        },
        $.fn.setCursorPosition = function(a) {
            return 0 == this.lengh ? this: $(this).setSelection(a, a)
        },
        $.fn.setSelection = function(a, b) {
            if (0 == this.lengh) return this;
            if (input = this[0], input.createTextRange) {
                var c = input.createTextRange();
                c.collapse(!0),
                    c.moveEnd("character", b),
                    c.moveStart("character", a),
                    c.select()
            } else input.setSelectionRange && (input.focus(), input.setSelectionRange(a, b));
            return this
        },
        $.fn.focusEnd = function() {
            this.setCursorPosition(this.val().length)
        }
}),
    function(a) {
        a.extend({
            blinkTitle: {
                show: function() {
                    var a = 0,
                        b = document.title;
                    if ( - 1 == document.title.indexOf("\u3010")) var c = setInterval(function() {
                            a++,
                            3 == a && (a = 1),
                            1 == a && (document.title = "\u3010\u3000\u3000\u3000\u3011" + b),
                            2 == a && (document.title = "\u3010\u65b0\u6d88\u606f\u3011" + b)
                        },
                        500);
                    return [c, b]
                },
                clear: function(a) {
                    a && (clearInterval(a[0]), document.title = a[1])
                }
            }
        })
    } (jQuery);