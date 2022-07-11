<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/static/web/" var="styleUrl" />
<c:url value="/static/admin/" var="styleUrlAdmin" />
<c:url value="/static/image/thietbi" var="thietBiImageUrl" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />

<link rel="stylesheet" href="${styleUrl}css/trangChu.css" />

</head>
<body class="bg-light">

	<!--Main-->
	<div class="main">
		<!-- Category đầu-->
		<div class="category">
			<div class="row">
				<!--Menu-->
				<div class="col-4 category__menu">
					<div class="list-group">
						<a href="#"
							class="list-group-item list-group-item-action text-center"
							aria-current="true"
							style="font-size: 18px; font-weight: bold; color: #f7941e">
							Danh mục sản phẩm </a>

						<c:forEach items="${nhomThietBiss}" var="nv">
							<a href='<c:url value="" />'
								class="list-group-item list-group-item-action d-flex justify-content-between align-items-center"
								aria-current="true"> ${nv.tenNhomThietBi } <i
								class="fas fa-chevron-right"></i>
							</a>
						</c:forEach>
					</div>
				</div>
				<!-- End menu-->

				<div class="col-8 category__banner">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img
									src="https://sieuthiyte.com.vn/data/upload/banner-combo-may-massage-kasj-styt-09052022-v2.jpg">
							</div>
							<div class="carousel-item ">
								<img
									src="https://sieuthiyte.com.vn/data/upload/700x394-mayxongmuihong-slidestyt.jpg">
							</div>
							<div class="carousel-item ">
								<img
									src="https://sieuthiyte.com.vn/data/upload/may-tao-oxy-oz5-25032022-v1.jpg">
							</div>

						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselExampleIndicators" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--End Category-->


		<!--Top sản phẩm nổi bật-->
		<div class="flash-sale">
			<div class="flash-sale__header">
				<span style="font-size: 20px; font-weight: bold">Danh sách
					các thiết bị</span>
			</div>

			<!--sản phẩm-->
			<div class="flash-sale__san-pham">

				<c:forEach items="${thietBisNoiBat}" var="x">

					<!--mỗi sản phẩm-->
					<div class="flash-sale__san-pham__item">
						<div class="card card-san-pham" style="width: 100%">
							<a href='<c:url value="/san-pham/${x.slug}" />'><img
								src="${thietBiImageUrl}/${x.moTaThietBi}" class="card-img-top" /></a>
							<div class="card-body">
								<h6 class="card-title">${x.tenThietBi }</h6>
								<p class="card-text">
									<span
										style="font-weight: bold; color: #f7941e; font-size: 18px">
										${x.getGiaString() } </span> <br />
									<del style="font-weight: 500; color: #888888">
										${x.getGiaGocString() } </del>
								</p>
								<span class="card-san-pham__khuyen-mai">${x.khuyenMai}%</span>
							</div>
						</div>
					</div>
					<!--end mỗi sản phẩm-->

				</c:forEach>
			</div>

			<br style="clear: both" />
			<!--end sản phẩm-->
		</div>
		<!--End Top sản phẩm nổi bật-->

	</div>
	<!--End Main-->

	<script type="text/javascript"
		src="${styleUrlAdmin }plugins/jquery/jquery.min.js"></script>
</body>
</html>