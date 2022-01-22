<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/x-handlebars-template" id="res-template">
{{#each .}}
	<tr class="each-res-element">
		<td><a href="pages/examples/invoice.html">{{pstiNm}}</a></td>
		<td>{{prettify reqYmd}}</td>
		<td><span class="badge badge-{{fnBadgetPstvYn chkdYn pstvYn}}" style="color: white; background-color: #17A2B8;">{{fnPstvYn chkdYn pstvYn}}</span></td>
	</tr>
{{/each}}
</script>
<script type="text/x-handlebars-template" id="res-pagination-template">
	<li class="page-item each-res-pagination-element">
		<a class="page-link" href="1">
			<i class="fas fa-angle-double-left" style="color:#1a4f72;"></i>
		</a>
	</li>

	<li class="page-item each-res-pagination-element">
		<a class="page-link" href="{{#if prev}}{{prevPageNum}}{{/if}}">
			<i class="fas fa-angle-left" style="color:#1a4f72;"></i>
		</a>
	</li>
	
	{{#each pageNum}}
		<li class="page-item each-res-pagination-element {{resSignActive this}}" >
			<a class="page-link" style="{{resStyleActive this}}" href="{{this}}">
				{{this}}
			</a>
		</li>
	{{/each}}
	
	<li class="page-item each-res-pagination-element">
		<a class="page-link" href="{{#if next}}{{nextPageNum}}{{/if}}">
			<i class="fas fa-angle-right" style="color:#1a4f72;"></i>
		</a>
	</li>

	<li class="page-item each-res-pagination-element">
		<a class="page-link href="{{realEndPage}}">
			<i class="fas fa-angle-double-right" style="color:#1a4f72;"></i>
		</a>
	</li>
</script>
<div class="card" style="position: relative; margin-left: 18px; left: 0px; top: 0px; width: 407px;">
					<div class="card-header ui-sortable-handle" style="cursor: move;">
						<h3 class="card-title">
							<i class="ion ion-clipboard mr-1"></i> 재검 결과
						</h3>

						<div class="card-tools">
							<ul class="res-pagination pagination pagination-sm" id="res-pagination-ul">
						</ul>
						</div>
					</div>
					<form id="resListForm">
						<input type='hidden' name="page" value="" />
						<input type='hidden' name="perPageNum" value="" />
						<input type='hidden' name="searchType" value="" />
						<input type='hidden' name="keyword" value="" />
					</form>
					<div class="card-body" style="padding: 0px;">
						<div class="table-responsive">
							<table class="table m-0" style="text-align: center;">
								<thead>
									<tr>
										<th style="text-align: center;">성명</th>
										<th style="text-align: center;">검사일자</th>
										<th style="text-align: center;">결과</th>
									</tr>
								</thead>
								<tbody id="res-table-tbody">
									<tr class="each-res-element">
										<td colspan="3">페이지 로딩중입니다.</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>

				</div>