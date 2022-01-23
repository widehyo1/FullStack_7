<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
        <div class="card" style="position: relative; left: 15px; top: 0px; width: 850px;">
          <div class="card-header ui-sortable-handle">
            <h3 class="card-title">
              <i class="ion ion-clipboard mr-1"></i>병상요청
            </h3>

            <div class="card-tools">
              <ul class="pagination pagination-sm">
                <li class="page-item"><a href="#" class="page-link">«</a></li>
                <li class="page-item"><a href="#" class="page-link">1</a></li>
                <li class="page-item"><a href="#" class="page-link">2</a></li>
                <li class="page-item"><a href="#" class="page-link">3</a></li>
                <li class="page-item"><a href="#" class="page-link">»</a></li>
              </ul>
            </div>
          </div>
          <div class="card-body" style="padding: 0px;">
            <div class="table-responsive">
              <table class="table m-0" style="text-align: center;">
                <thead>
                  <tr>
                    <th style="width: 10%; text-align: center;">신청결과</th>
                    <th style="width: 10%; text-align: center;">환자이름</th>
                    <th style="text-align: center;">연락처</th>
                    <th style="text-align: center;">병원이름</th>
                    <th style="text-align: center;">신청시각</th>
                    <th style="width: 10%; text-align: center;">취소</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><span class="badge badge-success">승인</span></td>
                    <td><a href="pages/examples/invoice.html">하기재</a></td>
                    <td>010-7777-7777</td>
                    <td>기재병원</td>
                    <td>01/12 00:11</td>
                    <td><button style="width: 70px; margin-left: 18px;" type="button" class="btn btn-block btn-success btn-xs">취소</button></td>
                  </tr>
                  <tr>
                    <td><span class="badge badge-success">승인대기</span></td>
                    <td><a href="pages/examples/invoice.html">하기재</a></td>
                    <td>010-7777-7777</td>
                    <td>기재병원</td>
                    <td>01/11 15:21</td>
                    <td><button style="width: 70px; margin-left: 18px;" type="button" class="btn btn-block btn-success btn-xs" disabled>취소</button></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>