<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
		function go_chckdPstiList(){
			location.href = "<%=request.getContextPath()%>/insp/chckd-psti-list";
		}
		function go_pstiList(){
			location.href = "<%=request.getContextPath()%>/insp/psti-list";
		}
		function go_resPstiList(){
			location.href = "<%=request.getContextPath()%>/insp/res-psti-list";
		}
</script>
		<table>
			<tr>
				<th class="nav-item subMenu"><a	href="javascript:go_pstiList();" class="nav-link"><p>문진표 목록</p></a></th>
				<th class="nav-item subMenu"><a	href="javascript:go_chckdPstiList();" class="nav-link"><p>피검자목록</p></a></th>
				<th class="nav-item subMenu"><a href="javascript:go_resPstiList();" class="nav-link"><p>검사결과목록</p></a></th>
			</tr>
		</table>