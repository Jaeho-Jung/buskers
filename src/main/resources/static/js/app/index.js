let main = {
    init: function() {
        let _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-address-search').on('click', function() {
            _this.addressSearch();
        });
    },
    save: function() {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            address: $('#address').val(),
            startTime: $('#startTime').val(),
            endTime: $('#endTime').val(),
            content: $('#content').val()
        }

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();