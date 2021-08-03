<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<b class="mt-5">이름 : </b>
		<div class="d-flex">
			<input id="name" type="text" class="form-control col-6" placeholder="이름을 입력하세요">
			<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>
		</div>
		<div id="statusArea"></div>
			
		<button type="submit" class="btn btn-success mt-4">가입하기</button>
	</div>

	<script>
		$(document).ready(function() {
			// 중복확인 버튼 클릭
			$('#nameCheckBtn').on('click', function() {
				// div 태그 안에 있는 모든 태그를 비운다 (초기화)
				$('#statusArea').empty();
				
				let name = $('#name').val().trim();
				
				if (name == '') {
					$('#statusArea').append('<small class="text-danger">이름이 비어있습니다</small>');
					return ;
				}
				
				// 이름이 중복되는지 확인 (DB에서 조회) -> AJAX 통신
				
				$.ajax({
					type : 'get'
					, data : {'name' : name}
					, url : '/lesson06/ex02/is_duplication'
					, success : function(data) {
						
					}
					, error : function(e) {
						alert("error : " + e);
					}
				});
				
			});
		});
	</script>

</body>
</html>