getTrains();
getStations();

function getTrains() {
	var xhr = new XMLHttpRequest();
	var url = "/TR_Task/getTrains";

	xhr.onload = function() {
		if (xhr.status === 200) {
			console.log(JSON.parse(xhr.responseText));
			var data = JSON.parse(xhr.responseText);

			var select = document.getElementById("trainslist");
			data.forEach(element => {
				var option = document.createElement("option");
				option.setAttribute("value", element.trainName);
				option.innerText = element.trainName;
				select.appendChild(option);
			});
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function getStations() {
	var xhr = new XMLHttpRequest();
	var url = "/TR_Task/getStations";

	xhr.onload = function() {
		if (xhr.status === 200) {
			console.log(JSON.parse(xhr.responseText));
			var data = JSON.parse(xhr.responseText);

			var select = document.getElementById("from");
			data.forEach(element => {
				var val = element.stn_code + " - " + element.stn_name;
				var option = document.createElement("option");
				option.setAttribute("value", val);
				option.innerText = val;
				select.appendChild(option);
			});
			var select1 = document.getElementById("to");
			data.forEach(element => {
				var val = element.stn_code + " - " + element.stn_name;
				var option = document.createElement("option");
				option.setAttribute("value", val);
				option.innerText = val;
				select1.appendChild(option);
			});
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

/*document.getElementById("submitf").addEventListener("click", function(){
	var xhr = new XMLHttpRequest();
	var url = "TR_Task/getResult/";
	
	xhr.onload = function(){
		if(xhr.status === 200){
			console.log(xhr.responseText);
		}
	}
	
	xhr.open("GET", url, true);
	xhr.send();
});

document.getElementById("resetf").addEventListener("click", function(){
	location.reload();
});*/


/*---------------------------Dynamic Rows Code-----------------------------*/

var PID = ["P1", "P2", "P3", "P4", "P5", "P6"];
var val;
var table = document.getElementById("ptable");
document.getElementById("addpassenger").addEventListener("click", function() {

	var size = table.rows.length;
	val = PID[0];

	if (size < 7) {
		// Create a <tr> element
		var tr = document.createElement('tr');

		// Create <td> elements and append them to the <tr> element
		var td1 = document.createElement('td');
		var label = document.createElement('label');
		label.textContent = val;
		td1.appendChild(label);
		tr.appendChild(td1);

		var td2 = document.createElement('td');
		var inputName = document.createElement('input');
		inputName.setAttribute('type', 'text');
		inputName.className = 'pstyle';
		inputName.id = val + "name";
		inputName.name = val + "name";
		td2.appendChild(inputName);
		tr.appendChild(td2);

		var td3 = document.createElement('td');
		var selectGender = document.createElement('select');
		selectGender.name = val + 'gender';
		selectGender.id = val + 'gender';

		var optionSelect = document.createElement('option');
		optionSelect.value = 'select';
		optionSelect.textContent = '-- Select --';
		selectGender.appendChild(optionSelect);

		var optionMale = document.createElement('option');
		optionMale.value = 'male';
		optionMale.textContent = 'Male';
		selectGender.appendChild(optionMale);

		var optionFemale = document.createElement('option');
		optionFemale.value = 'female';
		optionFemale.textContent = 'Female';
		selectGender.appendChild(optionFemale);

		var optionTransgender = document.createElement('option');
		optionTransgender.value = 'Transgender';
		optionTransgender.textContent = 'Transgender';
		selectGender.appendChild(optionTransgender);

		td3.appendChild(selectGender);
		tr.appendChild(td3);

		var td4 = document.createElement('td');
		var inputText = document.createElement('input');
		inputText.setAttribute('type', 'text');
		inputText.className = 'pstyle';
		inputText.id = val + "age";
		inputText.name = val + "age";
		td4.appendChild(inputText);
		tr.appendChild(td4);

		var td5 = document.createElement('td');
		var button = document.createElement('button');
		button.setAttribute("id", val);
		button.textContent = '❌';
		button.onclick = function() {
			del(this); // Assuming there's a function named del() for deletion
		};
		td5.appendChild(button);
		tr.appendChild(td5);

		// Append the <tr> element to a table or another container
		table.appendChild(tr);

		PID.shift();
	}
	else {
		window.alert("Limit of adding passengers reached..!!");
	}
});

function del(button) {
	var v = button.id;
	PID.push("" + v + "");

	var row = button.parentNode.parentNode;
	table.removeChild(row);
}