<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="WriteBookReview.aspx.cs" Inherits="书库_WriteBookReview" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
 <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>书评撰写</h1>
   
                </div>
                <div class="span12" align="center"><asp:Label ID="infolabel" runat="server" Font-Size=Large></asp:Label><br \><br \></div>
                <div class="row-fluid">
                    
                    <div class="span12">
                        <div class="block">
                            <div class="head orange">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>书评题目</h2>
                                
                            </div>
                            
                            <div class="row-form">
                                     <div class="data-fluid editor">

                                <asp:TextBox ID="titletextbox" runat="server" Width="100%" Height="30px" 
                                 BackColor="White" BorderStyle="NotSet" ForeColor="Black"></asp:TextBox>
                                
                            </div>
                                    
                            
                        </div>
                        <div><br \></div>
                        <div class="block">
                            <div class="head blue">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>书评内容</h2>
                                
                            </div>
                            
                                    <div class="data-fluid editor">

                                <asp:TextBox ID="contenttextbox" runat="server" Width="100%" Height="80px" 
                                TextMode="MultiLine" BackColor="White" BorderStyle="NotSet" ForeColor="Black"></asp:TextBox>
                                
                            </div>
                             </div>              

                    </div>
                   


                </div> 

                <div class="row-form">
                    <div class="span12">
                        <div><br \></div>
                            <div class="span9" align="center"><button id="finish" runat="server" class="btn btn-success" onserverclick="publishbutton_Click"><font size="2">发表</font> <span class="ico-ok"></span></button></div>
                        
                    </div>                
                </div>                  
                
            </div>
        </div>
        
    </div>
</asp:Content>

