<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head></head>

<title></title>

<body class="hold-transition sidebar-mini">
  <div class="content-wrapper">
	<div class="wrapper" style="background: #ffffff;">
		<div class="card card-success">
			
			<!-- Main content -->

			<div class="row">
				<div class="col-md-12">
					<div>
						
						<!-- /.card-header -->


						<div class="col-md-12">


							<div class="card-body">
								<div class="form-group">
									<label for="inputName">제목</label> <input type="text"
										id="inputName" class="form-control">
								</div>

								<div class="form-group">
									<label for="inputWriter">작성자</label> 
									<input type="text" id="inputWriter" class="form-control">
								</div>

								<div class="form-group">
									<label for="inputDescription">내용</label>
									<textarea id="summernote"></textarea>
								</div>

								<div class="form-group" style="border: none;">
									<label for="inputClientCompany">파일 첨부</label> <input
										type="file" id="inputFile"
										style="border: none; display: block;">
								</div>

								<div class="form-group" style="border: none; text-align: right;">
									<button class="btn" style="background-color: #1a4f72; color: white">등록</button>
									<button class="btn" style="margin-left: 1%; background-color: #1a4f72; color: white">리셋</button>
									<button class="btn" style="margin-left: 1%; background-color: #1a4f72; color: white" onclick="CloseWindow()">취소</button>
								</div>

							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>

				</div>

			</div>
		</div>
		<!-- /.col-->
	</div>
</div>
	<!-- /.content-wrapper -->


	<!-- Page specific script -->
	<script>
		window.onload = function() {
			// Summernote
			$('#summernote').summernote({
				height : 200
			})
		}
	</script>

</body>
