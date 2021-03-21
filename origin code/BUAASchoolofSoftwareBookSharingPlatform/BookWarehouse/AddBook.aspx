<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="AddBook.aspx.cs" Inherits="书库_AddBook" %>

<%@ Register src="followbooktable.ascx" tagname="followbooktable" tagprefix="uc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-address-book-2"></span>
                    </div>
                    <h1>添加图书</h1>
                </div>
                    <table class="table_style">
                    	<tbody>
                        	<tr>
                            	<td class="td_style"><font size="2">图书名称：</font></td>
                                <td class="td_style2" style="width: 357px">
                                   <asp:TextBox class="input-huge" type="text" placeholder="输入图书名称" 
                                        runat = "server" ID = "titletextbox" Width="271px"></asp:TextBox>
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                                        ControlToValidate="titletextbox" Display="Dynamic" ErrorMessage="不能为空" 
                                        ForeColor="Red" ValidationGroup="book"></asp:RequiredFieldValidator>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"><font size="2"> 作  者：</font></td>
                                <td class="td_style2" style="width: 357px">
                                   <asp:TextBox class="input-huge" type="text" placeholder="输入作者信息" 
                                        runat = "server" ID = "authortextbox" Width="269px"></asp:TextBox>
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                                        ControlToValidate="authortextbox" Display="Dynamic" ErrorMessage="不能为空" 
                                        ForeColor="Red" ValidationGroup="book"></asp:RequiredFieldValidator>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"><font size="2"> ISBN号：</font></td>
                                <td class="td_style2" style="width: 357px">
                                   <asp:TextBox class="input-huge" type="text" placeholder="输入ISBN号" 
                                        runat = "server" ID = "isbntextbox" Width="269px"></asp:TextBox>
                                    <asp:CustomValidator ID="CustomValidator1" runat="server" Display="Dynamic" 
                                        ErrorMessage="该书已存在" ForeColor="Red" 
                                        onservervalidate="CustomValidator1_ServerValidate" ValidationGroup="book"></asp:CustomValidator>
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                                        ControlToValidate="isbntextbox" Display="Dynamic" ErrorMessage="不能为空" 
                                        ForeColor="Red" ValidationGroup="book"></asp:RequiredFieldValidator>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"><font size="2">出版社：</font></td>
                                <td class="td_style2" style="width: 357px">
                                   <input class="input-huge" type="text" placeholder="输入出版社信息" runat = "server" ID = "publishertextbox"></input>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"> <font size="2">分  类：</font></td>
                                <td class="td_style2" style="width: 357px">
                                	<asp:DropDownList name="s_example" runat = "server" ID = "categoryselect" 
                                        Width="270px">
                                    <asp:ListItem>文学</asp:ListItem>
                                    <asp:ListItem>流行</asp:ListItem>
                                    <asp:ListItem>文化</asp:ListItem>
                                    <asp:ListItem>生活</asp:ListItem>
                                    <asp:ListItem>经管</asp:ListItem>
                                    <asp:ListItem>科技</asp:ListItem>
                                        
                                    </asp:DropDownList>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"><font size="2">豆瓣链接：</font></td>
                                <td class="td_style2" style="width: 357px">
                                	<input class="input-huge" type="text" placeholder="请输入豆瓣链接地址" runat = "server" ID = "doubanlinktextbox"></input>
                                </td>
                            </tr>
                            <tr>
                            	<td class="td_style"><font size="2">简介：</font></td>
                                 <td class="td_style2" style="width: 357px">
                                	<textarea placeholder="给书籍来点描述吧~" runat = "server" id = "introtextbox" ></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                </td>
                            	<td style="width: 357px" >
                        			<center style="width: 316px">
                                        <br />
                                        <asp:Button class="btn" type="submit" value="保存" runat = "server" 
                                            ID = "confirmbutton" onclick="confirmbutton_Click" Text="保存" 
                                            ValidationGroup="book"/></center>
                                </td>
                            </tr>
                        </tbody>
                    </table>
            </div>
            <div class="content_recommend">
                
            </div>
        </div>
        
    </div>
    
    <div class="dialog" id="source" style="display: none;" title="Source"></div>
    
</asp:Content>

