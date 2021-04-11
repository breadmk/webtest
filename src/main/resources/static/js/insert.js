function main() {
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		if($("input[name=phone]").val().match(regExpPhone)==null){
			$("#errPhone").text("휴대폰번호 형식에 맞게 입력해주세요");
			return false;
		}else if($("input[name=email]").val().match(regExp)==null){
			$("#errEmail").text("이메일형식에 맞춰 입력해주세요");
			return false;
		}
		
	}


