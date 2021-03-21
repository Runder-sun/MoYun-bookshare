<%@ Page Language="C#" AutoEventWireup="true" CodeFile="PlatHome.aspx.cs" Inherits="PlatHome_PlatHome" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>        
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />    
    <!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />        
    <![endif]-->                
    <title>平台首页-墨韵读书会</title>
    <link rel="icon" type="../image/ico" href="../favicon.ico"/>
    
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
    
    <script type='text/javascript' src="../js/plugins/uniform/jquery.uniform.min.js"></script>
    
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
<script language="javascript">
    function IsNull() {
        debugger;
        var id = '<%=Session["QuanZiID"]%>';
        var ide = '<%=Session["Identity"]%>';

        if (ide == "学生" && id == "") alert("你还没加入圈子呢！赶快去找导师申请吧~");
        else if (ide == "教师" && id == "") window.location.href = "../QuanZi/CreateQuanZi.aspx";
        else if (ide == "教师") window.location.href = "../QuanZi/ScanInfo.aspx";
        else window.location.href = "../QuanZi/ScanInfo_other.aspx";
    }
</script>       
    <div id="loader"><img src="img/loader.gif"/></div>
    <div class="wrapper">
        
        <div class="sidebar">
            
            <div class="top">
                <div class="item" align="center"><asp:Image ID="UserImage" runat="server" ImageUrl="~/PersonalImage/Default.gif" Width="120" /></div>
                <div class="text" align="center"><br \>
                    <a> <font size="4px" color="white">
                        <asp:Label ID="Name" runat="server" Text="杨婧" CssClass="Label" 
                        Font-Size="18px" ForeColor="White"></asp:Label> 
                     <font size="2px" color="gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Label ID="Grade" runat="server" Text="14级本科生" Font-Size="12px" 
                        ForeColor="White"></asp:Label>
                  </font></a><font size="2px" color="gray">
                </div>
                <div class="text" align="center"><br \>
                    <br />
                    <asp:Label ID="SigLable" runat="server" Text="个性签名:" CssClass="SignatureLable" 
                         Font-Size="15px" ForeColor="#FF6600"></asp:Label>
                    <br />
                    <!--<a href="index-2.html" class="blgreen">-->
                    <asp:Label ID="Signature" runat="server" Text="暮冬时烤雪 迟夏写长信" CssClass="Signature" 
                         Font-Size="12px" ForeColor="#FF6600"></asp:Label>
                    <br \>
                </div>
            </div>
                
            <div class="nContainer">                
                <ul class="navigation bordered">         
                    <li class="active"><a href="../PlatHome/PlatHome.aspx" class="blblue">平台主页</a></li>
                    <li>
                      <a href="#" class="blyellow">个人空间</a>
                        <div class="open"></div>
                        <ul>
                            <li><a href="../PersonalWeb/PersonalHome.aspx">空间主页</a></li>
                            <li><a href="../PersonalWeb/ScanInfo.aspx">我的信息</a></li>
                            <li><a href="../PersonalWeb/Letter.aspx">站内消息</a></li>
                            <li><a href="../PersonalWeb/FriendList.aspx">小伙伴们</a></li>
                            <li><a href="../PersonalWeb/FriendList.aspx">个人日志</a></li>
                            <li><a href="../PersonalWeb/MessageBox.aspx">留言通讯</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="blgreen">我的圈子</a>
                        <div class="open"></div>
                        <ul>
                            <li><a href="../QuanZi/QuanZiIndex.aspx">圈子主页</a></li>
                            <li><a href="../QuanZi/ScanInfo.aspx">圈子信息</a></li>
                            <li><a href="../QuanZi/ForumList.aspx">讨论区</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="blpurple">墨韵书库</a>
                        <div class="open"></div>
                        <ul>
                            <li><a href="../BookWarehouse/BookWareHouse.aspx">书库首页</a></li>
                            <li><a href="../BookWarehouse/AddBook.aspx">添加新书</a></li>
                            <li><a href="../BookWarehouse/BookReview.aspx">我的书评</a></li>
                            <li><a href="../BookWarehouse/SearchBook.aspx">检索书籍</a></li>
                        </ul>                    
                    </li>
                    <li>
                        <a href="#" class="blorange">设置帮助</a>
                        <div class="open"></div>
                        <ul>
                            <li><a href="../Setting_Help/AboutUs.aspx">关于我们</a></li>
                            <li><a href="../Setting_Help/Log_Out.aspx">注销登陆</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="close">
                    <span class="ico-remove"></span>
                </a>
            </div>
            <div class="widget">
                <div class="datepicker"></div>
            </div>
            
        </div>
        
        <div class="body">
            
            <ul class="navigation">
                <li>
                    <a href="../PlatHome/PlatHome.aspx" class="button">
                        <div class="icon">
                            <span class="ico-monitor"></span>
                        </div>                    
                        <div class="name">平台主页</div>
                    </a>                
                </li>
                <li>
                    <a href="../PersonalWeb/PersonalHome.aspx" class="button yellow">
                        <div class="icon">
                            <span class="ico-cloud"></span>
                        </div>                    
                        <div class="name">个人空间</div>
                    </a> 
                </li>                
                <li>
                    <a href="javascript:IsNull(this)" class="button green">
                        <!--div class="arrow"></!--div-->
                        <div class="icon">
                            <span class="ico-layout-7"></span>
                        </div>                    
                        <div class="name">我的圈子</div>
                    </a>                                
                </li>                        
                
                <li>
                    <a href="../BookWarehouse/BookWareHouse.aspx" class="button purple">
                        <div class="icon">
                            <span class="ico-box"></span>
                        </div>                    
                        <div class="name">墨韵书库</div>
                    </a>                                               
                </li>
                <li>
                    <a href="../Setting_Help/Log_Out.aspx" class="button orange">
                        <div class="icon">
                            <span class="ico-cog-2"></span>
                        </div>                    
                        <div class="name">设置帮助</div>
                    </a>      
                                                          
                </li>                
                
            </ul>
            
            
            <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-arrow-right"></span>
                    </div>
                    <h1>平台主页<small>Plat Home</small></h1>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <div class="block title">
                            <div class="head blue">
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>今日统计</h2>
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('widgets'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                            
                            </div>
                        </div>s
                        <div class="widgets">
                            <div class="widget orange value">
                                <div class="left"><asp:Label ID="today_blog" runat="server" Text="0"></asp:Label></div>
                                <div class="right">
                                    <asp:Label ID="blog1" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="blog2" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="blog3" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="blog4" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="blog5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日博文发表量</a>
                                </div>
                            </div>
                            <div class="widget dblue value">
                                <div class="left"><asp:Label ID="today_book" runat="server" Text="0"></asp:Label></div>
                                <div class="right">
                                    <asp:Label ID="book1" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="book2" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="book3" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="book4" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="book5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日新书上传量</a>
                                </div>
                            </div>
                            <div class="widget green value">
                                <div class="left"><asp:Label ID="today_com" runat="server" Text="0"></asp:Label></div>
                                <div class="right">
                                    <asp:Label ID="com1" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="com2" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="com3" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="com4" runat="server" Text=""></asp:Label><br/>
                                    <asp:Label ID="com5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日书评撰写量</a>
                                </div>
                            </div>           
                        </div>
                    </div>
                </div>   

                <div class="row-fluid">
                    <div class="span12">
                        <div class="block title">
                            <div class="head yellow">
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>历史统计</h2>
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('widgets'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                            
                            </div>
                        </div>
                        <div class="widgets">
                            <div class="widget orange icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-lamp-3"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前博文发表量</td><td><asp:Label ID="last_blog1" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>4日前博文发表量</td><td><asp:Label ID="last_blog2" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>3日前博文发表量</td><td><asp:Label ID="last_blog3" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>2日前博文发表量</td><td><asp:Label ID="last_blog4" runat="server" Text="0"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                            <td>1日前博文发表量</td><td><asp:Label ID="last_blog5" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史博文发表量</a>
                                </div>                            
                            </div>
                             <div class="widget dblue icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-lamp-3"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前讨论区创办量</td><td><asp:Label ID="last_forum1" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>4日前讨论区创办量</td><td><asp:Label ID="last_forum2" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>3日前讨论区创办量</td><td><asp:Label ID="last_forum3" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>2日前讨论区创办量</td><td><asp:Label ID="last_forum4" runat="server" Text="0"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                            <td>1日前讨论区创办量</td><td><asp:Label ID="last_forum5" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史新书上传量</a>
                                </div>                            
                            </div>
                            <div class="widget green icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-lamp-3"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前书评撰写量</td><td><asp:Label ID="last_com1" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>4日前书评撰写量</td><td><asp:Label ID="last_com2" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>3日前书评撰写量</td><td><asp:Label ID="last_com3" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                        <tr>
                                            <td>2日前书评撰写量</td><td><asp:Label ID="last_com4" runat="server" Text="0"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                            <td>1日前书评撰写量</td><td><asp:Label ID="last_com5" runat="server" Text="0"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史书评撰写量</a>
                                </div>                            
                            </div>
                        </div>
                    </div>
                </div> 
                <div class="row-fluid">
                    
                        <div class="block title">
                            <div class="head purple">
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>图书分类数目统计</h2>
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('widgets'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                            
                            </div>
                        </div>
                    <div class="span12" align="center">
                         <a href="#" class="swidget red">
                                <div class="value">
                                    <asp:Label ID="liter_num" runat="server" Text="0"></asp:Label>
                                </div>           
                                <div class="bottom">
                                    <div class="text">文学</div>                                                                 
                                </div>                                                                
                            </a>   
                        <a href="#" class="swidget yellow">
                                <div class="value"> 
                                   <div class="text"><asp:Label ID="popu_num" runat="server" Text="0"></asp:Label></div> 
                                </div>           
                                <div class="bottom">
                                     流行                                                       
                                </div>                                                                
                            </a>   
                        <a href="#" class="swidget dblue">
                                <div class="value">
                                   <div class="text"><asp:Label ID="cus_num" runat="server" Text="0"></asp:Label></div>        
                                </div>           
                                <div class="bottom">
                                        文化                                                    
                                </div>                                                                
                            </a>   
                        <a href="#" class="swidget green">
                                <div class="value">
                                    <asp:Label ID="life_num" runat="server" Text="0"></asp:Label>
                                </div>           
                                <div class="bottom">
                                    <div class="text">生活</div>                                                                 
                                </div>                                                                
                            </a>   
                        <a href="#" class="swidget blue">
                                <div class="value">
                                    <asp:Label ID="ecom_num" runat="server" Text="0"></asp:Label>
                                </div>           
                                <div class="bottom">
                                    <div class="text">经济</div>                                                                 
                                </div>                                                                
                            </a>   
                        <a href="#" class="swidget orange">
                                <div class="value">
                                    <asp:Label ID="tec_num" runat="server" Text="0"></asp:Label>
                                </div>           
                                <div class="bottom">
                                    <div class="text">科技</div>                                                                 
                                </div>                                                                
                            </a>   
                    </div>
                </div>
            </div>
            
        </div>
        
    </div>
    
    <div class="dialog" id="source" style="display: none;" title="Source"></div>
    
</body>
</html>
