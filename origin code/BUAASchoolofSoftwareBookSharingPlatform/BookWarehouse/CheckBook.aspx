<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="CheckBook.aspx.cs" Inherits="书库_CheckBook" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
 <div class="content">
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-book"></span>
                    </div>
                    <h1>
                        图书信息
                    </h1>
                </div>
                <div class="row-fluid">
                    <div class="span12" align="left">
                    <asp:Label ID="titlelabel" runat="server" Font-Bold="True" 
                            Font-Underline="False" Font-Size=Large></asp:Label>
                        <asp:Label ID="scorelabel" runat="server" Font-Size=Large></asp:Label>
                    </div>
                    <div class="span12" align="left">
                        <asp:DropDownList ID="scoreselectlist" runat="server" 
                            CssClass="label-white" Width="80px">
                        </asp:DropDownList>
                        <asp:Button ID="scorebutton" runat="server" CssClass="btn btn-success" 
                            Text="评分" onclick="scorebutton_Click" />
                    </div>
                    <div class="span12" align="right">
                        <asp:Button ID="writebookreviewbutton" runat="server" CssClass="btn btn-warning" 
                            Text="撰写书评" onclick="writebookreviewbutton_Click" />
                        <asp:button id = "downloadbutton" runat = "server" class="btn btn-primary" 
                            Text="下载电子书" onclick="downloadbutton_Click"></asp:button>
                        <asp:Button ID="recommendbutton" runat="server" CssClass="btn" 
                            onclick="recommendbutton_Click" />
                        <asp:button id = "followbutton" runat = "server" class="btn btn-info" 
                            onclick="followbutton_Click"></asp:button>
                        <asp:button id = "editbutton" runat = "server" class="btn btn-info" 
                            Text="编辑" onclick="editbutton_Click"></asp:button>
                        <asp:button id = "deletebutton" runat = "server" class="btn btn-warning" 
                            Text="删除" onclick="deletebutton_Click"></asp:button>
                    </div> 
                </div>
                <div class="row-fluid">
                     <div class="span4">
                         <br \>
                        <div class="block">
                            <div class="head orange">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>封面图片</h2>
                            </div>
                            <div class="span4" align="center">
                                <br \>
                                <div><asp:image id="coverimg" runat = "server" class="img-polaroid" width="200px"/></div>
                                <br \>

                            </div>
                        </div>                          
                     </div>
                     <div class="span4">
                         <br \>
                        <div class="block">
                            <div class="head blue">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>基本信息</h2>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">作者</font></div>
                                    <div class="span9"><asp:TextBox runat = "server" ID = "authortextbox" 
                                            ReadOnly="True" Width="218px"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">出版社</font></div>
                                    <div class="span9"><asp:TextBox runat = "server" ID = "publishertextbox" 
                                            ReadOnly="True" Width="218px"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">分类</font></div>
                                    <div class="span9"><asp:TextBox runat = "server" ID = "categorytextbox" 
                                            ReadOnly="True" Width="218px"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">ISBN号</font></div>
                                    
                                    <div class="span9"><asp:TextBox runat = "server" ID = "isbntextbox" ReadOnly="True" 
                                            Width="218px"/></div>
                            </div>
                            <div class="row-form">
                                    <div class="span3"><font size="2px">豆瓣链接</font></div>
                                    <div class="span9">
                                        <asp:HyperLink ID="doubanlink" runat="server">HyperLink</asp:HyperLink>
                                    </div>
                            </div>
                        </div>                          
                     </div>
                     <div class="span4">
                         <br \>
                        <div class="block">
                            <div class="head green">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>图书简介</h2>
                            </div>
                            <div class="data" align="center">
                               <asp:TextBox ID = "introtextbox" runat = "server" ReadOnly="True" 
                                    TextMode="MultiLine" Height="300px" BorderStyle="None" BackColor="White"></asp:TextBox>
                            </div>
                        </div>                          
                     </div>                     
                </div>
                <div class="block">
                            <div class="head yellow">
                                <div class="icon"><span class="ico-pen-2"></span></div>
                                <h2>书评列表</h2>
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('table_default'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                              
                            </div>                
                            <div class="data-fluid">
                                <asp:Table ID = "bookreviewtable" runat = "server" cellpadding="0" 
                                    cellspacing="0" width="100%" class="table">
                                    
                                </asp:table>
                            </div>                
                        </div>
            </div>
       
    
</asp:Content>

