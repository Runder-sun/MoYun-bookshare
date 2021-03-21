<%@ Page Title="" Language="C#" MasterPageFile="~/Administer/Administer.master" AutoEventWireup="true" CodeFile="404NotFound.aspx.cs" Inherits="Administer_404NotFound" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="errorContainer">
        <h1>404</h1>
        <h2><font face="微软雅黑" size="5">您请求的页面找不到了T-T</font></h2>
        <br \>
           <button id="host" runat="Server" onserverclick="Host_onclick" class="btn btn-warning">
                     <font size="2">回到主页</font>
                     <span class="ico-pin-2"></span>
           </button>
           <button id="return" runat="Server" onserverclick="Return_onclick" class="btn btn-info">
                      <font size="2">上一页面</font>
                      <span class="ico-reply"></span>
           </button>
                                                   
                                
    </div>            
    
</asp:Content>

