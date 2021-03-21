<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="PersonalWeb_Login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />    
    <!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->                
    <title>登录-墨韵读书会</title>
    <link rel="icon" type="../image/ico" href="favicon.ico"/>
    
    <link href="../css/stylesheets.css" rel="stylesheet" type="text/css" />
    <!--[if lte IE 7]>
        <link href="css/ie.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='js/plugins/other/lte-ie7.js'></script>
    <![endif]-->     
    <script type='text/javascript' src='../js/plugins/jquery/jquery-1.9.1.min.js'></script>
    <script type='text/javascript' src='../js/plugins/jquery/jquery-ui-1.10.1.custom.min.js'></script>
    <script type='text/javascript' src='../js/plugins/jquery/jquery-migrate-1.1.1.min.js'></script>
    <script type='text/javascript' src='../js/plugins/jquery/globalize.js'></script>
    <script type='text/javascript' src='../js/plugins/other/excanvas.js'></script>
    
    <script type='text/javascript' src='../js/plugins/other/jquery.mousewheel.min.js'></script>
        
    <script type='text/javascript' src='../js/plugins/bootstrap/bootstrap.min.js'></script>
    
    <script type='text/javascript' src='../js/plugins/cookies/jquery.cookies.2.2.0.min.js'></script>    
    
    <script type='text/javascript' src='../js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js'></script>    
    
    <script type='text/javascript' src="../js/plugins/uniform/jquery.uniform.min.js"></script>
    <script type='text/javascript' src="../js/plugins/select/select2.min.js"></script>
    <script type='text/javascript' src='../js/plugins/tagsinput/jquery.tagsinput.min.js'></script>
    <script type='text/javascript' src='../js/plugins/maskedinput/jquery.maskedinput-1.3.min.js'></script>
    <script type='text/javascript' src='../js/plugins/multiselect/jquery.multi-select.min.js'></script>
    
    <script type='text/javascript' src='../js/plugins/shbrush/XRegExp.js'></script>
    <script type='text/javascript' src='../js/plugins/shbrush/shCore.js'></script>
    <script type='text/javascript' src='../js/plugins/shbrush/shBrushXml.js'></script>
    <script type='text/javascript' src='../js/plugins/shbrush/shBrushJScript.js'></script>
    <script type='text/javascript' src='../js/plugins/shbrush/shBrushCss.js'></script>    
    
    <script type='text/javascript' src='../js/plugins.js'></script>
    <script type='text/javascript' src='../js/charts.js'></script>
    <script type='text/javascript' src='../js/actions.js'></script>  
</head>
<body>
    <form id="form1" runat="server">
    <div id="loader"><img src="../img/loader.gif"/></div>
       
    <div class="login">

        <div class="page-header">
            <div class="icon">
                <span class="ico-arrow-right"></span>
            </div>
            <h1><font face="微软雅黑">欢迎使用</font><small><font size="2">墨韵读书会交流平台</font></small></h1>
        </div>        
        <br>
        <asp:Label ID="Label1" runat="server" ForeColor="Red"></asp:Label>
        </br>
        <div class="row-fluid">
            <div class="row-form">
                <div class="span12">
                    <input id="acc" runat="server" type="text" name="login" placeholder="请输入学号" 
                        validationgroup="1"/>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                        ErrorMessage="账号不能为空" ControlToValidate="acc" ForeColor="Red" 
                        ValidationGroup="1"></asp:RequiredFieldValidator>
                </div>
            </div>
            <div class="row-form">
                <div class="span12">
                    <input id="pass" runat="server" type="password" name="password" placeholder="请输入密码" 
                        validationgroup="1"/>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                        ErrorMessage="密码不能为空" ControlToValidate="pass" ForeColor="Red" 
                        ValidationGroup="1"></asp:RequiredFieldValidator>
                </div>            
            </div>
            <div>
                <br />
            </div>
            <div>
                <input id="std" runat="server" name="identity" type="radio" value="student" checked="true">学生    
                <input id="tea" runat="server" name="identity" type="radio" value="teacher">教师    
                <input id="adm" runat="server" name="identity" type="radio" value="administrator">管理员
            </div>
            <div>
                <br />
            </div>
            
            <!--div class="style5">
                <asp:DropDownList ID="DropDownList1" runat="server">
                <asp:ListItem>学生</asp:ListItem>
                <asp:ListItem>教师</asp:ListItem>
                <asp:ListItem>管理员</asp:ListItem>
                </asp:DropDownList>
            </div>
            <div class="row-form">
                <div class="span12">
                    <input type="checkbox"/> Keep me signed in
                </div>
            </div-->
            <div class="row-form">
                <div class="span12">
                    <asp:button id="login" runat="server" class="btn" Text="登陆" CssClass="btn" 
                        OnClick="Login_onclick" ValidationGroup="1"></asp:button>
                    <button id="reg" runat="server" class="btn btn-success" onserverclick="Reg_onclick"><font size="2">注册</font> </button>
                    <button id="lost" runat="server" class="btn btn-warning" onserverclick="Lost_Pass_onclick"><font size="2">忘记密码</font> </button>
                </div>                
            </div>
        </div>
    </div>
    
    </form>
</body>
</html>
