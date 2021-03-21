<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="AddForum.aspx.cs" Inherits="QuanZi_AddForum" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-chat-3"></span>
                    </div>
                    <h1>发起讨论</h1>
                </div>
                <div class="row-form">
                    <div class="span3">讨论主题</div>
                    <div class="span5">
                        <input id="theme" runat="Server" type="text"/>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                            ControlToValidate="theme" ErrorMessage="主题不能为空" ForeColor="Red" 
                            ValidationGroup="1"></asp:RequiredFieldValidator>
                    </div>
                    <div class="span3">发起者</div>
                    <div class="span5">
                        <input id="creator" runat="Server" type="text"/>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                            ControlToValidate="creator" ErrorMessage="创建者姓名不能为空" ForeColor="Red" 
                            ValidationGroup="1"></asp:RequiredFieldValidator>
                    </div>
                 </div>
                <div class="row-form">
                     <div class="span10" align="center">
                     <br \>
                          <asp:Button ID="create" runat="Server" OnClick="Create_onclick" CssClass="btn btn-primary" Text="发起讨论">
                          </asp:Button>
                          <button id="cancel" runat="Server" onserverclick="Cancel_onclick" class="btn btn-info">
                              <font size="2">取消</font> <span class="ico-reply"></span></button>
                     </div>                
                 </div>
            </div>    
                
            </div>
            
        </div>
        
    </div>
</asp:Content>

