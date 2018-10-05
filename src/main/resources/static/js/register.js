$(function(){

	var error_name = false;
	var error_password = false;
	var error_check_password = false;
	var error_email = false;
	var error_check = false;


	$('#username').blur(function() {
		check_user_name();
	});

	$('#password').blur(function() {
		check_pwd();
	});

	$('#cpwd').blur(function() {
		check_cpwd();
	});

	$('#phone').blur(function() {
		check_email();
	});

	$('#allow').click(function() {
		if($(this).is(':checked'))
		{
			error_check = false;
			$(this).siblings('span').hide();
		}
		else
		{
			error_check = true;
			$(this).siblings('span').html('请勾选同意');
			$(this).siblings('span').show();
		}
	});


	function check_user_name(){
		var username = $('#username').val();
		var len = username.length;
		if(len<3||len>20)
		{
			$('#username').next().html('请输入5-20个字符的用户名')
			$('#username').next().show();
			error_name = true;
		}
		else
		{
            $.ajax({
                url:'/user/check_user',
                type:'GET', //GET
                async:false,
                data:{
                    username:username,
                },
                timeout:5000,
                dataType:'json',
                success:function(data,textStatus,jqXHR){
					if (data.status==0){
                        $('#username').next().hide();
                        error_name = false;
					}else{
                        $('#username').next().html('用户名已存在')
                        $('#username').next().show();
					}
                },
            });

		}
	}

	function check_pwd(){
		var len = $('#password').val().length;
		if(len<8||len>20)
		{
			$('#password').next().html('密码最少8位，最长20位')
			$('#password').next().show();
			error_password = true;
		}
		else
		{
			$('#password').next().hide();
			error_password = false;
		}		
	}


	function check_cpwd(){
		var pass = $('#password').val();
		var cpass = $('#cpwd').val();

		if(pass!=cpass)
		{
			$('#cpwd').next().html('两次输入的密码不一致')
			$('#cpwd').next().show();
			error_check_password = true;
		}
		else
		{
			$('#cpwd').next().hide();
			error_check_password = false;
		}		
		
	}

	function check_email(){


		var re = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;

		if(re.test($('#phone').val()))
		{
			$('#phone').next().hide();
			error_email = false;
		}
		else
		{
			$('#phone').next().html('你输入的手机号格式不正确')
			$('#phone').next().show();
			error_check_password = true;
		}

	}


    $("#btn_register").click(function (e) {
        check_user_name();
        check_pwd();
        check_cpwd();
        check_email();

        if(!(error_name == false && error_password == false && error_check_password == false && error_email == false && error_check == false))
        {
            return;
        }

        var username = $('#username').val();
        var password = $('#password').val();
        var phone = $('#phone').val();
        $.ajax({
            url:'/user/register',
            type:'POST', //GET
            async:true,
            data:{
                username:username,
                password:password,
                phone:phone
            },
            timeout:5000,
            dataType:'json',
            success:function(data,textStatus,jqXHR){
                if (data.status==0) {
                    $('#stantard-dialogBox').dialogBox({
                        title: '校内闲鱼',
                        hasClose: true,
                        content: '注册成功'
                    });
                    setTimeout(function () {
                        window.location.href="/login";
                    }, 2000);
                }else{
                    $('#stantard-dialogBox').dialogBox({
                        title: '校内闲鱼',
                        hasClose: true,
                        content: '注册失败'
                    });
                }
            },
        });
    });


})