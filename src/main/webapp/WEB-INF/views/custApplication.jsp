<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>

    <style>
        /* Reset some default browser styles */
        body {
            margin: 0;
            padding-top: 10px;
            font-size: 18px;
            background-color: GREY;
        }

        .form-container {
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            border-radius: 5px;
            font-size: 20px;
        }

        h2 {
            text-align: center;
        }

        /* Style the tabs */
        .tabs {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

        input {
            padding: 10px;
            font-size: 10px;
        }

        .tab {
            background-color: blue;
            font-size: 20px;
            color: #fff;
            border: none;
            width: 300px;
            padding: 10px 20px;
            cursor: pointer;
            border-color: black transition;
            background-color: 0.3s;
        }

        .tab.active-tab {
            background-color: #007bff;
        }

        /* Style the form box */
        .form-box {
            width: 95%;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-part h2 {
            margin-bottom: 20px;
            color: #333;
        }

        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        select {
            width: 93%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        input[type="date"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        input[type="tel"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        input[type="number"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        button.form-button {
            background-color: green;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        button.form-button:hover {
            background-color: #0056b3;
        }

        form:invalid {
            border-color: #ff0000;
        }

        #submission-message {
            color: #009900;
            font-weight: bold;
            margin-top: 10px;
        }

        .hpreview {
            padding-top: 10px;
        }

        .tdinptpreview {
            width: 65%;
            margin-buttom: 0%;
        }

        .inptd {
            height: 100%;
            margin-top: 9px;
        }
    </style>

    <script>
        let currentTab = 0;

        function showTab(tabIndex) {
            const formParts = document.querySelectorAll('.form-part');
            formParts[currentTab].style.display = 'none';
            formParts[tabIndex].style.display = 'block';

            // Remove the 'active-tab' class from all tab buttons
            const tabButtons = document.querySelectorAll('.tab');
            tabButtons.forEach(button => button.classList.remove('active-tab'));

            // Add the 'active-tab' class to the current tab button
            tabButtons[tabIndex].classList.add('active-tab');

            currentTab = tabIndex;
        }

        function nextTab(tabIndex) {
            const form = document.getElementById(`form-part-${tabIndex + 1}`);
            if (form.checkValidity()) {
                showTab(tabIndex + 1);
            } else {
                alert('Please fill in all required fields.');
            }
        }

        function prevTab(tabIndex) {
            showTab(tabIndex - 1);
        }
    </script>
</head>

<body>
    <center>
        <h2 style="color: white; font-size: 40px;">Loan Application</h2>
    </center>
    <div class="form-container">
        <div class="tabs">
            <button class="tab" onclick="showTab(0)">Step - 1 >> </button>
            <button class="tab" onclick="showTab(1)">Step - 2 >></button>
            <button class="tab" onclick="showTab(2)">Step - 3 >></button>
            <button class="tab">Preview</button>
        </div>
        <div class="form-box">
            <div class="form-part">
                <h2>Personal Details</h2>
                <b>FirstName : </b>
                <input type="text" id="firstName" placeholder="Enter FirstName"><br>
                <b>LastName : </b>
                <input type="text" id="lastName" placeholder="Enter Last name"><br>
                <b>Date of Birth : </b><br>
                <input type="date" id="dateOfBirth" placeholder="Enter date of birth"><br>
                <b>PAN card No : </b>
                <input type="text" id="panNumber" placeholder="Enter PAN number"><br>
                <b>Address : </b>
                <input type="text" id="address" placeholder="Enter address"><br>
                <b>Annual Income: </b>
                <input type="text" id="AnnIcm" placeholder="Enter Your Annual income"><br>

                <button class="form-button" type="button" onclick="nextTab(0)">Next</button>
            </div>
            <div class="form-part" style="display: none;">
                <h2>Loan Details</h2>
                <b>Loan Amount : </b><br>
                <input type="text" id="amount" placeholder="Enter Amount"><br>
                <b>Loan Type: </b>
                <select name="" id="loanType">
                    <option value="0">--Select Loan Type--</option>
                    <option value="1">Personal Loan</option>
                    <option value="2">Mortgage Loan</option>
                    <option value="3">Auto Loan</option>
                    <option value="5">Education Loan</option>
                    <option value="4">Business Loan</option>
                </select><br>
                <b>Disposable Income: </b>
                <input type="text" id="DisIcm" placeholder="Enter Your Disposable Income" readonly><br>
                <b>Number of months : </b>
                <input type="text" id="noOfMonths" placeholder="Enter Number of months"><br>
                <b>EMI Amount: </b>
                <input type="text" id="emiAmt" placeholder="Your EMI" readonly><br>
                <b>Eligibility: </b>
                <input type="text" id="eligibility" placeholder="Your Eligibility" readonly><br>

                <button class="form-button" type="button" onclick="prevTab(1)">Back</button>
                <button class="form-button" type="button" onclick="nextTab(1)">Next</button>
                <button class="form-button" type="button" onclick="checkEle()">Check Eligibility</button>
            </div>
            <div class="form-part" style="display: none;">
                <b>Guardian Name : </b>
                <input type="text" id="gName" placeholder="Enter guardian name"><br>
                <b>Your Mobile Number : </b><br>
                <input type="tel" id="mobileNumber" placeholder="Enter mobile number"><br>

                <h2>Nominee Details</h2>
                <b>Enter Nominee name </b>
                <input type="text" id="nomFullname" placeholder="Enter FullName"><br>
                <b>Relation </b>
                <input type="text" id="nomRelation" placeholder="Enter Relation with Nominee"><br>

                <button class="form-button" type="button" onclick="prevTab(2)">Back</button>
                <button class="form-button" type="button" onclick="getPreview()">Preview</button>
            </div>
            <form action="submitApplication" id="form-part-1" method="get">
                <div class="form-part" style="display: none;">
                    <h2>Preview Your details before Submitting..!!</h2>

                    <table border="0">
                        <tr>
                            <td class="hpreview"><b>Personal Details:</b></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>First Name: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="fname" name="firstName"
                                    value="">
                            </td>
                        </tr>
                        <tr>
                            <td>Last Name: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="lname" name="lastName"
                                    value="">
                            </td>
                        </tr>
                        <tr>
                            <td>Date of Birth: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="dob" name="dateOfBirth"
                                    value="">
                            </td>
                        </tr>
                        <tr>
                            <td>PAN Number: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="panNum" name="pANNumber"
                                    value="">
                            </td>
                        </tr>
                        <tr>
                            <td>Address: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="addrs" name="address"
                                    value="">
                            </td>
                        </tr>
                        <tr>
                            <td class="hpreview"><b>Loan Details:</b></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Amount Required: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="amt" name="lnAmount" value=""
                                    >
                            </td>
                        </tr>
                        <tr>
                            <td>Loan Type: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="lnType" name="lnType"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Annual Income: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="aIncome" name="aIncome"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Disposable Income: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="dIncome" name="dIncome"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Months Requested: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="nOMonths"
                                    name="monthsRequired" value="" >
                            </td>
                        </tr>
                        <tr>
                            <td class="hpreview"><b>Guardian and Nominee Details:</b></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Guardian Name: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="gurdnName" name="gurdName"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Your Mobile Number: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="phNumber" name="phNumber"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Nominee Name: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="nomFName" name="nName"
                                    value="" >
                            </td>
                        </tr>
                        <tr>
                            <td>Relation with Nominee: </td>
                            <td class="tdinptpreview"><input class="inptd" type="text" id="nomRel" name="nRelation"
                                    value="" >
                            </td>
                        </tr>
                    </table><br>
                    <input type="hidden" id="userrId" name="userId" value="${userId}">
                    <button class="form-button" type="button" onclick="prevTab(1)">Edit</button>
                    <button class="form-button" type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div><br><br>
    <script>
	    const aInc = document.getElementById("AnnIcm");
	    const dInc = document.getElementById("DisIcm");
	    
	    aInc.addEventListener('input', function(){
	    	var val = aInc.value;
	    	dInc.value = (val*30/100)/12;
	    });
	    
	    var emiAmt = document.getElementById("emiAmt");
    	
    	document.getElementById("noOfMonths").addEventListener('input', function(){
	    	var nom = document.getElementById("noOfMonths").value;
	    	var amount = document.getElementById("amount").value;
	    	emiAmt.value = calculateEMI(amount, 10, nom).toFixed(2);
	    });
    	
    	function checkEle(){
    		var a = document.getElementById("DisIcm").value; 
    		var b = document.getElementById("emiAmt").value;
    		console.log(a+"--"+b);
    		if(a >= b){
    			document.getElementById("eligibility").value = "Eligble For Loan";
    		}
    		if(a < b){
    			document.getElementById("eligibility").value = "Not Eligble For Loan";
    		}
    	}
	    
	    function calculateEMI(principal, annualInterestRate, tenureInMonths) {
	        // Convert annual interest rate to monthly interest rate
	        const monthlyInterestRate = (annualInterestRate / 12) / 100;

	        // Calculate EMI using the formula
	        const emi = (principal * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), tenureInMonths)) /
	            (Math.pow((1 + monthlyInterestRate), tenureInMonths) - 1);

	        return emi;
	    }
    
        function getPreview() {
            nextTab(2);
            document.getElementById("fname").value = document.getElementById("firstName").value;
            document.getElementById("lname").value = document.getElementById("lastName").value;
            document.getElementById("dob").value = document.getElementById("dateOfBirth").value;
            document.getElementById("panNum").value = document.getElementById("panNumber").value;
            document.getElementById("addrs").value = document.getElementById("address").value;
            document.getElementById("amt").value = document.getElementById("amount").value;
            document.getElementById("lnType").value = document.getElementById("loanType").value;
            document.getElementById("aIncome").value = document.getElementById("AnnIcm").value;
            document.getElementById("dIncome").value = document.getElementById("DisIcm").value;
            document.getElementById("nOMonths").value = document.getElementById("noOfMonths").value;
            document.getElementById("gurdnName").value = document.getElementById("gName").value;
            document.getElementById("phNumber").value = document.getElementById("mobileNumber").value;
            document.getElementById("nomFName").value = document.getElementById("nomFullname").value;
            document.getElementById("nomRel").value = document.getElementById("nomRelation").value;
        }
    </script>
</body>

</html>

</html>