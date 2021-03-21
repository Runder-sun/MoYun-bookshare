<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Register2.aspx.cs" Inherits="PersonalWeb_Register2" %>

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
                    <div class="block"><span class="新建样式1"><font size="4">    第二步 个人信息</span> </div>
                </div>

                <div class="row-fluid">

                    <div class="span6">                

                        <div class="block">
                            <div class="data-fluid">
                                            
                                <div class="row-form">
                                    <div class="span3"><font size="2">性别</font></div>
                                    <div class="span9">
                                        <input id="sex_f" runat="server" type="radio" checked="true" name="r_example" value="1"/><font size="2">男生</font>
                                        <input id="sex_m" runat="server" type="radio" name="r_example" value="2"/><font size="2">女生</font>
                                    </div>
                                </div>
                                <div>
                                    <br />
                                </div>
                                <div class="row-form">
                                    <div class="span3"><font size="2">身份</font></div>
                                    <div class="span9">
                                        <input id="id_stu" runat="server" type="radio" checked="true" name="r_example1" value="1"/><font size="2">学生</font>
                                        <input id="id_tea" runat="server" type="radio" name="r_example1" value="2"/><font size="2">教师</font>
                                    </div>
                                </div>

                                <div>
                                    <br />
                                </div>
                                <div class="row-form">
                                    <div class="span3"><font size="2">年级</font></div>
                                    <div class="span9">
                                        <input id="gra_12" runat="server" type="radio" checked="true" name="r_example2" value="1"/><font size="2">12级</font>
                                        <input id="gra_13" runat="server" type="radio" name="r_example2" value="2"/><font size="2">13级</font>
                                        <input id="gra_14" runat="server" type="radio" name="r_example2" value="3"/><font size="2">14级</font>
                                        <input id="gra_15" runat="server" type="radio" name="r_example2" value="4"/><font size="2">15级</font>
                                    </div>
                                    <div class="span3" ><font color="red" size="2">(老师可以不用选择)</font></div>
                                </div>
                          
                                <div class="row-form">
                                    <div class="span3"><font size="2">生日</font></div>
                                    <div class="span9">
                                        <input id="birth" runat="server" type="text" class="mask_date" value=""/>
                                        <span class="bottom"><font size="2">示例： 2013-08-29</font></span>
                                    </div>
                                </div>

                                <div class="row-form">
                                    <div class="span3"><font size="2">邮箱</font></div>
                                    <div class="span9">
                                        <input id="email" runat="server" type="text" class="email" value=""/>
                                        <span class="bottom"><font size="2">示例： smaple@sample.com</font></span>
                                        <font size="2"><asp:RegularExpressionValidator 
                                            ID="RegularExpressionValidator1" runat="server" ErrorMessage="邮箱格式不正确" 
                                            ForeColor="Red" 
                                            ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" 
                                            ControlToValidate="email"></asp:RegularExpressionValidator>
                                        </font>&nbsp;</div>
                                </div>

                                <div class="row-form">
                                    <div class="span12">
                                        <button id="next" runat="server" class="btn btn-success" onserverclick="Next_onclick"><font size="2">下一步</font> <span class="icon-arrow-next icon-white"></span></button>
                                        <button id="return" runat="server" class="btn btn-primary" onserverclick="Return_onclick"><font size="2" onserverclick="Return_onclick" >返  回</font> <span class="ico-reply"></span></button>
                                    </div>                
                                </div>

                            </div>
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
