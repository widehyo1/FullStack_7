<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<head>
   <style>
      .redcircle{
         color: red; 
      }
      .orangecircle{
         color:orange;
      }
      .greencircle{
         color: green;
      }
   </style>
</head>
<title></title>

<body >
<input type="hidden" value="대전광역시 서구 만년동 340" id="loginCode">
	<div class="row" style="box-sizing: content-box;padding: 1px;">
		<div class="col-lg-3" style="margin-top: 20px;">
			<div class="card">
<!--               <div class="card-header"> -->
<!--                 <h3 class="card-title">범례</h3> -->
<!--               </div> -->
              <!-- /.card-header -->
              <div class="card-body" style="margin-bottom: 11px;">
                <table class="table table-bordered text-nowrap" style="text-align: center;">
                  <thead>
                    <tr>
                      <th colspan="2">범례</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>마커</td>
                      <td>병상수 대비 사용률</td>
                    </tr>
                    <tr>
                      <td><span class="redcircle">●</span></td>
                      <td>80% 이상</td>
                    </tr>
                    <tr>
                      <td><span class="orangecircle">●</span></td>
                      <td>70 ~ 79%</td>
                    </tr>
                    <tr>
                      <td><span class="greencircle">●</span></td>
                      <td>70% 이하</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              
<!--               <div class="card-header"> -->
<!--                 <h3 class="card-title">확진자리스트</h3> -->
<!--               </div> -->
              <div class="card-body">
              
                <table class="table table-bordered table-hover text-nowrap" style="text-align: center;">
                  <thead>
                  	<tr>
                  	  <th colspan="3" style="vertical-align: middle;"><span>확진자리스트</span><ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="#">«</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">»</a></li>
                </ul></th>
                  	</tr>
                    <tr>
                      <th style="width: 10px"><input type="checkbox"></th>
                      <th>이름</th>
                      <th>확진일</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><input type="checkbox" class="addrcheck" value="대전 중구 대흥동 500-5"></td>
                      <td>${pstiNm }홍길동</td>
                      <td>${inYmd }2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox" class="addrcheck" value="대전광역시 중구 대흥동 504-5"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox" class="addrcheck" value="대전광역시 서구 갈마동 305-4"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox" class="addrcheck" value="대전광역시 서구 월평동 1220"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td>홍길동</td>
                      <td>2022-01-01</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
		</div>
		
		<div class="col-lg-9" style="margin-top: 20px;">
		  <div class="">
		    <div class="row">
			  <div class="col-md-6">
			    <table class="table table-bordered table-hover text-nowrap" style="text-align: center;">
                  <thead>
                  	<tr>
                  	  <th colspan="4" style="vertical-align: middle; text-align: left;"><span>병원리스트</span><ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="#">«</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">»</a></li>
                </ul></th>
                  	</tr>
                    <tr>
                      <th>순번</th>
                      <th>병원명</th>
                      <th>잔여병상 수</th>
                      <th>병상가동률</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td><input type="hidden" value="대전광역시 중구 대사동 640" name="hsptl">${hsptlNm }충남대학병원</td>
                      <td>${rmndSckbdCnt }1</td>
                      <td>98%</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td><input type="hidden" value="대전광역시 서구 관저동 1643" name="hsptl">건양대학병원</td>
                      <td>56</td>
                      <td>48%</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td><input type="hidden" value="대전광역시 서구 둔산동 1306" name="hsptl">을지대학병원</td>
                      <td>88</td>
                      <td>37%</td>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td><input type="hidden" value="대전광역시 중구 오류동 175-13" name="hsptl">인재대학병원</td>
                      <td>37</td>
                      <td>67%</td>
                    </tr>
                  </tbody>
                </table>
			  </div>
			  <div class="col-md-6">
			  <table class="table table-bordered text-nowrap" style="text-align: center;">
                  <thead>
                  	<tr>
                  	  <th colspan="4" style="text-align: left; vertical-align: middle; margin-bottom: 4px;"><span style="margin-top: 7px;">진료요청</span><button type="submit" class="btn btn-success btn-sm" style="background-color: #1a4f72; border-color: #1a4f72; float: right;">진료요청</button></th>
                  	</tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td style="background-color: #f5f6f7;"><strong>성명</strong></td>
                      <td >${pstiNm }강건</td>
                      
                      <td style="background-color: #f5f6f7;"><strong>생년월일</strong></td>
                      <td >${rrn }1996/06/25</td>
                      
                    </tr>
                    
                    <tr>
                      <td style="background-color: #f5f6f7;"><strong>성별</strong></td>
                      <td>${gender }남</td>
                      
                      <td style="background-color: #f5f6f7;"><strong>연락처</strong></td>
                      <td>${pstiTelno }010-7777-7777</td>
                      
                      
                    </tr>
                    
                     <tr>
                      <td style="background-color: #f5f6f7;"><strong>주소</strong></td>
                      <td colspan="3">${pstiAdres }대전광역시 유성구 봉명동 304-3 1801호</td>
                    </tr>
                    
                    <tr>
                       <td style="background-color: #f5f6f7;"><strong>증상</strong></td>
                       <td colspan="3">${symptms }어지러움, 발열, 호흡곤란</td>
                    </tr>
                    
                    <tr>
                       <td style="background-color: #f5f6f7;"><strong>병원명</strong></td>
                       <td colspan="3">${hsptlNm }을지대학병원</td>
                    </tr>
                  </tbody>
                </table>
			  </div>
			   </div>
			  <div class="row">
			      <div class="col-md-12">
			  <div class="card">
			        <div id="map" style="width:1000px;height:505px;"></div>
			      </div>
			  </div>
			  </div>
		   
		  </div>
		</div>
	</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=553e55e7a953a05a2adfe2bfc2932452&libraries=services"></script>
<script>
window.onload = function(){
	var defaultMap = document.getElementById('loginCode').value;

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};  

	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	//주소로 좌표를 검색합니다
	geocoder.addressSearch(defaultMap, function(result, status) {

	// 정상적으로 검색이 완료됐으면 
	 if (status === kakao.maps.services.Status.OK) {

	    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	    // 결과값으로 받은 위치를 마커로 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: coords
	    });
	    
	  // 인포윈도우로 장소에 대한 설명을 표시합니다  
	   /*  var infowindow = new kakao.maps.InfoWindow({
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
	    });
	    infowindow.open(map, marker); */

	    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	    map.setCenter(coords);
	} 
	});
	
// function removeMarker(){
// 	for (var i = 0; i < markers.length; i++){
// 		infowindow.close();
// 		markers[i].setMap(null);
// 	}
// 	markers = [];
// }

//확진자 체크시 확진자 주소
$('.addrcheck').on('click', function(){
	removeMarker();
	//체크박스 1개만 선택할수있게 설정해준다.
	if($(this).prop('checked')){
		$('input[type="checkbox"]').prop('checked',false);
		$(this).prop('checked',true);
	}
// 	alert($(this).val());
	var psti = $(this).val();
	
	addToMarker(psti);

})


// 마크 찍어주는 역할
function addToMarker(obj){
	geocoder.addressSearch(obj, function(result, status) {
		// 정상적으로 검색이 완료됐으면 
		 if (status === kakao.maps.services.Status.OK) {

		    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		    // 결과값으로 받은 위치를 마커로 표시합니다
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: coords
		    });
		    
		  // 인포윈도우로 장소에 대한 설명을 표시합니다  
		   /*  var infowindow = new kakao.maps.InfoWindow({
		        content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		    });
		    infowindow.open(map, marker); */

		    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		    map.setCenter(coords);
		} 
		});   
}
// var imageSrc1 = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png';
<%-- 	imageSrc2 = "<%=request.getContextPath()%>/resources/image/hsptlmarker.png"; --%>
// 	imageSize = new kakao.maps.Size(64, 69);
// 	imageOption = {offset: new kakao.maps.Point(27.69)};

// var marker = new kakao.maps.Marker({
// 	position: markerPosition,
// 	image: markerImage
// });

}

</script>
</body>