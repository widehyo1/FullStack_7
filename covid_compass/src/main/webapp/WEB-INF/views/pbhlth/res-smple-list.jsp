<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head></head>
<title></title>

<body>
<section class="content">
<div class="row" style="margin: 1px; margin-top: 17px;">
  <div class="col-md-12 pl-0 pr-0">
    <div class="card" style="margin-left: 2px; margin-right: 2px; margin-bottom: 18px;">
      <div class="card-header p-0 t-1">
        <ul class="nav nav-pills ml-auto p-2" role="tablist">
          <li class="nav-item">
            <a class="nav-link active" id="custom-res-smple-pstv-all-list-tab" data-toggle="pill" href="#custom-res-smple-pstv-all-list" role="tab" aria-controls="custom-tabs-three-all" aria-selected="true">검사 결과 목록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" id="custom-res-smple-pstv-y-list-tab" data-toggle="pill" href="#custom-res-smple-pstv-y-list" role="tab" aria-controls="custom-tabs-three-y" aria-selected="false">양성 판정 목록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" id="custom-res-smple-pstv-n-list-tab" data-toggle="pill" href="#custom-res-smple-pstv-n-list" role="tab" aria-controls="custom-tabs-three-n" aria-selected="false">음성 판정 목록</a>
          </li>
					<li style="margin-left: 626px;">
					<!-- search bar -->
					<div class="input-group float-right" style="max-width: 600px; width:300px;">
					<!-- search bar -->
					<select class="form-control " name="searchType" id="searchType">
						<option value="" ${pageMaker.cri.searchType eq '' ? 'selected':''}>검색구분</option>
						<option value="n"
							${pageMaker.cri.searchType eq 'n' ? 'selected':''}>성 명</option>
						<option value="p"
							${pageMaker.cri.searchType eq 'p' ? 'selected':''}>전화번호</option>
					</select>

					<!-- keyword -->
					<input class="form-control" type="text" name="keyword"
						value="${pageMaker.cri.keyword }"
						style="width: 18%; display: inline-block;" /> <span
						class="input-group-append">
						<button class="btn btn-primary" type="button" id="searchBtn"
							style="background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px; margin-left: -7px;"
							data-card-widget="search" onclick="">
							<i class="fa fa-fw fa-search"></i>
						</button>
					</span>
					<!-- end : search bar -->
				</div>
					</li>
					<!-- end : search bar -->
        </ul>
        
      </div>
	        <div class="tab-content" id="custom-tabs-three-tabContent">
	          <div class="tab-pane fade show active" id="custom-res-smple-pstv-all-list" role="tabpanel" aria-labelledby="custom-tabs-three-all-tab">
	          	<%@ include file="./res-smple-pstv-all-list.jsp" %>
	          </div>
	          
	          <div class="tab-pane fade" id="custom-res-smple-pstv-y-list" role="tabpanel" aria-labelledby="custom-tabs-three-y-tab">
	          	<%@ include file="./res-smple-pstv-y-list.jsp" %>
	          </div>
	          
	          <div class="tab-pane fade" id="custom-res-smple-pstv-n-list" role="tabpanel" aria-labelledby="custom-tabs-three-n-tab">
	            <%@ include file="./res-smple-pstv-n-list.jsp"%>
	          </div>
	        </div>
    </div>
      <!-- /.card -->
  </div>
</div>
</section>
</body>
