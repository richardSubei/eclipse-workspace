<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base/base.jsp" %>
<div class="span10 last">
	<div class="topNav clearfix">
				<ul>
					<c:if test="${sessionScope.user == null }">
						<li id="headerLogin" class="headerLogin" style="display: list-item;">
							<a href="${ctx }/toLogin.action">登录</a>|
						</li>
						<li id="headerRegister" class="headerRegister" style="display: list-item;">
							<a href="${ctx }/toRegister.action">注册</a>|
						</li>
					</c:if>
					<c:if test="${sessionScope.user != null }">
						<li>
							<a href="">${sessionScope.user.userName }</a>
						</li>
					
						<li id= class="headerRegister" style="display: list-item;">
							<a href= "">我的订单</a>|
						</li>
					
						<li>
							<a href="${ctx }/logout.action">[退出]</a>|
						</li>
					</c:if>
					
					<li>
						<a>会员中心</a>
							|
					</li>
					<li>
						<a>购物指南</a>
							|
					</li>

				</ul>
			</div>
		<div class="cart">
			<a  href="">购物车</a>
		</div>
		<div class="phone">
			客服热线:
			<strong>96008/53277764</strong>
		</div>
</div>
		
<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="">首页</a>
						|
					</li>
					<c:forEach var="obj" items="${sessionScope.list }">
						<li>
							<a href=""/>
								${obj.categoryFName }
							</a> |
						</li>
					</c:forEach>

					
					
					
		</ul>
	</div>