<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb_other/个人页面_other.master" AutoEventWireup="true" CodeFile="ScanInfo_other.aspx.cs" Inherits="PersonalWeb_other_ScanInfo_other" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-user"></span>
                    </div>
                    <h1>他的信息</h1>
                </div>
               <div class="row-fluid">
                     <div class="span4">
                        <div class="block">
                            <div class="head yellow">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>账户信息</h2>
                            </div>
                            
                            <div class="row-form">
                                    <div class="span3"><font size="2px">账号</font></div>
                                    <div class="span9"><input id="acc" runat="server" type="text" readonly="readonly"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">姓名</font></div>
                                    <div class="span9"><input id="name" runat="server" type="text" readonly="readonly"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">身份</font></div>
                                    <div class="span9"><input id="iden" runat="server" type="text" readonly="readonly"/></div>
                            </div>
                        </div>                          
                     </div>
                     <div class="span4">
                        <div class="block">
                            <div class="head blue">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>个人信息</h2>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">生日</font></div>
                                    <div class="span9"><input id="birth" runat="server" type="text" readonly="readonly"/></div>
                            </div>
                            <!--div class="row-form">
                                    <div class="span3">邮箱</div>
                                    <div class="span9"><input type="text" value="dujunyi@2c.com" readonly="readonly"/></div>
                            </div-->
                            <div class="row-form">
                                    <div class="span3"><font size="2px">性别</font></div>
                                    <div class="span9"><input  id="sex" runat="server" type="text"  readonly="readonly"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">年级</font></div>
                                    <div class="span9"><input  id="grade" runat="server" type="text" readonly="readonly"/></div>
                            </div>
                        </div>                          
                     </div>
                     <div class="span4">
                        <div class="block">
                            <div class="head orange">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2><font size="2px">个性签名<font></h2>
                            </div>
                            <div class="data" align="center">
                                <asp:TextBox ID="singn" runat="server" Height="115px" Enabled="False" TextMode="MultiLine"></asp:TextBox>
                            </div>
                        </div>                          
                     </div>                     
                </div>
            </div>
</asp:Content>

