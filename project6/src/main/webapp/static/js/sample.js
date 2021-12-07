function initData() {
	var e = document.getElementById("id_username");
	e.value = "aaaa";
}

function initUrl(id) {
	var e = document.getElementById(id);
	var i = document.getElementById("id_url");
	i.value = e.href;
}