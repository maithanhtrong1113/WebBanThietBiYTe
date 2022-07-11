<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/static/admin/" var="styleUrl" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm thiết bị</title>
<link rel="stylesheet" href="${styleUrl }plugins/toastr/toastr.min.css">
<!-- summernote -->
<link rel="stylesheet"
	href="${styleUrl }plugins/summernote/summernote-bs4.min.css">

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<div class="content-wrapper">
		<section class="content">

			<div class="container-fluid">

				<div class="row">


					<div class="col-12">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Form nhập thông tin thiết bị</h3>
							</div>
							<!-- /.card-header -->

							<!-- Form add -->

							<form:form modelAttribute="thietBi" method="post" id="myForm"
								name="myForm" enctype="multipart/form-data"
								onsubmit="return(validate());">

								<div class="card-body">

									<div class="row">
										<form:hidden path="id" />
										<form:hidden path="moTaThietBi" />

										<div class="form-group col-12">
											<label>Tên thiết bị</label>


											<form:input path="tenThietBi" cssClass="form-control" />
											<label id="tenThietBiErr" class="error"></label>
											<form:errors cssClass="error" path="tenThietBi" />

										</div>


										<div class="form-group col-6">
											<label>Giá</label>

											<form:input path="gia" cssClass="form-control" />
											<label id="giaErr" class="error"></label>
											<form:errors cssClass="error" path="gia" />


										</div>

										<div class="form-group col-6">
											<label>Khuyến mãi</label>

											<form:input path="khuyenMai" cssClass="form-control" />
											<label id="khuyenMaiErr" class="error"></label>
											<form:errors cssClass="error" path="khuyenMai" />

										</div>

										<div class="form-group col-6">
											<label>Nổi bật</label> <br>
											<div class="form-check-inline">
												<label class="form-check-label"> <form:radiobutton
														path="noiBat" value="true" cssClass="form-check-input" />
													Nổi bật
												</label>
											</div>
											<div class="form-check-inline">
												<label class="form-check-label"> <form:radiobutton
														path="noiBat" value="false" cssClass="form-check-input" />Không
													nổi bật
												</label>
											</div>
										</div>

										<div class="form-group col-6">
											<label>Thời gian bảo hành</label>

											<form:input path="thoiGianBaoHanh" cssClass="form-control" />
											<label id="thoiGianBaoHanhErr" class="error"></label>
											<form:errors cssClass="error" path="thoiGianBaoHanh" />
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">
												<label>Thương hiệu</label>

												<form:select path="tenThuongHieu" cssClass="form-control">

													<c:forEach items="${tenThuongHieus }" var="x">

														<c:if test="${thietBi.tenThuongHieu == x }">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if test="${thietBi.tenThuongHieu != x }">
															<option value="${x}">${x }</option>
														</c:if>


													</c:forEach>

												</form:select>
											</div>
										</div>

										<div class="col-6">
											<!-- select -->
											<div class="form-group">
												<label>Nhóm thiết bị</label>

												<form:select path="tenNhomThietBi" cssClass="form-control">

													<c:forEach items="${tenNhomThietBis }" var="x">


														<c:if test="${thietBi.tenNhomThietBi == x }">
															<option value="${x}" selected="selected">${x }</option>
														</c:if>

														<c:if test="${thietBi.tenNhomThietBi != x }">
															<option value="${x}">${x }</option>
														</c:if>

													</c:forEach>

												</form:select>
											</div>
										</div>



										<div class="col-12">

											<div class="form-group">
												<label>Hình ảnh</label>

												<div class="input-group">
													<div class="custom-file">
														<input type="file" class="custom-file-input"
															id="exampleInputFile" name="file"> <label
															class="custom-file-label" for="exampleInputFile">Choose
															file</label>
													</div>
													<div class="input-group-append">
														<span class="input-group-text">Upload</span>
													</div>
												</div>


											</div>

										</div>


										<!-- Mo ta -->
										<div class="col-12">

											<label>Mô tả</label>

											<form:textarea path="moTa" id="summernote" />


										</div>





									</div>





								</div>
								<!-- /.card-body -->

								<div class="card-footer">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</form:form>

							<!-- End form -->
						</div>

					</div>

				</div>

			</div>

		</section>

	</div>




	<script type="text/javascript"
		src="${styleUrl}plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>

	<!-- bs-custom-file-input -->
	<script
		src="${styleUrl}plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>

	<!-- Summernote -->
	<script src="${styleUrl }plugins/summernote/summernote-bs4.min.js"></script>



	<script src="${styleUrl }js/thietbi/themthietbi.js"></script>

	<script>
		$(function() {
			bsCustomFileInput.init();
		});
		$(function() {

			$('#summernote').summernote()

		});
	</script>

</body>
</html>