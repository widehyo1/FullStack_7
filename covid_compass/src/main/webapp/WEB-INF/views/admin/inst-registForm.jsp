<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="card">
		<div class="card-header d-flex p-0">
			<h3 class="card-title p-3">기관등록</h3>
			<ul class="nav nav-pills ml-auto p-2">
				<li class="nav-item"><a class="nav-link" href="#tab_1"
					data-toggle="tab" >직접등록</a></li>
				<li class="nav-item"><a class="nav-link active" href="#tab_2"
					data-toggle="tab">파일등록</a></li>
			</ul>
		</div>
		<!-- /.card-header -->
		<div class="card-body">
			<div class="tab-content">
				<div class="tab-pane" id="tab_1">
					<form role="selfform" method="post" action="inst-selfRegist" accept-charset="utf-8" >
						<div class="form-group">
							<label>담당자</label> <input type="text" id="writer"
								readonly="readonly" name="writer" class="form-control"
								value="관리자">
						</div>
						<div class="form-group">
							<label>기관</label> <br> 
							<input id="inst" checked type="radio" name="inst" value="검사소">검사소&nbsp; 
							<input id="pbhlth" type="radio" name="inst" value="보건소">보건소&nbsp; 
							<input id="hspt" type="radio" name="inst" value="병원">병원&nbsp; 
							<input id="ltctr" type="radio" name="inst" value="생활치료센터">생활치료센터
						</div>
						<div class="form-group">
							<label>기관명</label> <input type="text" id="inst" name="instName"
								class="form-control" value="">
						</div>
						<div class="form-group">
							<label>연락처</label> <input type="text" id="inst" name="instCall"
								class="form-control" value="">
						</div>
						<div class="form-group row">
							<div class="col-10">
								<label for="instAddr">주소</label>
									<input type="text" id="instAdres" name="instAdres" class="form-control" value="">
							</div>
							<div class="col-2" style="margin-top: 32px;">
								  <button type="button" onclick="address_go();" class="btn btn-secondary" style="float: right; width:100%; background-color: #1a4f72;">검색</button>
							</div>
						</div>

					</form>
					<div style="float: right;">
						<button type="button" style="background: #1a4f72; color: #ffffff; border-color: #5b6f90;"
							    class="btn btn-secondary" id="registBtn" onclick="selfRegist_go();">등록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" style="background: #1a4f72; color: #ffffff; border-color: #5b6f90;"
							    class="btn" id="cancelBtn" onclick="CloseWindow();">취 소</button>
						</div>
					
				</div>
				<!-- /.tab-pane -->
				<div class="tab-pane active" id="tab_2">
					<form enctype="multipart/form-data" role="fileform" method="post" action="inst-fileRegist" name="registForm">
					<div class="form-group">
							<label>기관</label> <br> 
							<input id="inst" checked type="radio" name="inst" value="검사소">검사소&nbsp; 
							<input id="pbhlth" type="radio" name="inst" value="보건소">보건소&nbsp; 
							<input id="hspt" type="radio" name="inst" value="병원">병원&nbsp; 
							<input id="ltctr" type="radio" name="inst" value="생활치료센터">생활치료센터
					</div>
					<div class="form-group">
						<div class="card card-outline card-secondary">
							<div class="card-footer fileInput">
								<input type="file" name="instFile" onchange="fileCheck()">
							</div>
						</div>
					</div>
					<div style="float: right;">
						<button type="button"
							style="background: #1a4f72; color: #ffffff; border-color: #5b6f90;"
							class="btn btn-secondary" id="registBtn" onclick="fileRegist_go();">등록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button"
							style="background: #1a4f72; color: #ffffff; border-color: #5b6f90;"
							class="btn" id="cancelBtn" onclick="CloseWindow();">취 소</button>
					</div>
					
					</form>
					
				</div>
				<!-- /.tab-pane -->

			</div>
			<!-- /.tab-content -->
		</div>
		<!-- /.card-body -->
	</div>



	

	<script>
 		$('input[name="inst"]').click(function(){

 			$('input[name="inst"]').attr("checked",false);
 			$(this).attr("checked",true);
		})

		function fileCheck(){
			var files=$('input[name="instFile"]');
			for(var file of files){
				//alert(file.value);
				var fileType = file.value.substr(file.value.lastIndexOf(".")+1).toUpperCase();
				//alert(fileType);
				if(!(file.value=="")){
					if(!(fileType=="XLSX"||fileType=="XLS")){
						alert("파일은 xlsx 형식과 xls 형식만 가능합니다.");
						file.value="";
						return;
					}
				}
			}
		}
		
 		function selfRegist_go(){
 			alert("직접등록버튼");
 			var selfForm=$('form[role="selfform"]');
 			selfForm.submit();
 		}
 		
 		
		function fileRegist_go(){
			alert("파일등록버튼");
			var files=$('input[name="instFile"]');
			for(var file of files){
				if(file.value==""){
					alert("파일을 선택하세요");
					file.focus();
					file.click();
					return;
				}
			}
			var fileForm=$('form[role="fileform"]');
			fileForm.submit();

		}
		
		function address_go(){
			 new daum.Postcode({
			        oncomplete: function(data) {
			            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
			            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			            var addr = ''; // 주소 변수
			            var extraAddr = ''; // 참고항목 변수

			            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
			                addr = data.roadAddress;
			            } else { // 사용자가 지번 주소를 선택했을 경우(J)
			                addr = data.jibunAddress;
			            }

			            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			            if(data.userSelectedType === 'R'){
			                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                    extraAddr += data.bname;
			                }
			                // 건물명이 있고, 공동주택일 경우 추가한다.
			                if(data.buildingName !== '' && data.apartment === 'Y'){
			                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                }
			                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			                if(extraAddr !== ''){
			                    extraAddr = ' (' + extraAddr + ')';
			                }
			                // 조합된 참고항목을 해당 필드에 넣는다.
			                document.getElementById("instAdres").value = extraAddr;
			            
			            } else {
			                document.getElementById("instAdres").value = '';
			            }

			            // 우편번호와 주소 정보를 해당 필드에 넣는다.
			            document.getElementById("instAdres").value = addr+" ";
			            // 커서를 상세주소 필드로 이동한다.
			            document.getElementById("instAdres").focus();
			        }
			    }).open();
		}

	</script>

</body>
</html>