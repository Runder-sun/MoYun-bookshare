<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="CheckBookReview.aspx.cs" Inherits="书库_CheckBookReview" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>书评查看</h1>
                    
                    
                </div>
                <div class="span12">

                        <asp:Label ID="infolabel" runat="server" Font-Size="15pt"></asp:Label>
                    <asp:Label ID="scorelabel" runat="server" Font-Size="19pt"></asp:Label>
               
                <asp:Button ID="scorebutton" runat="server" Text="评分" CssClass="btn-primary" 
                    onclick="scorebutton_Click" />
                                        &nbsp;<asp:DropDownList ID="scoreselectlist" 
                    runat="server" CssClass="btn-success">
                                        </asp:DropDownList>
                </div>
                <div class="span12" align="center">
                <asp:Button class="btn btn-success" ID = "editbutton" runat = "server" 
                            Text="修改" CssClass="btn btn-info" onclick="editbutton_Click" ></asp:button>
                        
                                        &nbsp;<asp:Button ID="deletebutton" runat="server" 
                    CssClass="btn btn-warning" Text="删除" onclick="deletebutton_Click" />
                </div>
                <div class="span12"><br \></div>
                <div class="row-fluid">

                    <div class="span12">
                        <div class="block">
                            <div class="head orange">                        
                                <h2>书评题目</h2>
                                
                            </div>
                            
                            <div class="row-form">
                                    <div class="span9">
                                        <asp:TextBox ID = "titletextbox" runat = "server" type="text" 
                                            ValidationGroup="aaa" Width="339px" ReadOnly="True" BackColor="White" />
                        
                        
                                    </div>
                            </div>
                        </div>
                        <div class="block">
                            <div class="head blue">                        
                                <h2>书评内容</h2>
                                
                            </div>
                            
                            <div class="row-form">
                                    <div class="span12"><asp:TextBox ID = "contenttextbox" runat = "server" 
                                            ValidationGroup="aaa"  TextMode="MultiLine" Height="25px" Width="100%" 
                                            ReadOnly="True" BackColor="White"></asp:textbox>
                                    </div>
                            </div>
                        </div>   
                                 
                        <div class="block">
                            <div class="head green">
                               
                                <h2>评论列表</h2>    
                                                                                      
                            </div>       
<div class="data-fluid">
<asp:Table ID = "commenttable" runat = "server" class="table table-hover" >
    
</asp:Table>
   </div></div>
                    <div class="block">
                    <div class="head purple">
                                <h2>我要评论</h2>                                     
                            </div>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                            ControlToValidate="commenttextbox" Display="Dynamic" ErrorMessage="不能发表空评论" 
                            ForeColor="Red" ValidationGroup="a"></asp:RequiredFieldValidator>
                        <br />
                        <asp:TextBox ID="commenttextbox" runat="server" ValidationGroup="a" Width="80%"></asp:TextBox>
                        <asp:Button ID="Button1" runat="server" CssClass="btn btn-info" Text="发表评论" 
                            ValidationGroup="a" onclick="Button1_Click" />
                        <br />
                        </div>
                    </div>



                </div> 
                
</asp:Content>

