function calCheck() {
	var x = document.calInputForm.x;
	var y = document.calInputForm.y;

	if (isEmpty(x) || isNaN(x.value)) {
		alert("x값 확인");
		x.focus();
		x.value = "";
		return false;
	} else if (isEmpty(y) || isNaN(y.value)) {
		alert("y값 확인");
		y.focus();
		y.value = "";
		return false;
	}

	return true;
}

function transCheck() {
	var xx = document.transInputForm.xx;

	if (isEmpty(xx) || isNaN(xx.value)) {
		alert("값 확인");
		xx.focus();
		xx.value = "";
		return false;
	}

	return true;
}

function registCheck() {
	var id = document.registeInputForm.id;
	var pw = document.registeInputForm.pw;
	var name = document.registeInputForm.name;
	var email = document.registeInputForm.email;
	var phone = document.registeInputForm.tel;
	var address = document.registeInputForm.addr;

	console.log(id);
	if (isEmpty(id)){
		alert("아이디 확인");
		id.focus();
		return false;
	} else if (isEmpty(pw)) {
		alert("비밀번호 확인");
		pw.focus();
		return false;
	} else if (isEmpty(name)) {
		alert("이름 확인");
		name.focus();
		return false;
	} else if (isEmpty(email)) {
		alert("메일 확인");
		name.focus();
		return false;
	} else if (isEmpty(tel)) {
		alert("전화번호 확인");
		name.focus();
		return false;
	} else if (isEmpty(addr)) {
		alert("주소 확인");
		name.focus();
		return false;
	}

	return true;
}