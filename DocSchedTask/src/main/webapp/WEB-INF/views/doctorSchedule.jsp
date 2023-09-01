<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Doctor Schedule Page</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .wkdys {
            width: 40px;
        }

        th {
            width: 100px;
        }

        #save {
            margin-top: 10px;
        }

        #availabilityForm {
            margin-top: 20px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            margin-top: 20px;
            width: 100%;
        }

        th,
        td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        #selectedAvailability button {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 6px 12px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        #selectedAvailability button:hover {
            background-color: #c82333;
        }
        .bkey{
            margin-left: 40%;
        }
        .skey{
            margin-left: 45%;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Admin Page</h1><br>

        <label for="doctorSelect">Select Doctor:</label>
        <select id="doctorSelect" class="form-select mb-3">
            <option value="101" name="doc1">Doctor 1</option>
            <option value="102" name="doc2">Doctor 2</option>
        </select>

        <h3>Set Availability</h3>
        <div id="availabilityForm">

            <table class="table">
                <tr>
                    <td><input type="checkbox" name="days" id="sun" value="1" class="wkdys"></td>
                    <td>Sunday</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="days" id="mon" value="2" class="wkdys"></td>
                    <td>Monday</td>
                    <td><input type="checkbox" name="days" id="tue" value="3" class="wkdys"></td>
                    <td>Tuesday</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="days" id="wed" value="4" class="wkdys"></td>
                    <td>Wednesday</td>
                    <td><input type="checkbox" name="days" id="thu" value="5" class="wkdys"></td>
                    <td>Thursday</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="days" id="fri" value="6" class="wkdys"></td>
                    <td>Friday</td>
                    <td><input type="checkbox" name="days" id="sat" value="7" class="wkdys"></td>
                    <td>Saturday</td>
                </tr>
            </table>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <label for="fromTime" class="form-label">From:</label>
                    <input type="time" name="fromTime" id="fromTime" class="form-control" value="09:00">
                </div>
                <div class="col-md-6">
                    <label for="toTime" class="form-label">To:</label>
                    <input type="time" name="toTime" id="toTime" class="form-control" value="12:00">
                </div>
            </div>
            <br>
            <button onclick="addAvailability()" class="btn btn-primary bkey">Add Availability</button>
        </div><br>

        <h3>Selected Availability</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Doctor</th>
                    <th>Day</th>
                    <th>Time Slot</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody id="selectedAvailability"></tbody>
        </table>
        <br>
        <form action="#" method="post" onsubmit="prepareAndSubmitJSONData(event)">
            <input type="hidden" name="availabilityDataJSON" id="availabilityDataJSON">
            <button type="submit" id="save" class="btn btn-primary skey">Save</button>
        </form>
    </div>

    <script>
        const availabilityData = {};

        function isTimeSlotOverlapping(doctor, day, fromTime, toTime) {
            if (!availabilityData[doctor] || !availabilityData[doctor][day]) return false;

            for (const slot of availabilityData[doctor][day]) {
                const [existingFrom, existingTo] = slot.split('-').map(time => time.trim());
                if ((fromTime >= existingFrom && fromTime < existingTo) || (toTime > existingFrom && toTime <= existingTo)) {
                    return true;
                }
            }
            return false;
        }

        function deleteRow(row) {
            const doctorCell = row.cells[0].textContent;
            const dayCell = row.cells[1].textContent;
            const timeSlotCell = row.cells[2].textContent;

            if (availabilityData[doctorCell] && availabilityData[doctorCell][dayCell]) {
                availabilityData[doctorCell][dayCell] = availabilityData[doctorCell][dayCell].filter(
                    slot => slot !== timeSlotCell
                );
            }

            row.parentNode.removeChild(row);
        }


        function addAvailability() {
            const doctorSelect = document.getElementById('doctorSelect');
            const selectedDoctor = doctorSelect.value;

            const daysCheckboxes = document.querySelectorAll('input[name="days"]:checked');
            const fromTime = document.querySelector('input[name="fromTime"]').value;
            const toTime = document.querySelector('input[name="toTime"]').value;

            const selectedAvailabilityTable = document.getElementById('selectedAvailability');

            daysCheckboxes.forEach(dayCheckbox => {
                const day = dayCheckbox.value;

                if (!isTimeSlotOverlapping(selectedDoctor, day, fromTime, toTime)) {
                    const row = selectedAvailabilityTable.insertRow();
                    const doctorCell = row.insertCell(0);
                    const dayCell = row.insertCell(1);
                    const timeSlotCell = row.insertCell(2);
                    const actionCell = row.insertCell(3);

                    doctorCell.textContent = selectedDoctor;
                    dayCell.textContent = day;
                    var timeLapse = "" + fromTime + " - " + toTime;
                    timeSlotCell.textContent = timeLapse;

                    const deleteButton = document.createElement('button');
                    deleteButton.textContent = 'Delete';
                    deleteButton.onclick = function () {
                        deleteRow(row);
                    };

                    actionCell.appendChild(deleteButton);

                    if (!availabilityData[selectedDoctor]) {
                        availabilityData[selectedDoctor] = {};
                    }

                    if (!availabilityData[selectedDoctor][day]) {
                        availabilityData[selectedDoctor][day] = [];
                    }

                    availabilityData[selectedDoctor][day].push(timeLapse);
                } else {
                    window.alert("Time slot overlaps with existing availability.");
                }
            });
        }
        console.log(availabilityData);

        function prepareAndSubmitJSONData(event) {
            event.preventDefault(); // Prevent the form from submitting normally

            const availabilityDataJSON = JSON.stringify(availabilityData);
            document.getElementById('availabilityDataJSON').value = availabilityDataJSON;

            // Submit the form
            event.target.submit();
        }
    </script>
</body>

</html>