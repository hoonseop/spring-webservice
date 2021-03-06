/**
 * 
 */
var point = {
	init : function () {
		var _this = this;
		$('#btn-search').on('click', function () {
			_this.search();
		});
	},
	search : function () {
		var data = {
			playDate: $('#txt-search').val()
		};

		$.ajax({
			type: 'POST',
			url: '/findPointByPlayDate',
			dataType: 'json',
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function() {
			location.reload();
		}).fail(function (error) {
			location.reload();
		});
	}
};

point.init();