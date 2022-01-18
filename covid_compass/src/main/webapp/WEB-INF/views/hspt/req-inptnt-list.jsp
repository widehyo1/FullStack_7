<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
</head>
<title></title>
<body>
  <section class="content">
    <div class="row" style="margin: 1px; margin-top: 7px;">
      <div class="col-lg-6 pl-0">
        <section class="content">
          <div class="card" style="margin: 1px; height: 763px; margin-top: 13px;">
            <div class="card-header d-flex p-0">
              <ul class="nav nav-pills ml-auto p-2" role="tablist">
                <li class="nav-item"><div class="input-group float-right" style="max-width: 600px; width: 300px;">
                    <!-- search bar -->
                    <select class="form-control " name="searchType" id="searchType">
                      <option value="" ${pageMaker.cri.searchType eq '' ? 'selected':''}>검색구분</option>
                      <option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected':''}>성 명</option>
                      <option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':''}>전화번호</option>
                      <option value="h" ${pageMaker.cri.searchType eq 'h' ? 'selected':''}>신청기관명</option>
                    </select>

                    <!-- keyword -->
                    <input class="form-control" type="text" name="keyword" value="${pageMaker.cri.keyword }" style="width: 18%; display: inline-block;" /> <span class="input-group-append">
                      <button class="btn btn-primary" type="button" id="searchBtn" style="background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px; margin-left: -7px;" data-card-widget="search" onclick="">
                        <i class="fa fa-fw fa-search"></i>
                      </button>
                    </span>
                    <!-- end : search bar -->
                  </div></li>
              </ul>
            </div>
            <div class="card-body">
              <div class="tab-content" id="custom-tabs-three-tabContent">
                <div class="tab-pane fade show active" id="custom-psti-detail" role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
                  <%@ include file="./req-inptnt-list-module-work.jsp"%>
                </div>
              </div>
            </div>
            <!-- /.card -->
          </div>

        </section>

      </div>
      <div class="col-lg-6 pr-0">
        <section class="content">
          <div class="card" style="margin: 1px; height: 763px; margin-top: 13px;">
            <div class="card-header d-flex p-0">
              <ul  class="nav nav-pills ml-auto p-2" role="tablist">
                <li class="nav-item"><a class="nav-link active" id="psti-detail-tab" data-toggle="pill" href="#custom-dgnss-detail" role="tab" aria-controls="custom-tabs-three-home" aria-selected="true" style="cursor: default; background-color: #1a4f72;">환자 상세</a></li>
              </ul>
            </div>
            <div class="card-body">
              <div class="tab-content" id="custom-tabs-three-tabContent">
                <div class="tab-pane fade show active" id="custom-dgnss-detail" role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
                  <%@ include file="./req-inptnt-detail-module.jsp"%>
                </div>
              </div>
            </div>
            <!-- /.card -->
          </div>
          <!-- search bar -->
        </section>
      </div>
      <!-- /.card-body -->
    </div>
  </section>

</body>
