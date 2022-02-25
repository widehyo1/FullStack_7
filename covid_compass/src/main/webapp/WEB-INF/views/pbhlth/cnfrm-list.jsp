<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<style>
th{
	background: #f5fafc;
}
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    color: #fff;
    background-color: #1a4f72;
}
.page-item.active .page-link, .page-item.active {
    z-index: 3;
    color: #fff;
    background-color: #1a4f72;
    border-color: #1a4f72;
}


</style>

</head>

<title></title>

<body>
<section class="content">
		<div class="row" style="margin: 1px;">
			<div class="col-12 pl-0 pr-0" style="margin-top: 17px;">
				<div class="card-header p-0 t-1">
					<div class="row">
						<div class="col-md-6">
							<ul class="nav nav-pills ml-auto pt-0 pl-2 pr-2 pb-2" id="custom-tabs-two-tab" role="tablist">
								<li class="nav-item">
									<a class="nav-link active" id="custom-cnfrm-dgnss-regist-tab" data-toggle="pill" href="#custom-cnfrm-dgnss-regist" role="tab" aria-controls="custom-tabs-three-home-tab" aria-selected="true">진료신청 대기환자 목록</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" id="custom-cnfrm-dgnss-regist-list-tab" data-toggle="pill" href="#custom-cnfrm-dgnss-regist-list-detail" role="tab" aria-controls="custom-tabs-three-profile-tab" aria-selected="false">진료신청 목록</a>
								</li>
							</ul>
						</div>
						<div class="col-md-6 float-right">
							<div class="input-group float-right" style="max-width: 600px; width: 300px;">
								<select class="form-control " name="searchType" id="searchType">
									<option value="" ${pageMaker.cri.searchType eq '' ? 'selected':''}>검색구분</option>
									<option value="name" ${pageMaker.cri.searchType eq 'name' ? 'selected':''}>성 명</option>
									<option value="tel" ${pageMaker.cri.searchType eq 'tel' ? 'selected':''}>연락처</option>
									<option value="cnfmCode" ${pageMaker.cri.searchType eq 'tel' ? 'selected':''}>확진자코드</option>
								</select>

								<!-- keyword -->
								<input class="form-control" type="text" name="keyword" id="keywordId" value="${pageMaker.cri.keyword }" style="width: 18%; display: inline-block;" /> <span class="input-group-append">
									<button class="btn btn-primary" type="button" id="searchBtn" style="background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px;" data-card-widget="search" onclick="list_go_check();">
										<i class="fa fa-fw fa-search"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="card-body pl-0 pr-0 pb-0">
					<div class="tab-content" id="custom-tabs-two-tabContent">
						<div class="tab-pane fade show active" id="custom-cnfrm-dgnss-regist" role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
							<%@ include file="./cnfrm-dgnss-regist.jsp"%>
						</div>
						<div class="tab-pane fade" id="custom-cnfrm-dgnss-regist-list-detail" role="tabpanel" aria-labelledby="custom-tabs-three-profile-tab">
							<%@ include file="./cnfrm-dgnss-regist-list.jsp"%>
						</div>
					</div>
				</div>
				<!-- /.card -->
			</div>
		</div>
	</section>
</body>