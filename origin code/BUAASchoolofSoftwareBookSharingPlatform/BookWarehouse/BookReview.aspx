<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="BookReview.aspx.cs" Inherits="书库_BookReview" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-layout-7"></span>
                    </div>
                    <h1>我的书评</h1>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                      
                        <div align="right"><asp:button id = "writebutton" runat = "server" class="btn" 
                                type="button" onclick="writebutton_Click" Text="撰写书评"></asp:button>
                        
                        </div>
                        <div><br \></div>
                        <div class="block">
                            <div class="head green">
                                <div class="icon"><span class="ico-brush"></span></div>
                                <h2>书评列表</h2>    
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('table_hover_check'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                                          
                            </div>       
<div class="data-fluid">
<asp:Table ID = "brt" runat = "server" class="table table-hover" >
    
</asp:Table>
   </div></div></div>
   
</asp:Content>

