<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- 진료 요청 대기환자 목록 -->
<div class="row" style="margin: 1px;">
<div class="col-md-6 pl-0">
  <div class="card">
			<!-- search bar -->
			<div class="card-body">
		<div class="table-responsive">
			<table class="table table-hover text-nowrap"
				style="text-align: center;">
				<thead>
					<tr role="row">
						<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
							aria-label="Browser: activate to sort column ascending">확진자코드</th>
						<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
							aria-label="Browser: activate to sort column ascending">성명</th>
						<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
							aria-sort="ascending"
							aria-label="Rendering engine: activate to sort column descending">연락처</th>
						<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
							aria-label="Platform(s): activate to sort column ascending">확정일자</th>
					</tr>
				</thead>
				<tbody>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
					<tr onclick="OpenWindow('cnfrm-detail-dgnss-regist','확진자 진료 신청', 1260, 715)">
						<td>CNFM202201061000005</td>
						<td>강건</td>
						<td>010-5678-1234</td>
						<td>2022-01-01</td>
					</tr>
				</tbody>
			</table>

		</div>
		<!-- /.table-responsive -->
		<div>
		<%@ include file="../template/list-footer.jsp"%>
		</div>
	 </div>	
  </div>
</div>
<div class="col-md-6 pr-0">
	<!-- /.card-body -->
	<div class="card">
	 <div class="card-body">
				<table class="table table-bordered">
                  <thead>
                  	<tr>
                  		<th colspan="4">확진자 상세 정보</th>
                  	</tr>
                  </thead>
                  <tbody>
                    <tr style="text-align: center;">
                      <th>성명</th>
                      <td>홍길동</td>
                      <th>국적</th>
                      <td>KOREA</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>검사경위</th>
                      <td>본인판단</td>
                      <th>백신접종</th>
                      <td>3차 이상</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>성별</th>
                      <td>남</td>
                      <th>나이</th>
                      <td>27</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>발열여부</th>
                      <td>Y</td>
                      <th>임신여부</th>
                      <td>N</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>확정일자</th>
                      <td>2022-01-01</td>
                      <th>결과</th>
                      <td>양성</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>확진자 코드</th>
                      <td colspan="3">CNFM202201061000005</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>주민/외국인등록번호</th>
                      <td colspan="3">960101-1111111</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>주소</th>
                      <td colspan="3">대전광역시 서구 둔산동 1032 708호</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>연락처</th>
                      <td colspan="3">010-5678-1234</td>
                    </tr>
                    <tr class="shittr"  style="text-align: center;">
                      <th>증상</th>
                      <td colspan="3">기침, 두통, 복통, 어지러움</td>
                    </tr>
                  </tbody>
                </table>
                		<div style="text-align: center; margin-bottom: 20px; margin-top: 10px;">
	                      <button onclick="OpenWindow('cnfrm-detail-dgnss-regist', '진료 신청 정보', 1260, 715)" class="btn btn-success btn-sm" style="width: 50%; height: 35px; background: #1a4f72; border: #1a4f72;">진료요청</button>
                		</div>
                		<div style="margin-bottom: 198px;"></div>
                 </div>
                </div>
			</div>
</div>