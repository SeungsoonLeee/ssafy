<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>로그인</TITLE>
<META http-equiv="Content-Type" content="text/html;charset=utf-8">
<Script Language ="JavaScript">
			function Login(){
				if(document.FrmLogin.id.value == "") {
					alert("ID를 입력하세요")
					document.FrmLogin.id.focus();
				}
				else if (document.FrmLogin.pw.value == "" ) {
					alert("비밀번호를 입력하세요")
					document.FrmLogin.pw.focus();
				}
				else {
					document.FrmLogin.submit() ;
				}
			}

</Script>
</HEAD>
<BODY BGCOLOR="#FFFFFF" leftmargin="0" topmargin="0" marginwidth=0 marginheight=80>
	<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH=100% HEIGHT=100%>
		<TR>
		<TD align=center>
		<TABLE BORDER=4 CELLPADDING=0 CELLSPACING=0 WIDTH=434 HEIGHT=180>
			<TR><TD align=center>
			<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH=400 HEIGHT=180>
				<TR>
				<TD WIDTH=107><IMG SRC="images/book.bmp"  BORDER=0></TD>
				<TD WIDTH=281 HEIGHT=150>
							<!-- 로그인 입력창 시작 -->

				<form method = "post" name = "FrmLogin" action="login.do">
				<center><FONT face="굴림" size=3> 로그인하여 주세요</FONT></center>
				<p><p><p>
				<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=2 align=center>
					<TR>
					<TD><IMG SRC="images/id_id.gif" BORDER=0 ALT=""></TD>
					<TD><input TYPE= "text" name="id"  class="input"  tabindex=1 onKeyPress="if (event.keyCode == 13) Login();" style='width:120;height:20;' ></TD>	</TR>
					<TR>
					<TD><IMG SRC="images/id_pass.gif" BORDER=0 ALT=""></TD>
					<TD><input TYPE="password" name="pw"  class="input"  tabindex=2 onKeyPress="if (event.keyCode == 13) Login();" style='width:120;height:20;'></TD></TR>
					<TR/><TR>
					<TD></TD>
					<TD HEIGHT="5" background="images/line.gif"></TD>
					</TR><TR/>
					<TR><TD></TD>
					<TD><A HREF="JavaScript:Login();"><IMG  SRC="images/butt_login.gif" BORDER = "0" WIDTH=80 HEIGHT=25></A>
					</TD>
					</TR>
				</TABLE>
				</form>
							<!-- 로그인 입력창 끝 -->
				</TD></TR></TABLE>
			</TD></TR></TABLE>				
		</TD></TR></TABLE>
	</BODY>
</HTML>
