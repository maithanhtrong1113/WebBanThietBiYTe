<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/static/admin/" var="styleUrl" />


<c:forEach items="${thietBis}" var="x" varStatus="loop">

	<tr>

		<td>${loop.index + 1}</td>
		<td>${x.tenThietBi }</td>
		<td>${x.tenNhomThietBi }</td>
		<td>${x.tenThuongHieu }</td>
		<td>${x.gia }</td>
		<td>${x.khuyenMai }</td>
		<td>${x.thoiGianBaoHanh }</td>
		<td><c:if test="${x.noiBat}">

				<span class="badge badge-success">Nổi bật</span>
			</c:if> <c:if test="${x.noiBat == false}">

				<span class="badge badge-danger">Mặc định</span>
			</c:if></td>


		<td> <a class="btn btn-info btn-sm sua"
			href='<c:url value="/admin/thietbi/sua-thietbi/${x.id }" />'> <i
				class="fas fa-pencil-alt"></i> Sửa
		</a> <a onClick="xoa(${x.id})" class="btn btn-danger btn-sm xoa"> <i
				class="fas fa-trash"> </i> Xóa
		</a></td>

	</tr>

</c:forEach>

