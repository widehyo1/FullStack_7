<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<head></head>

<title></title>

<body>
<div class="card-primary">
  <div class="card-header" style="background-color: #5bbc71;">
    <h3 class="card-title">아이디 찾기</h3>
  </div>
  <!-- /.card-header -->
  <!-- form start -->
  <form method="post" action="<%=request.getContextPath()%>/common/findId">
    <div class="card-body">
      <div class="form-group">
        <label for="mberNm">이름</label>
        <input type="text" class="form-control" id="mberNm" name="mberNm" placeholder="Enter name">
      </div>
      <div class="form-group">
        <label for="mberTelno">연락처</label>
        <input type="text" class="form-control" id="mberTelno" name="mberTelno" maxlength="13" oninput="autoHyphen(this)" placeholder="010-0000-0000">
      </div>

    <div class="row">
     <div class="col-sm-1"></div>
      <button type="submit" class="btn btn-primary col-md-5" style="background-color: #5bbc71; border-color: #5bbc71; margin-right: 5px;">확인</button>
      <button type="button" id="close" class="btn btn-primary col-md-5" style="background-color: #5bbc71; border-color: #5bbc71; margin-left: 5px;">닫기</button>
      <div class="col-sm-1"></div>
    </div>
    </div>
    <!-- /.card-body -->
  </form>
</div>
<script>
window.onload = function(){	

	// 창 닫기
	$('#close').on('click', function(){
		window.close();
	})
} // window.onload 
// 연락처 하이픈
const autoHyphen = (target) => {
	target.value = target.value.replace(/[^0-9]/, '').replace(/^(\d{2,3})(\d{3,4})(\d{4})$/,`$1-$2-$3`);
}
</script>
</body>