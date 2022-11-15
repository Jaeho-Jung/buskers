import {addressSearch} from "./address_search.js";

var posts_save = {
    init: function() {
        let _this = this;
        $('#btn-address-search').on('click', function() {
            addressSearch();
        });
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save: function() {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            address: $('#address').val(),
            startDateTime: $('#startDateTime').val(),
            endDateTime: $('#endDateTime').val(),
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

$(posts_save.init());
