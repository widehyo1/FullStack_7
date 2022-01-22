<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/x-handlebars-template" id="chckd-template">
{{#each .}}
	<tr class="each-chckd-element" onclick="OpenWindow('psti-registform?pstiNo={{pstiNo}}','','1200','750');" style="cursor:pointer; data-psti-no="{{pstiNo}}">
		<td onclick="event.cancelBubble=true" style="text-align: center;"><input type="checkbox" class="form-check-input" name="psti_check" value="{{pstiNo}}"</td>
		<td>{{pstiNm}}</td>
		<td>{{prettifyDate htscYmd}}</td>
		<td>{{age}}</td>
		<td>{{bir}}</td>
		<td>{{pstiTelno}}</td>
	</tr>
{{/each}}
</script>
<script type="text/x-handlebars-template" id="chckd-pagination-template">
	<li class="page-item each-chckd-pagination-element">
		<a class="page-link" href="1">
			<i class="fas fa-angle-double-left" style="color:#1a4f72;"></i>
		</a>
	</li>

	<li class="page-item each-chckd-pagination-element">
		<a class="page-link" href="{{#if prev}}{{prevPageNum}}{{/if}}">
			<i class="fas fa-angle-left" style="color:#1a4f72;"></i>
		</a>
	</li>
	
	{{#each pageNum}}
		<li class="page-item each-chckd-pagination-element {{chkSignActive this}}" >
			<a class="page-link" style="{{chkStyleActive this}}" href="{{this}}">
				{{this}}
			</a>
		</li>
	{{/each}}
	
	<li class="page-item each-chckd-pagination-element">
		<a class="page-link" href="{{#if next}}{{nextPageNum}}{{/if}}">
			<i class="fas fa-angle-right" style="color:#1a4f72;"></i>
		</a>
	</li>

	<li class="page-item each-chckd-pagination-element">
		<a class="page-link href="{{realEndPage}}">
			<i class="fas fa-angle-double-right" style="color:#1a4f72;"></i>
		</a>
	</li>
</script>
<div class="card"
				style="width: 868px; margin-top: 10px; margin-bottom: 20px;">
				<div class="card-header ui-sortable-handle" >
					<h3 class="card-title" style="margin-top: 3px;">
						검사완료 리스트(시료 요청대기)
					</h3>
					<button type="button" style="padding-top: 0px; margin-left: 310px; border-color:#1a4f72; background: #1a4f72; color: white;">검사요청</button>
					<div class="card-tools">
						<ul class="chckd-pagination pagination pagination-sm" id="chckd-list-pagination-ul" style="margin-top: 1px;">
						</ul>
					</div>
				</div>
				<form id="chckdListForm">
					<input type='hidden' name="page" value="" />
					<input type='hidden' name="perPageNum" value="" />
				</form>
				<!-- /.card-header -->
				<div class="card-body" style="padding: 0px;">
					<div class="table-responsive">
						<table class="table table-hover text-nowrap"
							style="text-align: center;">
							<thead>
								<tr role="row">
									<th tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="text-align: center;">
										<div class="form-group">
											<div class="form-check">
												<input type="checkbox" style="cursor:pointer;" class="form-check-input" name="psti_check_all" id="psti_check_all" onclick="checkAll(this, 'pstiCheck');">
											</div>
										</div>
									</th>
									<th tabindex="0" aria-controls="example2" rowspan="1" style="text-align: center;" colspan="1" aria-label="">성명</th>
									<th tabindex="0" aria-controls="example2" rowspan="1" style="text-align: center;" colspan="1" aria-sort="ascending" aria-label="">검사일</th>
									<th tabindex="0" aria-controls="example2" rowspan="1" style="text-align: center;" colspan="1" aria-label="">나이</th>
									<th tabindex="0" aria-controls="example2" rowspan="1" style="text-align: center;" colspan="1" aria-label="">생년월일</th>
									<th tabindex="0" aria-controls="example2" rowspan="1" style="text-align: center;" colspan="1" aria-label="">전화번호</th>
								</tr>
							</thead>
							<tbody id="chckd-table-tbody">
								<tr class="each-chckd-element">
									<td colspan="6">페이지 로딩중입니다.</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /.card-body -->
			</div>