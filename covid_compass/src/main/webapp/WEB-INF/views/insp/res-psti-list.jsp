<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<style>
.badge{
	font-size: 12px; 
}
</style>
</head>
<title></title>

<body>
	<section class="content">
		<div class="row" style="margin: 1px;">
			<div class="col-lg-6">
			<section class="content">
			<div class="card"
						style="margin: 1px; height: 763px; margin-top: 13px;">
						<div class="card-header d-flex p-0">
							<ul class="nav nav-pills ml-auto p-2" role="tablist">
								<li class="nav-item"><div class="input-group float-right" style="max-width: 600px; width:300px;">
					<!-- search bar -->
					<select class="form-control " name="searchType" id="searchType">
						<option value="" ${pageMaker.cri.searchType eq '' ? 'selected':''}>검색구분</option>
						<option value="n"
							${pageMaker.cri.searchType eq 'n' ? 'selected':''}>성 명</option>
						<option value="p"
							${pageMaker.cri.searchType eq 'p' ? 'selected':''}>연락처</option>
					</select>

					<!-- keyword -->
					<input class="form-control" type="text" name="keyword"
						value="${pageMaker.cri.keyword }"
						style="width: 18%; display: inline-block;" /> <span
						class="input-group-append">
						<button class="btn btn-primary" type="button" id="searchBtn"
							style="background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px; margin-left: -7px;"
							data-card-widget="search" onclick="list_go(1, '<%=request.getContextPath()%>/rest-insp/insp-psti-result-list');">
							<i class="fa fa-fw fa-search"></i>
						</button>
					</span>
					<!-- end : search bar -->
				</div></li>
							</ul>
						</div>
						<div class="card-body">
							<div class="tab-content" id="custom-tabs-three-tabContent">
								<div class="tab-pane fade show active" id="custom-psti-detail"
									role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
									<%@ include file="./res-psti-list-module-work.jsp" %>
								</div>
							</div>
						</div>
						<!-- /.card -->
					</div>
			
			</section>
			
		</div>
		
		
		<div class="col-lg-6">
				<section class="content">
					<div class="card"
						style="margin: 1px; height: 763px; margin-top: 13px;">
						<div class="card-header d-flex p-0">
							<ul class="nav nav-pills ml-auto p-2" role="tablist">
								<li class="nav-item" ><a class="nav-link active"
									id="psti-detail-tab" data-toggle="pill"
									href="#custom-psti-detail" role="tab"
									aria-controls="custom-tabs-three-home" aria-selected="true" style="background: #1a4f72;cursor: default;">피검자
										상세</a></li>
							</ul>
						</div>
						<div class="card-body">
							<div class="tab-content" id="custom-tabs-three-tabContent">
								<div class="tab-pane fade show active" id="custom-psti-detail"
									role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
									<%@ include file="./res-psti-detail-module-work.jsp"%>
								</div>
							</div>
						</div>
						<!-- /.card -->
					</div>
					<!-- search bar -->
				</section>
			</div>


	</div>
	<!-- /.card-body -->

</section>


</body>

<tr data-psti-no="${pstiNo }">
	<td>${pstiReadyListVO.pstiNm }pstiNm</td>
	<td class="dtr-control sorting_1" tabindex="0"><fmt:formatDate
			value="${pstiReadyListVO.wrtYmd }" pattern="yyyy-MM-dd" />2022-01-01</td>
	<td>${pstiReadyListVO.age }age</td>
	<td><fmt:formatDate value="${pstiReadyListVO.birthDate }"
			pattern="yyyy-MM-dd" />1990-01-01</td>
	<td>${pstiReadyListVO.telNo }010-1234-4321</td>
</tr>