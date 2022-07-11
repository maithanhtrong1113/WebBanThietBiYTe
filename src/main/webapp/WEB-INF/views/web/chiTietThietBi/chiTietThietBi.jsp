<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />
<c:url value="/static/image/thietbi" var="thietBiImageUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết Thiết Bi</title>
<style type="text/css">
</style>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${styleUrl}css/chiTietThietBi/chiTietThietBi.css" />


</head>
<body class="bg-light">

	<div class="main">
		<!-- Head-->
		<div class="bg-white">
			<div class="row info ">

				<!--left-->
				<div class="col-5 info__left">

					<img src="${thietBiImageUrl}/${thietBi.moTaThietBi}" width="100%" />
				</div>
				<!--end lef-->


				<div class="col-7 info__middle">

					<h4>${thietBi.tenThietBi }</h4>
					<div>
						<img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> <img
							src="https://www.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_star_yellow.svg"
							alt="" /> 
					</div>
					<div>
						<p style="font-weight: bold;">
							Thương hiệu: <span class="text-danger">${thietBi.tenThuongHieu }</span>
						</p>
					</div>

					<hr>

					<div>
						<span class="info__middle__price">${thietBi.getGiaString() }</span>
						<del>${thietBi.getGiaGocString()} </del>
						<span class="badge badge-danger">${thietBi.khuyenMai}%</span>
					</div>




					<div>
						<div class="col-6">


							<a style="text-decoration: none;"
								href='<c:url value="/gio-hang/them-gio-hang?slug=${thietBi.slug}" />'>
								<button class="btn btn-outline-danger btn-block btn-lg"
									style="margin-top: 20px; font-weight: bold">Mua ngay</button>

							</a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!--End Head-->



		<!--Thong tin chi tiet-->
		<div class="bg-white  mt-3 p-2">
			<div class="row info-detail">
				<div class="col-8">${thietBi.moTa }</div>

				<div class="col-4">
					<table class="table">


						<tr>
							<th>Thời gian bảo hành:</th>
							<td>${thietBi.thoiGianBaoHanh }</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--End thong tin chi tiet-->







	</div>


	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
	<!-- Toastr -->
	<script src="${styleUrl }plugins/toastr/toastr.min.js"></script>

	<script type="text/javascript">
		
	</script>
</body>
</html>