/*readyDoc();
var data;
function readyDoc() {
	var xhr = new XMLHttpRequest();
	var url = "/ZExam/getLoanExam?action=ready";

	xhr.onload = function() {
		if (xhr.status === 200) {
			console.log(JSON.parse(xhr.responseText));
			localStorage.setItem("loanlsdata", xhr.responseText);
			data = JSON.parse(localStorage.getItem("loanlsdata"));
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

var index = -1;
var first = document.getElementById("first");
first.addEventListener("click", function() {
	index = 0;
	display(index);
});

var next = document.getElementById("next");
next.addEventListener("click", function() {
	index = index + 1;
	if (index < data.length) {
		display(index);
	} else {
		index -= 1;
		window.alert("Reached Last Record");
	}
});

var prev = document.getElementById("prev");
prev.addEventListener("click", function() {
	index = index - 1;
	if (index >= 0) {
		display(index);
	} else {
		index += 1;
		window.alert("Reached First Record");
	}
});

var last = document.getElementById("last");
last.addEventListener("click", function() {
	index = data.length - 1;
	display(index);
});

var add = document.getElementById("add");
add.addEventListener("click", function() {
	clearall();
	document.getElementById("loanid").focus();
});

var edit = document.getElementById("edit");
edit.addEventListener("click", function() {
	document.getElementById("bookid").focus();
});

var delete1 = document.getElementById("delete");
delete1.addEventListener("click", function() {
	var loanid = document.getElementById("loanid").value;

	var xhr = new XMLHttpRequest();
	var url = "/ZExam/getLoanExam?action=delete&loanid=" + loanid;

	xhr.onload = function() {
		if (xhr.status === 200) {
			window.alert(xhr.response);
			if (index == 0) {
				index = 1;
				display(index);
			} else {
				display(index - 1);
			}
			readyDoc();
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
});

var save = document.getElementById("save");
save.addEventListener("click", function() {
	var flag = 0;

	var a = document.getElementById("loanid").value;
	var b = document.getElementById("bookid").value;
	var c = document.getElementById("borrowerid").value;
	var d = document.getElementById("checkoutdate").value;
	var e = document.getElementById("duedate").value;
	var f = document.getElementById("returndate").value;
	var g = document.getElementById("fine").value;

	check for loanid is exist or not?
	data.forEach(element => {
		if (element.loanid == a) {
			flag += 1;
		}
	});

	var xhr = new XMLHttpRequest();
	var url;

	if (flag == 1) {
		url = "/ZExam/getLoanExam?action=updateRecord&loanid=" + a + "&bookid=" + b + "&borrowerid=" + c + "&checkoutdate=" + d + "&duedate=" + e + "&returndate=" + f + "&fine=" + g;
	} else {
		url = "/ZExam/getLoanExam?action=insertRecord&loanid=" + a + "&bookid=" + b + "&borrowerid=" + c + "&checkoutdate=" + d + "&duedate=" + e + "&returndate=" + f + "&fine=" + g;
	}

	xhr.onload = function() {
		if (xhr.status === 200) {
			window.alert(xhr.response);
			readyDoc();
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
});

var search = document.getElementById("search");
search.addEventListener("click", function() {
	var loanid1 = document.getElementById("loanid").value;

	var flag = 0;
	data.forEach(element => {
		if (element.loanid == loanid1) {
			flag += 1;
			document.getElementById("loanid").value = element.loanId;
			document.getElementById("bookid").value = element.bookId;
			document.getElementById("borrowerid").value = element.borrowerId;
			document.getElementById("checkoutdate").value = element.checkoutDate;
			document.getElementById("duedate").value = element.dueDate;
			document.getElementById("returndate").value = element.returnDate;
			document.getElementById("fine").value = element.fine;
		}
	});
	if (flag == 0) {
		clearall();
		window.alert("No record found on this id: " + loanid1);
	}
});

var clear = document.getElementById("clear");
clear.addEventListener("click", function() {
	clearall();
});

var exit = document.getElementById("exit");
exit.addEventListener("click", function() {
	window.alert("Oops..!!");
});

DisplayData
function display(index) {
	document.getElementById("loanid").value = data[index].loanId;
	document.getElementById("bookid").value = data[index].bookId;
	document.getElementById("borrowerid").value = data[index].borrowerId;
	document.getElementById("checkoutdate").value = data[index].checkoutDate;
	document.getElementById("duedate").value = data[index].dueDate;
	document.getElementById("returndate").value = data[index].returnDate;
	document.getElementById("fine").value = data[index].fine;
}


Clear
function clearall() {
	document.getElementById("loanid").value = "";
	document.getElementById("bookid").value = "";
	document.getElementById("borrowerid").value = "";
	document.getElementById("checkoutdate").value = "";
	document.getElementById("duedate").value = "";
	document.getElementById("returndate").value = "";
	document.getElementById("fine").value = "";
}

Button activation code

first.disabled = true;
next.disabled = true;
prev.disabled = true;
last.disabled = true;
add.disabled = true;
edit.disabled = true;
delete1.disabled = true;
save.disabled = true;
search.disabled = true;
clear.disabled = true;
exit.disabled = true;

var mode = document.getElementById("mode");
mode.addEventListener("change", function() {
	var value = mode.value;
	if (value === "read") {
		first.disabled = false;
		next.disabled = false;
		prev.disabled = false;
		last.disabled = false;
		add.disabled = true;
		edit.disabled = true;
		delete1.disabled = false;
		save.disabled = true;
		search.disabled = false;
		clear.disabled = false;
		exit.disabled = false;
	}
	if (value === "edit") {
		first.disabled = true;
		next.disabled = true;
		prev.disabled = true;
		last.disabled = true;
		add.disabled = true;
		edit.disabled = false;
		delete1.disabled = true;
		save.disabled = false;
		search.disabled = true;
		clear.disabled = false;
		exit.disabled = false;
	}
	if (value === "new") {
		first.disabled = true;
		next.disabled = true;
		prev.disabled = true;
		last.disabled = true;
		add.disabled = false;
		edit.disabled = true;
		delete1.disabled = true;
		save.disabled = false;
		search.disabled = true;
		clear.disabled = false;
		exit.disabled = false;
	}
});*/