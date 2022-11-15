export function addressSearch () {
    new daum.Postcode({
        oncomplete: function(data) {
            var address = data.address; // 최종 주소 변수
            // console.log(address);
            document.getElementById("address").value = address;
        }
    }).open();
}