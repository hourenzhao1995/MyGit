<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		
		<c:forEach items="${recommends }" var="book">
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='${pageContext.request.contextPath }/book/selectOne?id=${book.id}' target='_blank'>
						<img class="book-cover" style="width:70px;height: 103px;" src="${pageContext.request.contextPath }/back/img/${book.cover}" width=70 /> 
					</a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='${pageContext.request.contextPath }/book/selectOne?id=${book.id}' target='_blank' title='输赢'>${book.name }</a>
					</h3>
					<h4>
						作者：${book.author } 著
						<br />
						出版社：${book.press }&nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：<fmt:formatDate value="${book.pressDate}" pattern="yyyy-MM-dd"/>
					</h4>
					<h5>
						${book.contentAbstract }
					</h5>
					<h6>
						定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
						当当价：￥${book.dprice }&nbsp;&nbsp;&nbsp;&nbsp;
						销量：${book.sale }
					</h6>
					<div class=line_xx></div>
				</div>
			</div>			
		</c:forEach>
		
	</div>
</div>
