var players = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
        	teamName: $('#teamName').val(),
        	playerName: $('#playerName').val(),
        	position: $('#position').val(),
            number: $('#number').val(),
            salary: $('#salary').val(),
            isEnroll: $('#isEnroll').val()
        };

        $.ajax({
            type: 'POST',
            url: '/players',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('선수가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

players.init();