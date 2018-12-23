<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base/base.jsp"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${ctx }/css/Style1.css" type="text/css" rel="stylesheet">
</HEAD>

<body>
	
	<form id="userAction_save_do" name="Form1"
		action="${ctx }/productSave.action" method="post"
		enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加商品</STRONG> </strong></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品编号：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="productNo" value="" id="userAction_save_do_logonName" class="bg" />
				</td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="productName" value="" id="userAction_save_do_logonName" class="bg" />
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商城价格：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="productPrice" value="" id="userAction_save_do_logonName" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品库存：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="inventory" value="" id="userAction_save_do_logonName" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品主图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<input type="file" name="productImgs"/>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgCol or="#f5fafe" class="ta_01">
					所属的二级分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<select name="categorySId">
						<c:forEach var="obj" items="${list }" varStatus="status">
							<option value="${obj.categorySId }">${obj.categorySName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>