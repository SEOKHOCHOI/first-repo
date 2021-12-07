window.onload = function() {
	var guest_form = document.getElementById("guest_form");
	guest_form.addEventListener("submit", guestSubmit);
}

function guestSubmit() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	
	this.date.value = year + "-" + month + "-" + date;
}