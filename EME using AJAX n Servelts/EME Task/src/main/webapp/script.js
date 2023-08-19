readyDoc();
var data;
function readyDoc() {
	var xhr = new XMLHttpRequest();
	var url = "/EME_Task/getResult?action=ready";

	xhr.onload = function() {
		if (xhr.status === 200) {
			console.log(JSON.parse(xhr.responseText));
			localStorage.setItem("lsdata", xhr.responseText);
			data = JSON.parse(localStorage.getItem("lsdata"));
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
	document.getElementById("empid").focus();
});

var edit = document.getElementById("edit");
edit.addEventListener("click", function() {
	document.getElementById("name").focus();
});

var delete1 = document.getElementById("delete");
delete1.addEventListener("click", function() {
	var empid = document.getElementById("empid").value;
	
	var xhr = new XMLHttpRequest();
	var url = "/EME_Task/getResult?action=delete&empid=" + empid;

	xhr.onload = function() {
		if (xhr.status === 200) {
			window.alert(xhr.response);
			if(index == 0){
				index = 1;
				display(index);
			}else{
				display(index-1);
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

	var a = document.getElementById("empid").value;
	var b = document.getElementById("name").value;
	var c = document.getElementById("designation").value;
	var d = document.getElementById("salary").value;
	var e = document.getElementById("department").value;
	
	/*check for emdid is exist or not?*/
	data.forEach(element => {
		if(element.empid == a){
			flag += 1;
		}
	});

	var xhr = new XMLHttpRequest();
	var url;
	
	if(flag == 1){
		url = "/EME_Task/getResult?action=updateRecord&empid=" + a + "&name=" + b + "&job=" + c + "&sal=" + d + "&dept=" + e;
	}else{
		url = "/EME_Task/getResult?action=insertRecord&empid=" + a + "&name=" + b + "&job=" + c + "&sal=" + d + "&dept=" + e;
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
	var empid1 = document.getElementById("empid").value;
	
	var flag = 0;
	data.forEach(element => {
		if (element.empid == empid1) {
			flag += 1;
			document.getElementById("empid").value = element.empid;
			document.getElementById("name").value = element.ename;
			document.getElementById("designation").value = element.job;
			document.getElementById("salary").value = element.salary;
			document.getElementById("department").value = element.dept;
		}
	});
	if(flag == 0){
		clearall();
		window.alert("No record found on this id: " + empid1);
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

/*DisplayData*/
function display(index){
	document.getElementById("empid").value = data[index].empid;
	document.getElementById("name").value = data[index].ename;
	document.getElementById("designation").value = data[index].job;
	document.getElementById("salary").value = data[index].salary;
	document.getElementById("department").value = data[index].dept;
}


/*Clear*/
function clearall() {
	document.getElementById("empid").value = "";
	document.getElementById("name").value = "";
	document.getElementById("designation").value = "";
	document.getElementById("salary").value = "";
	document.getElementById("department").value = "";
}

/*Button activation code*/

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
});