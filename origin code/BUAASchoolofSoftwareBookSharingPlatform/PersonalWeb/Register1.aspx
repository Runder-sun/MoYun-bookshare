<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Register1.aspx.cs" Inherits="PersonalWeb_Register1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />    
    <!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->                
    <title>注册-墨韵读书会</title>
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
    
    <style type="text/css">
        .新建样式1
        {
            font-family: 微软雅黑;
        }
    </style>
    
</head>
<body>
    <form id="form1" runat="server">
    <div id="loader"><img src="../img/loader.gif"/></div>
    <div class="wrapper">
        
        <div class="body">
            
 
            <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-pen-2"></span>
                    </div>
                    <h1><span class="新建样式1">注册</span> <small>墨韵读书会交流平台</small></h1>
                </div>

                <div>
                    <div class="block"><span class="新建样式1"><font size="4">    第一步 账户信息</span> </div>
                </div>
                
                <div class="row-fluid">

                    <div class="span6">                

                        <div class="block">
                          <div class="data-fluid">
                                
                                <div class="row-form">
                                     <div class="span12">
                                          <input id="acc" runat="server" type="text" name="login" placeholder="请输入账号"/><font size="4"><asp:RequiredFieldValidator 
                                              ID="RequiredFieldValidator1" runat="server" 
                                              ErrorMessage="账号不能为空" ControlToValidate="acc" ForeColor="Red"></asp:RequiredFieldValidator>
                                          </font>&nbsp;</div>
                                </div>
                                <div class="row-form">
                                    <div class="span12"><input id="pass1" runat="server" type="password" placeholder="请输入密码"/><asp:RequiredFieldValidator 
                                            ID="RequiredFieldValidator2" runat="server" 
                                            ErrorMessage="密码不能为空" ControlToValidate="pass1" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </div>
                                </div>
                                 <div class="row-form">
                                    <div class="span12"><input id="pass2" runat="server" type="password" placeholder="请再次输入密码"/><asp:RequiredFieldValidator 
                                            ID="RequiredFieldValidator3" runat="server" 
                                            ErrorMessage="密码不能为空" ControlToValidate="pass2" ForeColor="Red"></asp:RequiredFieldValidator>
                                     </div>
                                </div>
                                <div>
                                    <div class="row-form">
                                    <div class="span12"><input id="name" runat="server" type="text" placeholder="请输入姓名"/><asp:RequiredFieldValidator 
                                            ID="RequiredFieldValidator4" runat="server" 
                                            ErrorMessage="姓名不能为空" ControlToValidate="name" ForeColor="Red"></asp:RequiredFieldValidator>
                                        </div>  
                                </div>
                               
                        </div>

                    </div>

                        <div class="row-form">
                <div class="span12">
                    <button id="next" runat="server" class="btn btn-warning" onserverclick="next_onclick"><font size="2">下一步</font> <span class="icon-arrow-next icon-white"></span></button>
                    <button id="return" runat="server" class="btn btn-primary"><font size="2" onserverclick="return_onclick">返  回</font> <span class="ico-reply"></span></button>
                </div>                
                       </div>

                </div>                
                
                
            </div>
            
        </div>
        
    </div>
    
    <div class="dialog" id="source" style="display: none;" title="Source"></div>    
    </form>
</body>
</html>
