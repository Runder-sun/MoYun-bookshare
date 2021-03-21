<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="CreateQuanZi.aspx.cs" Inherits="QuanZi_CreateQuanZi" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content_book">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-chat-3"></span>
                    </div>
                    <h1>创建圈子</h1>
                </div>
    <asp:Label ID="Label1" runat="server" Text="圈子名称：" Width="100px"></asp:Label>
    <asp:TextBox ID="quanzinametextbox" runat="server" ValidationGroup="a"></asp:TextBox>
    <br />
                <asp:Label ID="Label5" runat="server" Width="100px"></asp:Label>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                    ControlToValidate="quanzinametextbox" Display="Dynamic" ErrorMessage="圈子名称不能为空" 
                    ForeColor="Red" ValidationGroup="a"></asp:RequiredFieldValidator>
                <br />
                <br />
    <asp:Label ID="Label2" runat="server" Text="您教授的课程：" Width="100px"></asp:Label>
    <asp:TextBox ID="coursetextbox" runat="server"></asp:TextBox>
                <br />
                <br />
    <asp:Label ID="Label3" runat="server" Text="您的电话：" Width="100px"></asp:Label>
    <asp:TextBox ID="teltextbox" runat="server"></asp:TextBox>
                <br />
                <br />
    <asp:Label ID="Label4" runat="server" Text="您的地址：" Width="100px"></asp:Label>
    <asp:TextBox ID="addresstextbox" runat="server"></asp:TextBox>

                <br />
                <br />
                <asp:Label ID="Label6" runat="server" Width="100px"></asp:Label>

    <asp:Button ID="Button1" runat="server" Text="保存" CssClass="btn btn-success" 
                    onclick="Button1_Click" ValidationGroup="a" />
                    </div>
</asp:Content>

