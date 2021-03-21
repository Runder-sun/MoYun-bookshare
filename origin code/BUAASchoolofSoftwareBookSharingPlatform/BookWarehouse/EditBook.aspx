<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="EditBook.aspx.cs" Inherits="BookWareHouse_EditBook" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-book"></span>
                    </div>
                    <h1>修改图书信息</h1>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="block">
                            <div class="head">                                
                                <h2><asp:Label ID = "headlabel" runat = "server" Font-Bold="True"></asp:Label></h2>                                 
                            </div>                                        
                            <div class="data-fluid">
                                
                                <div class="row-form">
                                    <div class="span3"><font size="2">书名</font></div>
                                    <div class="span9"><asp:TextBox type="text" id = "titletextbox" runat = "server" 
                                            ValidationGroup="a"/>
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server"
                                                ErrorMessage="不能为空" ControlToValidate="titletextbox" Display="Dynamic" 
                                            ForeColor="Red" ValidationGroup="a"></asp:RequiredFieldValidator></div>
                                </div>

                                <div class="row-form">
                                    <div class="span3"><font size="2">作者</font></div>
                                    <div class="span9"><asp:TextBox type="text" id = "authortextbox" runat = "server" 
                                            ValidationGroup="a"/>
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server"
                                                ErrorMessage="不能为空" ControlToValidate="authortextbox" 
                                            Display="Dynamic" ForeColor="Red" ValidationGroup="a"></asp:RequiredFieldValidator></div>
                                </div>

                                <div class="row-form">
                                    <div class="span3"><font size="2">出版社</font></div>
                                    <div class="span9"><asp:TextBox type="text" id = "publishertextbox" runat = "server"/></div>
                                </div>

                                <div class="row-form">
                                    <div class="span3"><font size="2">ISBN号</font></div>
                                    <div class="span9"><asp:TextBox type="text" id = "isbntextbox" runat = "server" 
                                            ValidationGroup="a"/>
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server"
                                                ErrorMessage="不能为空" ControlToValidate="isbntextbox" Display="Dynamic" 
                                            ForeColor="Red" ValidationGroup="a"></asp:RequiredFieldValidator><asp:CustomValidator
                                                    ID="CustomValidator1" runat="server" ErrorMessage="该书已存在" 
                                            ControlToValidate="isbntextbox" Display="Dynamic" ForeColor="Red" 
                                            onservervalidate="CustomValidator1_ServerValidate" ValidationGroup="a"></asp:CustomValidator></div>
                                </div>
                                <div class="row-form">
                                    <div class="span3"><font size="2">豆瓣链接</font></div>
                                    <div class="span9"><asp:TextBox type="text" id = "doubanlinktextbox" runat = "server"/></div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="span6">
                        <div class="block">
                            <div class="head">                                
                                <h2>&nbsp;</h2>                                 
                            </div>                                        
                            <div class="data-fluid">

                                <div class="row-form">
                                    <div class="span3"><font size="2">上传封面</font></div>
                                    <div class="span9">                            
                                        
                                        <font size="2">
                                        <asp:Button ID="coverimageuploadbutton" runat="server" Text="上传" 
                                            CssClass="btn btn-primary" onclick="coverimageuploadbutton_Click" />
                                        </font>                            
                                        
                                        <asp:FileUpload ID="coverimageupload" runat="server" 
                                            CssClass="btn btn-white" />
                                        <br />
                                        <asp:Label ID="coverimageuploadinfolabel" runat="server" ForeColor="Red"></asp:Label>
                                        <br />
                                        
                                        </div>                            
                                    </div>
                                </div>   
                                <div class="row-form">
                                    <div class="span3"><font size="2">上传电子书</div>
                                    <div class="span9">                            
                                        
                                        <font size="2">
                                        <asp:Button ID="bookuploadbutton" runat="server" Text="上传" 
                                            CssClass="btn btn-success" onclick="sourceuploadbutton_Click" />
                                        </font>                            
                                        
                                        <asp:FileUpload ID="bookupload" runat="server" CssClass="btn btn-white" />
                                        <br />
                                        <asp:Label ID="bookuploadinfolabel" runat="server" ForeColor="Red"></asp:Label>
                                        <br />
                                        
                                        </div>                            
                                    </div>
                                </div>   

                                <div class="row-form">
                                    <div class="span3"><font size="2">图书介绍</div>
                                    <div class="span9"><asp:TextBox ID = "introtextbox" runat = "server" 
                                            TextMode="MultiLine" /></div>
                                </div>        

                                <div><br \><br \><br \></div>

                                <div class="row-form">
                                    <div class="span12" align="center">
                                        <asp:Button class="btn btn-warning" ID = "confirmbutton" runat = "server" 
                                            Text="保存修改" ValidationGroup="a" onclick="confirmbutton_Click"> </asp:Button>
                                        
                                    </div>                
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        
    </div>
</asp:Content>

