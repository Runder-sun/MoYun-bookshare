<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="WriteBlog.aspx.cs" Inherits="PersonalWeb_WriteBlog" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>日志撰写</h1>
                </div>
                <div class="row-fluid">

                    <div class="span12">
                        <div class="block">
                            <div class="head yellow">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>博文题目</h2>
                                <ul class="buttons">             
                                    <li><a href="#" onClick="source('editor_cl'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>
                            </div>
                            
                            <div class="row-form">
                                    <div class="span9"><input id="title" runat="server" type="text" Width="100%"/><asp:RequiredFieldValidator 
                                            ID="RequiredFieldValidator1" runat="server" ErrorMessage="日志标题不能为空哦~" 
                                            ForeColor="Red" ControlToValidate="title" Width="100%"></asp:RequiredFieldValidator>
                                    </div>
                            </div>
                        </div>
                        <div class="block">
                            <div class="head green">
                                <div class="icon"><i class="ico-grid"></i></div>                                
                                <h2>日志正文</h2>
                                <ul class="buttons">             
                                    <li><a href="#" onclick="source('editor_cl'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                
                            </div>
                            <div class="data-fluid editor">

                                <asp:TextBox ID="blogcontent" runat="server" width="100%" Height="400px" 
                                TextMode="MultiLine" BackColor="White" BorderStyle="NotSet" ForeColor="Black"></asp:TextBox>
                                
                                
                                <!--<asp:TextBox ID="content" runat="server" style="height: 300px;" 
                                    TextMode="MultiLine" Width="1060px"></asp:TextBox>-->

                            </div>
                        </div>               

                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                            ControlToValidate="blogcontent" ErrorMessage="什么都还没写呢~赶快写点儿神马吧" 
                            ForeColor="Red"></asp:RequiredFieldValidator>

                    </div>



                </div> 
                <div class="row-form">
                    <div class="span12">
                        <button id="submit" runat="server" onserverclick="Submit_onclick" class="btn btn-warning"><font size="2">发  表</font> <span class="ico-ok"></span></button>
                        <button id="return" runat="server" onserverclick="Return_onclick" class="btn"><font size="2">返  回</font> <span class="ico-reply"></span></button>
                </div>                  
                
            </div>
    
    <script>

        var ckeditor = CKEDITOR.replace('ckeditor');

        CKEDITOR.disableAutoInline = true;
        CKEDITOR.inline('editable');

    </script>   
</asp:Content>

