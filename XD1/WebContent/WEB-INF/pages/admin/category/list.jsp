<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base/base.jsp"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx }/css/Style1.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="${ctx }/dtree/dtree.css" type="text/css" />
<script language="javascript" src="${ctx }/js/public.js"></script>
 
<script type="text/javascript">
	function addCategory() {
		window.location.href = "${ctx }/toCategoryFAdd.action";
	}
	
</script>
</HEAD>
<body>
	<br>
	<div class="dtree">

		<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
		
		<script type="text/javascript" src="${ctx }/dtree/dtree.js"></script>
		<script type="text/javascript">
		
			d = new dTree('d');
		
			d.add('0',-1,'系统菜单树');
			<c:forEach var="obj" items="${list }" varStatus="status">
			d.add('${status.count}','0','${obj.categoryFName}');
				<c:forEach var="sObj" items="${obj.categorySeconds }" varStatus="status_1">
					 d.add('${status.count}*10+ ${status_1.count}','${status.count}', '${sObj.categorySName}') 
					
				</c:forEach>
			
			</c:forEach>
			
			
			document.write(d);
		
		</script>
	</div>
	
	
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>一级分类列表</strong>
				</TD>
			</tr>
			<tr>
				<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="添加"
						class="button_add" onclick="addCategory()">
						&#28155;&#21152;</button>

				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="18%">序号</td>
							<td align="center" width="17%">一级分类名称</td>
							<td width="7%" align="center">编辑</td>
							<td width="7%" align="center">删除</td>
						</tr>
						<c:forEach var="obj" items="${list }" varStatus="status">
						
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
								<c:out value="${status.count }"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
								<c:out value="${obj.categoryFName }"></c:out>
							</td>
							<td align="center" style="HEIGHT: 22px">
								<a href="${ctx }/toCategoryFEdit.action?categoryFId=<c:out value="${obj.categoryFId }"/>">
									<img src="${ctx }/img/itcast/i_edit.gif" border="0"
									style="CURSOR: hand">
								</a>
							</td>
								
							<td align="center" style="HEIGHT: 22px">
								<a href="${ctx }/categoryFDel.action?categoryFId=<c:out value="${obj.categoryFId }"/>">
									<img src="${ctx }/img/itcast/i_del.gif" width="16" height="16"
									border="0" style="CURSOR: hand">
								</a>
							</td>
						</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

