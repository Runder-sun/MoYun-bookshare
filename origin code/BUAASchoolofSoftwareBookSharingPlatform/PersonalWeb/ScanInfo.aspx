<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="ScanInfo.aspx.cs" Inherits="PersonalWeb_ScanInfo" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-user"></span>
                    </div>
                    <h1>我的信息</h1>
                </div>
               <div class="row-fluid">
                     <div class="span4">
                        <div class="block">
                            <div class="head yellow">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>账户信息</h2>
                            </div>
                            <div class="row-form">
                                    <div class="span2"><font size="2">账号</font></div>
                                    <div class="span2"><asp:TextBox ID="acc" runat="server" 
                                            Enabled="False"/></div>
                            </div><br />
                            <div class="row-form">
                                    <div class="span2"><font size="2">原密码</font></div>
                                    <div class="span2"><asp:TextBox ID="opass" runat="server" TextMode="Password"/></div>
                            </div><br />
                            <div class="row-form">
                                    <div class="span2"><font size="2">新密码</font></div>
                                    <div class="span2"><asp:TextBox ID="pass1" runat="server" TextMode="Password"/></div>
                            </div><br />
                            <div class="row-form">
                                    <div class="span2"><font size="2">新密码</font></div>
                                    <div class="span2"><asp:TextBox ID="pass2" runat="server" TextMode="Password"/></div>
                            </div><br />
                        </div>                          
                     </div>
                     <div class="span4">
                        <div class="block">
                            <div class="head blue">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>个人信息</h2>
                            </div>
                            
                            <div class="row-form">
                                    <div class="span2"><font size="2">姓名</font></div>
                                    <div class="span2"><asp:TextBox ID="name" runat="server"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span2"><font size="2">身份</font></div>
                                    <div class="span2"><asp:TextBox ID="iden" runat="server" Enabled="False" 
                                            BackColor="White"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span2"><font size="2">生日</font></div>
                                    <div class="span2"><asp:TextBox ID="birth" runat="server"/></div>
                            </div>
                            <div class="row-form">
                                <div class="span2"><font size="2">年级</font></div>
                                <div class="span2">
                                        <select id="sel" runat="server" name="s_example" class="select" >
                                            <option value="0">2012</option>
                                            <option value="1">2013</option>
                                            <option value="2">2014</option>
                                            <option value="3">2015</option>                                                                     
                                        </select>
                                </div>
                            </div>
                            <div class="row-form">
                                    <div class="span2"><font size="2">邮箱</font></div>
                                    <div class="span2"><asp:TextBox ID="email" runat="server"/>
                                        <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                                            ControlToValidate="email" ErrorMessage="邮箱格式不正确" ForeColor="Red" 
                                            ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
                                    </div>
                            </div>
                            
                             
                            
                        </div>                          
                     </div>
                     <div class="span4">
                        <div class="block">
                            <div class="head orange">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>其他信息</h2>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2">头像</font></div>
                                    <div class="span9">                            
                                        <!--<div class="input-append file">-->
                                            <asp:FileUpload ID="pesImage" runat="server" CssClass="btn-block"/>                  
                                                             
                                        <!--</div>-->                            
                                    </div>
                                </div>
                            <br /><br />
                            <div class="span3"><font size="2">签名</font></div>
                            <div class="span9">
                               <div class="data" align="center">
                                   <asp:TextBox ID="signa" runat="server" TextMode="MultiLine" Height="115px"/>
                               </div>
                            </div>  
                        </div>                          
                     </div>                     
                </div>
                <div class="row-fluid">
                    <div class="span12" align="center">
                        <br \><br \>
                        <button id ="save" runat="server" onserverclick="Save_onclick" class="btn">
                           <font size="2">保存</font> <span class="ico-cog"></span></button>
                        <button id ="modify" runat="server" onserverclick="Modify_onclick" class="btn btn-success">
                           <font size="2">修改信息</font> <span class="ico-cog"></span></button>
                    </div> 
                </div>
            </div>
            
        </div>
        
    </div>
    
   
</asp:Content>

