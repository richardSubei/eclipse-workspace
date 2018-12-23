<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base/base.jsp" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${ctx }/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${ctx }/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${ctx }/toProductAdd.action";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${ctx }/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="17%">
										商品图片
									</td>
									<td align="center" width="17%">
										商品编号
									</td>
									<td align="center" width="17%">
										商品名称
									</td>
									<td align="center" width="17%">
										商品价格
									</td>
									
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<c:forEach var="obj" items="${list }" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<c:out value="${status.count }"/>
											</td>
											<c:forEach var="pi" items="${obj.productImgs }">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="17%">
													<img width="40" height="45" src="${pi.productImg }">
												</td>
											
											</c:forEach>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${obj.productNo }"/>
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${obj.productName }"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${obj.productPrice }"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="">
													<img src="${ctx }/img/itcast/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="">
													<img src="${ctx }/img/itcast/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					
				</TBODY>
			</table>
		</form>
	</body>
</HTML>
