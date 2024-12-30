<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
    <div class="wrap" >
       <jsp:include page="../common/header.jsp"/>
        <main class="container">
        	<div class="container py-4">
        		<h2 class="float-start">Post List</h2>
        		<a href="write?${pageDto.cri.qs2}" class="btn btn-primary float-end">글쓰기</a>
        	</div>
			<form>
				<input type="hidden" name="page" value="${pageDto.cri.page}">
				<input type="hidden" name="category" value="${pageDto.cri.category}">
				<div class="row my-3">
	        		<div class="col-2">
			 	       	<select class="form-select"name="type">
						  <option value="T"${pageDto.cri.type == 'T'? 'selected' : ''}>title</option>
						  <option value="C"${pageDto.cri.type == 'C'? 'selected' : ''}>content</option>
						  <option value="W"${pageDto.cri.type == 'TW'? 'selected' : ''}>writer</option>
						  <option value="TC"${pageDto.cri.type == 'TC'? 'selected' : ''}>title+content</option>
						  <option value="TW"${pageDto.cri.type == 'TW'? 'selected' : ''}>title+writer</option>
						  <option value="CW"${pageDto.cri.type == 'CW'? 'selected' : ''}>content+writer</option>
						  <option value="TCW" ${pageDto.cri.type == 'TCW'? 'selected' : ''}>title+content+ writer</option>
						  <!-- selected 붙이면 고정값 -->
						</select>
	        		</div>
        		<div class="col-4">
					<div class="input-group mb-3">
						<input type="text" class ="form-control" placeholder="Search" name="keyword" value="${pageDto.cri.keyword}">
						<button class="btn btn-primary" type="submit">search</button>
					</div>
        		</div>
        		<div class="col-4"></div>
        		<div class="col-2 float-end">
        			<select class="form-select" name="amount">
					  <option value="10" ${pageDto.cri.amount == 10 ? 'selected' : ''}>10개씩 보기</option>
					  <option value="20" ${pageDto.cri.amount == 20 ? 'selected' : ''}>20개씩 보기</option>
					  <option value="30" ${pageDto.cri.amount == 30 ? 'selected' : ''}>30개씩 보기</option>
					  <option value="50" ${pageDto.cri.amount == 40 ? 'selected' : ''}>50개씩 보기</option>
					</select>
        		</div>
        	</div>
			</form>
                <table class="table table-hover text-center" style="table-layout: fixed;">
                  <thead>
	                    <tr>
	                      <th style="width: 6%;">글번호</th>
	                      <th>제목</th>
	                      <th style="width: 10%;">작성자</th>
	                      <th style="width: 20%;">작성일</th>
	                      <th style="width: 6%;">조회수</th>
	                    </tr>
                  	</thead>
                  <tbody>
                   <c:forEach items="${posts}" var="p">
                	<tr>
	                    <td>${p.pno}</td>
                    <td class="text-truncate text-start">
                    	<a href="view?pno=${p.pno}&${pageDto.cri.qs2}" class="text-decoration-none">${p.title}</a>
                    	<c:if test="${p.attachFlag}"><i class="fa-solid fa-paperclip text-primary"></i></c:if> 
	                    </td>
	                    <td>${p.writer}</td>
	                    <td>${p.regdate}</td>
	                    <td>${p.viewCount}</td>
                	</tr>
                	</c:forEach>
                	</tbody>
                </table>
                ${pageDto}
                  <ul class="pagination justify-content-center my-5">
                  		<c:if test="${pageDto.doublePrev}">
	                  	<li class="page-item"><a class="page-link" href="list?page=${pageDto.startPage- 1}&${pageDto.cri.qs}&"><i class="fa-solid fa-angles-left"></i></a></li>
                  		</c:if>
                  		<c:if test="${pageDto.prev}">
	                  	<li class="page-item"><a class="page-link" href="list?page=${pageDto.cri.page-1}&${pageDto.cri.qs}"><i class="fa-solid fa-angle-left"></i></a></li>
	                  	</c:if>
	                  	<c:forEach begin ="${pageDto.startPage}" end="${pageDto.endPage}" var ="page">
	                  	<li class="page-item ${page == pageDto.cri.page ? 'active' : ''}"><a class="page-link" href="list?page=${page}&${pageDto.cri.qs}">${page}</a></li>
	                  
	                  </c:forEach>

	                  <!-- <li class="page-item active"><a class="page-link" href="#">2</a></li> -->
	                  
	                  <c:if test="${pageDto.next}">
	                  <li class="page-item"><a class="page-link" href="list?page=${pageDto.cri.page+1}&${pageDto.cri.qs}"><i class="fa-solid fa-angle-right"></i></a></li>
	                  </c:if>
	                  <c:if test="${pageDto.doubleNext}">
	                  <li class="page-item"><a class="page-link" href="list?page=${pageDto.endPage+1}&${pageDto.cri.qs}"><i class="fa-solid fa-angles-right"></i></a></li>
	                  </c:if>
                  </ul>
	        </main>
     	  	<jsp:include page="../common/footer.jsp"/>
  	  </div>

</body>

</html>