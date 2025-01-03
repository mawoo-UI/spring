<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
    <div class="wrap" >
        <jsp:include page="../common/header.jsp"/>
        </header>
        
        <main class="container mb-5">
            <h1 class="text-center mt-5">로그인</h1>
            <form name="frm" method="post"
             class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-2 mt-5">
                <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id" value="${cookie['remember-id'].value}">
                <input type="password" class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">

                <div class="form-check form-switch my-3">
                    <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="${'remember-id'}" ${empty cookie['remember-id'] ? '' : 'checked'}>
                    <label class="form-check-label" for="mySwitch">아이디 기억하기</label>
                </div>
                <button class="btn btn-primary">로그인</button>
            </form>
            <c:if test="${not empty msg}">
                <p class="my-2 text-danger text-center small">로그인 실패- 아이디와 비밀번호를 확인하세요</p>
            </c:if>
        </main>
       <jsp:include page="../common/footer.jsp"/>
    </div>

</body>
</html>