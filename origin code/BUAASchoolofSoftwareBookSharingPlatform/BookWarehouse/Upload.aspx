<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="Upload.aspx.cs" Inherits="书库_UploadCoverImage" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content" align="center">
              <div class="content_book" align="left" 
                  style="font-family: 微软雅黑; font-size: 17px;">
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-address-book-2"></span>
                    </div>
                    <h1>上传封面和电子书</h1>
                </div>
                
                  <br />
                  <asp:Label ID="Label5" runat="server" Text="上传封面："></asp:Label>

                  &nbsp;&nbsp;

                  <asp:FileUpload ID="coverimageupload" runat="server" Width="261px" 
                      CssClass="btn-success" />


                  <asp:Button ID="coverimageuploadbutton" runat="server" 
                      onclick="coverimageuploadbutton_Click" Text="上传" CssClass="btn-warning" />
                  <asp:Label ID="coverimageuploadinfolabel" runat="server" ForeColor="Red"></asp:Label>
                  <br />
                  <br />
                  <asp:Label ID="Label7" runat="server" Text="上传电子书："></asp:Label>

                  <asp:FileUpload ID="bookupload" runat="server" Width="258px" 
                      CssClass="btn-info" />

                  <asp:Button ID="bookuploadbutton" runat="server" 
                      onclick="bookuploadbutton_Click" Text="上传" CssClass="btn-primary" />
                  <asp:Label ID="bookuploadinfolabel" runat="server" ForeColor="Red"></asp:Label>
                  <br />
                  <br />
                  <br />
                  <br />
                  <div align="center" style="width: 581px">
                  <asp:Button ID="checkbookbutton" class="btn btn-success" runat="server" onclick="checkbookbutton_Click" 
                      Text="查看新书" CssClass="btn btn-large" />
                      </div>
                </div>
                </div>
                </asp:Content>

