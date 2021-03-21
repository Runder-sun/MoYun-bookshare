<%@ Page Title="" Language="C#" MasterPageFile="~/Setting_Help/Set_Help.master" AutoEventWireup="true" CodeFile="Log_Out.aspx.cs" Inherits="Setting_Help_Log_Out" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <style>
.UserLable
{
    font-size:25px;
    font-family:微软雅黑;
    color:Black
}
</style>
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-edit"></span>
                    </div>
                    <h1>注销登陆</h1>
                </div>

                <div class="row-fluid" align="center">
                    <div class="span6" align="center">
                        <div class="block">
                            <div class="head">                                
                                    <asp:Label ID="UserID" runat="server" Text="Label" CssClass="UserLable"></asp:Label>
                                    <font color="black" size="3">
                                    <br \>
                                  <h2><small><br \>您现在要退出登陆，是否确认注销？</small></h2>                                 
                            </div>                                        
                            <div class="data-fluid">
                                
                                
                        </div>
                    </div>
                        <div class="row-form">
                                    <div class="span12" align="center">
                                        <button id="logout" runat="server" onserverclick="Log_Out_onclick" class="btn btn-primary"><font size="2">确定注销</font> <span class="icon-arrow-next icon-white"></span></button>
                                        <button id="return" runat="server" onserverclick="Return_onclick" class="btn btn-info"><font size="2">返回主页</font> <span class="ico-reply"></span></button>
                                    </div>                
                                </div>

                </div>


            </div>
            
        </div>
        
    </div>
    
</asp:Content>

