<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form action="/lesson06/ex01/add_new_user" method="post" id="form">
			<b>이름 : </b><input type="text" class="form-control col-6" name="name" placeholder="이름을 입력하세요"><br>
			<b>생년월일 : </b><input type="text" class="form-control col-6" name="yyyymmdd" placeholder="예 ) 20210729"><br>
			<b>이메일 : </b><input type="email" class="form-control col-6" name="email" placeholder="이메일을 입력하세요"><br>
			<b>자기소개 : </b>
			<textarea rows="10" cols="20" name="introduce" class="form-control"></textarea><br>
			
			<input type="button" id="addBtn" class="btn btn-success" value="추가">
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			// (1) jQuery의 submit 기능 이용하기
			$('').on('submit', function (e/*받아도 되고 안받아도 됨*/) {
				e.preventDefault(); // 기본으로 submit 동작하는 것을 막는다
				
				//alert("추가 버튼 클릭");
				
				// validation check --> return 되더라도 submit이 되어버린다
				let name = $('input[name=name]').val().trim();
				if (name == '') {
					alert("이름을 입력해주세요");
					return;
				}
				
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if (yyyymmdd == '') {
					alert("생년월일을 입력해주세요");
					return;
				}
				
				// $('#form').submit();
				
				// 여기까지 도달하면 submit 된다
			});
			
			// (2) jQuery의 AJAX 통신을 이용하기
			$('#addBtn').on('click', function(e) {
				// AJAX를 사용하는 경우 form태그는 사용하지 않는다
				
				// alert("추가 버튼 클릭");
				
				// validation
				let name = $('input[name=name]').val().trim();
				if (name == '') {
					alert("이름을 입력해주세요");
					return;
				}
				
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if (yyyymmdd == '') {
					alert("생년월일을 입력해주세요");
					return;
				}
				
				if (isNaN(yyyymmdd)) {
					alert("숫자만 입력하세요");
					return ;
				}
				
				let email = $('input[name=email]').val().trim();
				
				let introduce = $('textarea[name=introduce]').val().trim();
				
				console.log("email : " + email);
				console.log("introduce : " + introduce);
				
				// AJAX : form 태그와 상관없이 비동기로 별도 요청 (request)
				$.ajax({
					type : 'POST'
					, url : '/lesson06/ex01/add_new_user'
					, data : {'name':name, 'yyyymmdd':yyyymmdd, 'email':email, 'introduce':introduce}
					, success : function(data) {
						alert(date);
						location.href = "/lesson06/ex01/get_new_user";
						// location.relode();
					}, complete : function(data) {
						alert("완료");
					}, error : function(e) {
						alert("error : " + e);
					}
				});
			});
		});
	</script>

</body>
</html>