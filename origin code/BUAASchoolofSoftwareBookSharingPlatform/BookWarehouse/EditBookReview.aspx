<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="EditBookReview.aspx.cs" Inherits="书库_EditBook" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
 <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>书评修改</h1>
                    <h1>&nbsp;</h1>
                    <h1>&nbsp;</h1>
                    <h1>&nbsp;</h1>
                    <h1>&nbsp;</h1>
                    <h1>
                        
                    </h1>
                </div>

                <div class="row-fluid">
                    <div class="span12" align="center"><asp:Label ID="infolabel" runat="server" Font-Size=Large></asp:Label></div>
                    <div class="span12">

                        <div class="block">
                            <div class="head orange">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>书评题目</h2>
                                
                            </div>
                            
                            <div class="row-form">
                                    <div class="span9"><asp:TextBox ID = "titletextbox" runat = "server" type="text" 
                                            ValidationGroup="aaa"/>
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                                            ControlToValidate="titletextbox" Display="Dynamic" ErrorMessage="不能为空" 
                                            ForeColor="Red" ValidationGroup="aaa"></asp:RequiredFieldValidator>
                        
                        
                                    </div>
                            </div>
                        </div>
                        <div class="block">
                            <div class="head blue">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>书评内容</h2>
                                
                            </div>
                            
                            <div class="row-form">
                                    <div class="span10"><asp:TextBox ID = "contenttextbox" runat = "server" ValidationGroup="aaa"  TextMode="MultiLine" Width="100%"></asp:textbox>
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                                            ControlToValidate="contenttextbox" Display="Dynamic" ErrorMessage="不能为空" 
                                            ForeColor="Red" ValidationGroup="aaa" Width="100%"></asp:RequiredFieldValidator>
                                    </div>
                            </div>
                        </div>              
                        <div class="block" align="center">
                        <asp:Button class="btn btn-success" ID = "publishbutton" runat = "server" 
                            Text="保存修改" ValidationGroup="aaa" onclick="publishbutton_Click"></asp:button>
                                        &nbsp;<asp:Button ID="deletebutton" ValidationGroup="aaa" 
                                            class="btn btn-info" runat="server" Text="删除" onclick="deletebutton_Click" />
                    </div> 
                    </div>


                                   
                </div>                  
                
            </div>
        </div>
        
    </div>
</asp:Content>

