function validateForm() {
    var firstName = document.getElementById("firstName").value.trim();
    var lastName = document.getElementById("lastName").value.trim();
    var email = document.getElementById("email").value.trim();
    var mobile = document.getElementById("mobile").value.trim();
    var address = document.getElementById("address").value.trim();
    var genderMale = document.getElementById("male").checked;
    var genderFemale = document.getElementById("female").checked;
    var password = document.getElementById("password").value.trim();
    var confirmPassword = document.getElementById("confirmPassword").value.trim();

    if (firstName === "") {
        alert("First Name is required");
        return false;
    }
    if (lastName === "") {
        alert("Last Name is required");
        return false;
    }
    if (email === "") {
        alert("Email is required");
        return false;
    }
    if (!validateEmail(email)) {
        alert("Please enter a valid email address");
        return false;
    }
    if (mobile === "") {
        alert("Mobile number is required");
        return false;
    }
    if (!validateMobile(mobile)) {
        alert("Please enter a valid mobile number");
        return false;
    }
    if (address === "") {
        alert("Address is required");
        return false;
    }
    if (!genderMale && !genderFemale) {
        alert("Gender is required");
        return false;
    }
    if (password === "") {
        alert("Password is required");
        return false;
    }
    if (confirmPassword === "") {
        alert("Confirm Password is required");
        return false;
    }
    if (password !== confirmPassword) {
        alert("Passwords do not match");
        return false;
    }

    return true;
}

function validateEmail(email) {
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    return emailPattern.test(email);
}

function validateMobile(mobile) {
    var mobilePattern = /^[0-9]{10}$/;
    return mobilePattern.test(mobile);
}
