<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:url value="/static/admin/" var="styleUrl" />


<div
	class="preloader flex-column justify-content-center align-items-center">
	<img class="animation__shake"
		src="${styleUrl}dist/img/AdminLTELogo.png" alt="AdminLTELogo"
		height="60" width="60">
</div>

<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
		<li class="nav-item d-none d-sm-inline-block"><a
			href="/WebBanThietBiYTe/" class="nav-link">Home</a></li>
		<li class="nav-item d-none d-sm-inline-block"><a href="#"
			class="nav-link">Contact</a></li>
	</ul>

	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<!-- Navbar Search -->
		<li class="nav-item"><a class="nav-link"
			data-widget="navbar-search" href="#" role="button"> <i
				class="fas fa-search"></i>
		</a>
			<div class="navbar-search-block">
				<form class="form-inline">
					<div class="input-group input-group-sm">
						<input class="form-control form-control-navbar" type="search"
							placeholder="Search" aria-label="Search">
						<div class="input-group-append">
							<button class="btn btn-navbar" type="submit">
								<i class="fas fa-search"></i>
							</button>
							<button class="btn btn-navbar" type="button"
								data-widget="navbar-search">
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div>
				</form>
			</div></li>


		<!-- Notifications Dropdown Menu -->
		<li class="nav-item dropdown"><a class="nav-link"
			data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span
				class="badge badge-warning navbar-badge">15</span>
		</a>
			<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
				<span class="dropdown-item dropdown-header">15 Notifications</span>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i
					class="fas fa-envelope mr-2"></i> 4 new messages <span
					class="float-right text-muted text-sm">3 mins</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i class="fas fa-users mr-2"></i>
					8 friend requests <span class="float-right text-muted text-sm">12
						hours</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i>
					3 new reports <span class="float-right text-muted text-sm">2
						days</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item dropdown-footer">See All
					Notifications</a>
			</div></li>
		<li class="nav-item"><a class="nav-link" data-widget="fullscreen"
			href="#" role="button"> <i class="fas fa-expand-arrows-alt"></i>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			data-widget="control-sidebar" data-slide="true" href="#"
			role="button"> <i class="fas fa-th-large"></i>
		</a></li>
	</ul>
</nav>
<!-- /.navbar -->


<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="/WebBanThietBiYTe/" class="brand-link"> <span
		class="brand-text font-weight-light">Trang chủ</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="<c:url value="/static/image/manager.png" />"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block"> <sec:authorize
						access="isAuthenticated()">
    Xin chào: <sec:authentication property="name" />
					</sec:authorize>
				</a>
			</div>
		</div>

		<!-- SidebarSearch Form -->
		<div class="form-inline">
			<div class="input-group" data-widget="sidebar-search">
				<input class="form-control form-control-sidebar" type="search"
					placeholder="Search" aria-label="Search">
				<div class="input-group-append">
					<button class="btn btn-sidebar">
						<i class="fas fa-search fa-fw"></i>
					</button>
				</div>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->




				<li class="nav-item menu-open"><a
					href='<c:url value="/admin/nguoi-dung/trang-chu"  />'
					class="nav-link active"> <i class="nav-icon fas fa-users"></i>
						<p>Quản lý người dùng</p>
				</a></li>

				<li class="nav-item"><a href="<c:url value="/admin/vali/"  />"
					class="nav-link"> <i class="nav-icon fab fa-product-hunt"></i>
						<p>
							Quản lý thiết bị y tế <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">


						<li class="nav-item"><a
							href="<c:url value="/admin/thietbi/"  />" class="nav-link"> <i
								class="far fa-circle nav-icon"></i>
								<p>Danh sách thiết bị</p>
						</a></li>


						<li class="nav-item"><a
							href="<c:url value="/admin/thietbi/them-thietbi"  />" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Thêm thiết bị</p>
						</a></li>




					</ul></li>

				<li class="nav-item"><a
					href="<c:url value="/admin/nhom-thietbi/trang-chu"  />"
					class="nav-link"> <i class="nav-icon fas fa-list"></i>
						<p>Quản lý nhóm thiết bị</p>
				</a></li>

				<li class="nav-item"><a
					href="<c:url value="/admin/thuong-hieu/trang-chu"  />"
					class="nav-link"> <i class="nav-icon fas fa-th"></i>

						<p>Quản lý thương hiệu</p>
				</a></li>






				<li class="nav-item"><a
					href="<c:url value="/admin/hoa-don/"  />" class="nav-link"> <i
						class="nav-icon fas fa-inbox"></i>
						<p>Quản lý hóa đơn</p>
				</a></li>






			</ul>
			</li>


			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>


