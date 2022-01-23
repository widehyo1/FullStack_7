<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageMaker" value="${dataMap.pageMaker }"/>
<c:set var="cri" value="${datMap.pageMaker.cri }"/>
<c:set var="noticeList" value="${dataMap.noticeList }"/>

<head></head>

<title></title>

<body>

	<section class="content">
	<div class="card" style="margin:1px; margin-top:13px;">
				<!-- /.row -->
			<div class="card-body" style="height: 70px;">
				<!-- search bar -->
			<button type="button" class="btn btn-primary" style="background:#1a4f72;border:0px;width: 90px;"
				onclick="OpenWindow('notice-registForm', '공지사항 등록', 800,628)">등록</button>
				<!-- search bar -->
					<div class="input-group  float-right" style="max-width:600px;">
						<!-- sort num -->
						
						<!-- search bar -->
						<select class="form-control " name="searchType" id="searchType" >
								<option value="" ${cri.searchType eq '' ? 'selected':''}>검색구분</option>
								<option value="whole"
									${cri.searchType eq 'whole' ? 'selected':''}>전체</option>
								<option value="title"
									${cri.searchType eq 'title' ? 'selected':''}>제목</option>
								<option value="content"
									${cri.searchType eq 'content' ? 'selected':''}>내용</option>
						</select>
						
						<!-- keyword -->
						<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${pageMaker.cri.keyword }" style="width: 18%;display: inline-block;"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn"
								    style="background: #1a4f72; color: #ffffff; border-color: #1a4f72;
								    	   display: inline-block;margin-bottom: 4px;margin-left: -7px;"
								data-card-widget="search" onclick="list_go(1)">
								<i class="fa fa-fw fa-search" ></i>
							</button>
						</span>
						<!-- end : search bar -->
				    </div>

		 	 </div>


				<!-- /.card-header -->
				<div class="card-body table-responsive p-0">
					<table class="table table-hover text-nowrap" style="text-align: center;">
						<thead>
							<tr>
								<th>게시판 번호</th>
								<th style="width: 45%;">제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>팝업설정</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${empty noticeList }">
							<td colspan="5"><strong>해당 내용이 없습니다.</strong></td>
						</c:if>
						<c:forEach items="${noticeList}" var="notice">
							<tr style="cursor: pointer;" onclick="location.href='notice-detail?noticeNo=${notice.noticeNo}'">
								<td>${notice.noticeNo }</td>
								<td>${notice.title}</td>
								<td>${notice.writer }</td>
								<td>
									<fmt:formatDate value="${notice.wrtYmd}" pattern="yyyy-MM-dd"/>
								</td>
								<c:if test="${notice.popUp eq 'N'}">
									<td><span class="badge badge-danger">${notice.popUp}</span></td>
								</c:if>
								<c:if test="${notice.popUp eq 'Y'}">
									<td><span class="badge badge-primary">${notice.popUp}</span></td>
								</c:if>
							</tr>							
						</c:forEach>
							

						</tbody>
					</table>
				</div>
				<div class="card-footer clearfix" style="background-color: white;">
					<%@ include file="/resources/js/pagination.jsp" %>
				</div>

		</div>
		</section>

<script>
	window.onload = function() {
		// Summernote
		$('#summernote').summernote({
			height : 120
		})
		$('#summernote').summernote('disable');
	}

	function go_detail(){

		location.href = "<%=request.getContextPath()%>/ltct/notice-detail";
	}
	function noneHover(){
		document.getElementById('hover').style.background="white";
	}

</script>





</body>