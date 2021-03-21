<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="PersonalHome.aspx.cs" Inherits="PersonalWeb_Personal_Home" %>

<%@ Register Assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35"
    Namespace="System.Web.UI.DataVisualization.Charting" TagPrefix="asp" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-arrow-right"></span>
                    </div>
                    <h1>个人主页<small>Personal Homepage</small></h1>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <div class="widgets">
                            <div class="widget blue value">
                                <div class="left"><asp:Label ID="today_visit" runat="server" Text="0"></asp:Label>
                                </div>
                                <div class="right">
                                   <asp:Label ID="today1_name1" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today1_name2" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today1_name3" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today1_name4" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today1_name5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日来访量</a>
                                </div>
                            </div>
                            <div class="widget green value">
                                <div class="left"><asp:Label ID="today_message" runat="server" Text="0"></asp:Label></div>
                                <div class="right">
                                   <asp:Label ID="today2_name1" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today2_name2" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today2_name3" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today2_name4" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today2_name5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日留言量</a>
                                </div>
                            </div>
                            <div class="widget orange value">
                                <div class="left">
                                <asp:Label ID="today_conment" runat="server" Text="0"></asp:Label>
                                </div>
                                <div class="right">
                                   <asp:Label ID="today3_name1" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today3_name2" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today3_name3" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today3_name4" runat="server" Text=""></asp:Label><br/>
                                   <asp:Label ID="today3_name5" runat="server" Text=""></asp:Label><br/>
                                </div>
                                <div class="bottom">
                                    <a href="#">今日日志评论量</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <div class="widgets">
                            <div class="widget purple icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-user"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前访问量</td><td><asp:Label ID="last1_day5" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>4日前访问量</td><td><asp:Label ID="last1_day4" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>3日前访问量</td><td><asp:Label ID="last1_day3" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>2日前访问量</td><td><asp:Label ID="last1_day2" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>1日前访问量</td><td><asp:Label ID="last1_day1" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史访问记录</a>
                                </div>                            
                            </div>
                            <div class="widget red icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-comment"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前留言量</td><td><asp:Label ID="last2_day5" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>4日前留言量</td><td><asp:Label ID="last2_day4" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>3日前留言量</td><td><asp:Label ID="last2_day3" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>2日前留言量</td><td><asp:Label ID="last2_day2" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>1日前留言量</td><td><asp:Label ID="last2_day1" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史留言记录</a>
                                </div>                            
                            </div>
                            <div class="widget yellow icon">
                                <div class="left">
                                    <div class="icon">
                                        <span class="ico-heart-4"></span>
                                    </div>
                                </div>
                                <div class="right">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td>5日前日志评论量</td><td><asp:Label ID="last3_day5" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>4日前日志评论量</td><td><asp:Label ID="last3_day4" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                        <tr>
                                         <td>3日前日志评论量</td><td><asp:Label ID="last3_day3" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>2日前日志评论量</td><td><asp:Label ID="last3_day2" runat="server" Text="Label"></asp:Label></td> 
                                        </tr>
                                        <tr>
                                         <td>1日前日志评论量</td><td><asp:Label ID="last3_day1" runat="server" Text="Label"></asp:Label></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="bottom">
                                    <a href="#">历史访问记录</a>
                                </div>                            
                            </div>
                        </div>
                    </div>
                    <div class="span12" align="center"><br \>
                        </div>                
                </div>
                
            </div>
            
        </div>
        
    </div>
    
</asp:Content>

