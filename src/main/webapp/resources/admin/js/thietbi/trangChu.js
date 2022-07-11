

let tenThietBi = "";
let nhomThietBis ="";
let thuongHieus = "";

$("#tenThietBi").on("keyup", function() {

	tenThietBi = this.value;

	timKiem();

});


$('#nhomThietBis').on('change', function() {

	nhomThietBis = this.value;

	timKiem();

});

$('#thuongHieus').on('change', function() {

	thuongHieus = this.value;

	timKiem();

});


function timKiem() {

	const query = jQuery.param({ tenThietBi, nhomThietBis, thuongHieus });

	const url = `api?${query}`;

	$.get(url, function(data, status) {

		$("#tableBody").html(data);
	});

}


// hàm xóa sản phẩm
function xoa(id) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/xoa/${id}`,
			type: 'DELETE',
			success: function() {

				timKiem();
				toastr.success('Xóa thành công');

			},
			error: function() {
				toastr.error('Xóa thất bại');
			},

		});

	}
}



