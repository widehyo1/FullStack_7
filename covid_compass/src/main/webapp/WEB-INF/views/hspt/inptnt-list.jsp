<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<style>
.on{
	background-color: rgb(236, 236, 236);
}
</style>
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
								<li class="nav-item"><button type="button" class="btn btn-primary float-left" style="background: #1a4f72; border: 0px; width: 90px; margin-top: 1px;
   																													 margin-right: 200px;">재검요청</button></li>
								<li class="nav-item"><div class="input-group float-right" style="max-width: 600px; width:300px;">
					<!-- search bar -->
					<select class="form-control " name="searchType" id="searchType">
						<option value="" ${pageMaker.cri.searchType eq '' ? 'selected':''}>검색구분</option>
						<option value="n"
							${pageMaker.cri.searchType eq 'n' ? 'selected':''}>성명</option>
						<option value="t"
							${pageMaker.cri.searchType eq 't' ? 'selected':''}>연락처</option>
					</select>

					<!-- keyword -->
					<input class="form-control" type="text" name="keyword"
						value="${pageMaker.cri.keyword }"
						style="width: 18%; display: inline-block;" /> <span
						class="input-group-append">
						<button class="btn btn-primary" type="button" id="searchBtn"
							style="background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px; margin-left: -7px;"
							data-card-widget="search" onclick="list_go(1, '<%=request.getContextPath() %>/rest-hspt/inptnt-list');">
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
                  <%@ include file="./inptnt-list-module-work.jsp"%>
                </div>
              </div>
            </div>
            <!-- /.card -->
          </div>

        </section>

      </div>
			<div class="col-lg-6 pr-0">
				<section class="content">
					<div class="card"
						style="margin: 1px; height: 763px; margin-top: 13px;">
						<div class="card-header d-flex p-0">
							<ul class="nav nav-pills ml-auto p-2" role="tablist">
								<li class="nav-item"><a class="nav-link active" id="psti-detail-tab" data-toggle="pill" href="#custom-dgnss-detail" role="tab" aria-controls="custom-tabs-three-home" aria-selected="true" style="cursor: default; background-color: #1a4f72;">환자 상세</a></li>
							</ul>
						</div>
						<div class="card-body">
							<div class="tab-content" id="custom-tabs-three-tabContent">
								<div class="tab-pane fade show active" id="custom-inptnt-detail"
									role="tabpanel" aria-labelledby="custom-tabs-three-home-tab">
									<%@ include file="./inptnt-detail-module-work.jsp"%>
<form name="inptntModifyForm">
  pstiNm<input type="text" name="pstiNm">
  pstiTelno<input type="text" name="pstiTelno">
  pstiAdres<input type="text" name="pstiAdres">
  symptms<input type="text" name="symptms">
  areaNo<input type="text" name="areaNo">
  pstiNo<input type="text" name="pstiNo">
</form>
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
  


<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="inptnt-list-template" >
{{#each .}}
          <tr
			data-manage-no="{{manageNo}}"
            ondblclick="OpenWindow('sckbdreq-inptnt?manageNo={{manageNo}}', '진료 신청 정보', 1250, 800)"
            onclick="showDetail('{{manageNo}}')"
            class="each-inptnt-element">
            <td><input type="checkbox" name="checkSmple"
              onclick="cancleAll()"></td>
            <td>{{pstiNm}}</td>
            <td>{{age}}</td>
            <td>{{gender}}</td>
            <td>{{pstiTelno}}</td>
            <td>{{inYmd}}</td>
            <td>{{ngtvCnt}}</td>
          </tr>
{{/each}}
</script>

<script type="text/x-handlebars-template"  id="inptnt-pagination-template" >
    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="1"> <i class="fas fa-angle-double-left" style="color:#1a4f72;"></i>
    </a></li>
    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="{{#if prev}}{{prevPageNum}}{{/if}}"> <i class="fas fa-angle-left" style="color:#1a4f72;"></i>
    </a></li>

{{#each pageNum}}
    <li class="page-item each-inptnt-pagination-element {{this}}" ><a class="page-link" href="{{this}}" >{{this}}</a></li>
{{/each}}

    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="{{#if next}}{{nextPageNum}}{{/if}}"> <i class="fas fa-angle-right" style="color:#1a4f72;"></i>
    </a></li>
    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="{{realEndPage}}"> <i class="fas fa-angle-double-right" style="color:#1a4f72;"></i>
</a></li>
</script>

<%@ include file="../template/handlebars_js.jsp" %>

<script>
    function checkAllBox(checkBox){
      var length = document.getElementsByName("checkSmple").length;
      if(document.getElementById('all').checked==true){
        for(var i=0; i<length; i++) document.getElementsByName("checkSmple")[i].checked=true;
      }
      
      if(document.getElementById('all').checked==false){
        for(var i=0; i<length; i++) document.getElementsByName("checkSmple")[i].checked=false;
      }
      
      
    }
    
    function cancleAll(){
      //alert("눌림");
      if(document.getElementById('all').checked==true){
        document.getElementById('all').checked=false;
      }
    }

Handlebars.registerHelper({
	"prettifyDate" : function(timeValue){
	  var dateObj = new Date(timeValue);
	  var year = dateObj.getFullYear();
	  var month = dateObj.getMonth() + 1;
	  var date = dateObj.getDate();
	  return year + "-" + month + "-" + date;
	},
	"signActive" : function(pageNum){
	  if(pageNum == page) return 'active';
	},
	"getInstNm" : function(pbhtNm, ltctNm){
		
		return pbhtNm || ltctNm;
	},
	"addClass" : function(pbhtNm, ltctNm){
		if(pbhtNm){
			return "pbht";
		}
		if(ltctNm){
			return "ltct";
		}
	}
	});


var page = 1;

window.onload = function(){

  var url = '<%=request.getContextPath() %>/rest-hspt/inptnt-list';

  list_go(page, url);
	$('ul.pagination').on('click','li a',function(event){
		if($(this).attr("href")) {
			page=$(this).attr("href");
			getPage(url, make_form(page));
		}
		
		return false;
	});
}
function make_form(pageParam){
  var jobForm=$('#jobForm');
  
  if(!pageParam) page = 1;
  
  page = pageParam;
  
  jobForm.find("[name='page']").val(page);
  jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
//  jobForm.find("[name='perPageNum']").val(2);
  jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
  jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
  
  return jobForm;
}

function list_go(pageParam, url){
	
  getPage(url, make_form(pageParam));
}

function getPage(handelbarsProcessingURL, form){

	$.ajax({
    url : handelbarsProcessingURL,
    type : 'get',
    dataType : 'json',
    data : form.serialize(),
    success : function(dataMap){
    	printData(dataMap.inptntList, $('#inptnt-list-table-tbody'), $('#inptnt-list-template'), '.each-inptnt-element');
        printPagination(dataMap.pageMaker, $('#inptnt-list-pagination-ul'), $('#inptnt-pagination-template'), '.each-inptnt-pagination-element');
    },
    error : function(error){
      alert('error' + error.status);
    }
  })
 }
 
//jsonArray는 ResponseEntity에서 넣어준 List가 들어가는 자리
//target은 handlebars로 생성한 마크업을 append할 대상으로 jquery객체이며 리스트에서 쓸 경우 보통 tbody에 id를 줘서 target으로 잡는다.
//templateObject는 handlebars를 이용하여 만든 템플릿으로 jquery객체이다.
//removeClass는 append하기전에 기존에 있던 리스트<여기서는 handlebars로 붙인 요소 목록>를 지우기 위해서 '.(클래스이름)'을 넣는다.
//이를 위하여 templateObject에서 handlebars로 붙인 요소 목록를 지칭할 class를 주어야 한다. 여기서는 .each-inptnt-element이며,
//tr태그에 붙어있다.
function printData(jsonArray, target, templateObject, removeClass){

	// templateObject를 json data를 받으면 마크업을 return하는 function template로 반환한다.
	var template = Handlebars.compile(templateObject.html());
	
	// 함수 template에 파라미터 jsonArray를 넣어서 실행하여 html을 생성한다.
	var html = template(jsonArray);
	
	// 해당 html요소를 append하기 전에 기존에 있던 내용을 지운다. (안그러면 리스트 목록이 10개씩만 보이는 게 아니라 10개, 20개, 30개 등 페이지 클릭할 때마다 10개씩 추가되므로)
	$(removeClass).remove();
	
	// html요소를 append한다.
	target.append(html);
}

function printPagination(pageMaker, target, templateObject, removeClass){
	 
	
	var pageNum = new Array(pageMaker.endPage-pageMaker.startPage+1);
	
	for(var i=0;i<pageMaker.endPage-pageMaker.startPage+1;i++){
		pageNum[i]=pageMaker.startPage+i;
	}	
	pageMaker.pageNum=pageNum;  
	pageMaker.prevPageNum=pageMaker.startPage-1;
	pageMaker.nextPageNum=pageMaker.endPage+1;
	
	var template=Handlebars.compile(templateObject.html());	
	var html = template(pageMaker);	
	target.html("").html(html);
}

function prettyDate(timeValue){
	  var dateObj = new Date(timeValue);
	  var year = dateObj.getFullYear();
	  var month = dateObj.getMonth() + 1;
	  var date = dateObj.getDate();
	  return year + "-" + month + "-" + date;
	}

function showDetail(manageNo){
	
	var trs = $('tr.each-inptnt-element');
	
	trs.removeClass('on');
	
	var target = $('tr[data-manage-no="'+manageNo+'"]');
	
	target.addClass('on');
	
	var url = '<%=request.getContextPath()%>/rest-hspt/inptnt-detail';
	
	$.ajax({
	    url : url,
	    type : 'post',
	    dataType : 'json',
	    data : {'manageNo': manageNo},
	    success : function(inptntDetailCommand){
	    	
        	var age               = inptntDetailCommand.age               ;
        	var areaNo            = inptntDetailCommand.areaNo            ;
        	var dgnssCode         = inptntDetailCommand.dgnssCode         ;
        	var dgnssNo           = inptntDetailCommand.dgnssNo           ;
        	var dgnssNote         = inptntDetailCommand.dgnssNote         ;
        	var dgnssResultCode   = inptntDetailCommand.dgnssResultCode   ;
        	var feverYn           = inptntDetailCommand.feverYn           ;
        	var gender            = inptntDetailCommand.gender            ;
        	var inYmd             = inptntDetailCommand.inYmd             ;
        	var jobCode           = inptntDetailCommand.jobCode           ;
        	var manageNo          = inptntDetailCommand.manageNo          ;
        	var nlty              = inptntDetailCommand.nlty              ;
        	var pregnYn           = inptntDetailCommand.pregnYn           ;
        	var pstiAdres         = inptntDetailCommand.pstiAdres         ;
        	var pstiNm            = inptntDetailCommand.pstiNm            ;
        	var pstiNo            = inptntDetailCommand.pstiNo            ;
        	var pstiTelno         = inptntDetailCommand.pstiTelno         ;
        	var pstvYn            = inptntDetailCommand.pstvYn            ;
        	var reqYmd            = inptntDetailCommand.reqYmd            ;
        	var resYmd            = inptntDetailCommand.resYmd            ;
        	var rrn               = inptntDetailCommand.rrn               ;
        	var smplNo            = inptntDetailCommand.smplNo            ;
        	var symptms           = inptntDetailCommand.symptms           ;
        	var vacCode           = inptntDetailCommand.vacCode           ;
        	var vacType           = inptntDetailCommand.vacType           ;
        	var ngtvCnt			  = inptntDetailCommand.ngtvCnt			  ;
          
        	$('input[name="pstiNm"]').val(pstiNm);
        	$('input[name="pstiTelno"]').val(pstiTelno);
        	$('input[name="pstiAdres"]').val(pstiAdres);
        	$('input[name="symptms"]').val(symptms);
        	$('input[name="pstiNo"]').val(pstiNo);
        	$('input[name="nlty"]').val(nlty);
        	$('input[name="age"]').val(age);
        	$('input[name="gender"]').val(gender);
        	$('input[name="rrn"]').val(rrn);
        	$('input[name="jobCode"]').val(jobCode);
        	$('input[name="inYmd"]').val(prettyDate(inYmd));
          	$('input[name="critCode"]').val(dgnssResultCode);
          	$('input[name="ngtvCnt"]').val(ngtvCnt);
        	$('input[name="feverYn"]').val(feverYn);
        	$('input[name="pregnYn"]').val(pregnYn);
        	
        	$('form[name="inptntModifyForm"] input[name="pstiNm"]').val(pstiNm);
        	$('form[name="inptntModifyForm"] input[name="pstiTelno"]').val(pstiTelno);
        	$('form[name="inptntModifyForm"] input[name="pstiAdres"]').val(pstiAdres);
        	$('form[name="inptntModifyForm"] input[name="symptms"]').val(symptms);	
        	$('form[name="inptntModifyForm"] input[name="areaNo"]').val(areaNo);	
        	$('form[name="inptntModifyForm"] input[name="pstiNo"]').val(pstiNo);

	    },
	    error : function(error){
	      alert('error' + error.status);
	    },
	    beforeSend : function(){
	    	var template = Handlebars.compile($('#loading-template').html());
	    	var html = template();
	    	$('.inptnt-detail-info').css('display','none');
	    	$('#inptnt-detail-info-module').append(html);
	    },
	    complete : function(){
	    	$('.loading-class').remove();
	    	$('.inptnt-detail-info').css('display','');
	    	
	    }
	  });
}
</script>
 <script type="text/javascript">
    function modify(){
      alert("수정후 저장 버튼을 눌러주세요");
      $('.modifyPossible').attr('readonly', false);
      $('.modifyPossible').css('border-color', 'blue');
      
      $('#inptnt-cancle-btn').css('display', '');
      $('#inptnt-save-btn').css('display', '');
      $('#inptnt-modify-hidden-div').css('display', 'none');
      $('#inptnt-modify-cancle-div').css('display', '');
      $('#inptnt-sckbd-req-btn').css('display','none');
      $('#inptnt-modify-btn').css('display','none');
    }
    function cancle(){
      //alert("취소!");
      $('.modifyPossible').attr('readonly', true);
      $('.modifyPossible').css('border-color', '');
      
      $('#inptnt-cancle-btn').css('display', 'none');
      $('#inptnt-save-btn').css('display', 'none');
      $('#inptnt-modify-hidden-div').css('display', '');
      $('#inptnt-modify-cancle-div').css('display', 'none');
      $('#inptnt-sckbd-req-btn').css('display','');
      $('#inptnt-modify-btn').css('display','');
    }
    
    function save(){
    	var pstiNm = $('#inptnt-detail-info-module input[name="pstiNm"]').val();
    	var pstiTelno = $('#inptnt-detail-info-module input[name="pstiTelno"]').val();
    	var pstiAdres = $('#inptnt-detail-info-module input[name="pstiAdres"]').val();
    	var symptms = $('#inptnt-detail-info-module input[name="symptms"]').val();
    	var pstiNo =$('#inptnt-detail-info-module input[name="pstiNo"]').val();
    	var areaNo = "???";
    	
    	console.log(pstiNm, pstiTelno, pstiAdres, symptms, pstiNo, areaNo);
    	
    	$('form[name="inptntModifyForm"] input[name="pstiNm"]').val(pstiNm);
    	$('form[name="inptntModifyForm"] input[name="pstiTelno"]').val(pstiTelno);
    	$('form[name="inptntModifyForm"] input[name="pstiAdres"]').val(pstiAdres);
    	$('form[name="inptntModifyForm"] input[name="symptms"]').val(symptms);	
    	$('form[name="inptntModifyForm"] input[name="areaNo"]').val(areaNo);	
    	$('form[name="inptntModifyForm"] input[name="pstiNo"]').val(pstiNo);
    	
    	var inptntModifyForm = $('form[name="inptntModifyForm"]');
    	
    	var url = '<%=request.getContextPath()%>/rest-hspt/process-inptnt-modify';
    	
		$.ajax({
			url : url,
			type : 'post',
			data : inptntModifyForm.serialize(),
			dataType : 'json',
			success : function(msg) {
				
				alert(msg);
			},
			error : function(error) {
				alert('error' + error.status);
			},
			complete : function(){
				
				$('.modifyPossible').attr('readonly', true);
			    $('.modifyPossible').css('border-color', '');
			    
			}
		});    	
    	
    }
  </script>
</body>
