function validate() {

	let tenThietBi = document.myForm.tenThietBi.value.trim();
	let gia = document.myForm.gia.value.trim();
	let khuyenMai = document.myForm.khuyenMai.value.trim();
	let thoiGianBaoHanh = document.myForm.thoiGianBaoHanh.value.trim();

	$("#tenThietBiErr").text("");
	$("#giaErr").text("");
	$("#khuyenMaiErr").text("");
	$("#thoiGianBaoHanhErr").text("");

	let flag = true;


	if (tenThietBi.length === 0) {
		$("#tenThietBiErr").text("Tên thiết bị không được bỏ trống");
		flag = false;
	}

	if (isNaN(gia)) {
		$("#giaErr").text("Giá sai định dạng");
		flag = false;
	}
	if (gia <= 0) {
		$("#giaErr").text("Giá không được nhỏ hơn hoặc 0");
		flag = false;
	}
	if (isNaN(khuyenMai)) {
		$("#khuyenMaiErr").text("Khuyến mãi sai định dạng");
		flag = false;

	}

	if (khuyenMai < 0) {
		$("#khuyenMaiErr").text("Khuyến mãi phải > 0");
		flag = false;
	}

	if (khuyenMai >= 100) {
		$("#khuyenMaiErr").text("Khuyến mãi phải < 100");
		flag = false;
	}

	if (thoiGianBaoHanh.length === 0) {
		$("#thoiGianBaoHanhErr").text("Thời gian bảo hành không được bỏ trống");
		flag = false;
	}

	return flag;
}