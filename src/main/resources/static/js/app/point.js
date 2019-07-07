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
        var params = {
            teamName: $('#teamName').val(),
            playerName: $('#playerName').val(),
        	playDate: $('#playDate').val()
        };
        console.log($('#playDate').val())

        $.ajax({
            type: 'GET',
            url: '/point',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(encodeURI(params))
        }).done(function() {
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

point.init();