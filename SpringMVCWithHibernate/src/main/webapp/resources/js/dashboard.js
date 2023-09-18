

console.log("working.....")

function hello() {
	let vaccinate = document.getElementsByClassName("vaccinate");
	//vaccinate.innerHTML = "do vaccine";
	
	for(let i=0; i<vaccinate.length; i++) {
		vaccinate[i].innerHTML = "do vaccine";
	}
	
	console.log(vaccinate);
}


function clickButton() {
	console.log("delete")
}



/*
function check(user, OTP) {
	

	console.log(user, OTP);
                
                /*
                let h = prompt(`${user.getName()} put your OTP here!`)
                //console.log(OTP.innerText)
                //console.log(h)
                if (OTP == h) {
                    let promise = new Promise((resolve, reject) => {

                        setTimeout(() => {
                            alert(`${user.getName()} Added to Queue`)
                        }, 0)

                        setTimeout(() => {
                            alert(`Vaccinating ${user.getVaccine()}`)
                        }, 5000)

                        setTimeout(() => {
                            alert(`${user.getName()} Vaccinated`)
                        }, 10000)
                        
                    })
                }
                else if (h) {
                    alert("OTP is not valid. Please enter valid OTP")
                }
                
}

*/

function vaccinateUser(element, randomValue) {
    var userJson = element.getAttribute('data-user');
    var user = JSON.parse(userJson);
    
    // Now you can access the properties of the user object
    console.log("ID:", user.id);
    console.log("Name:", user.name);
    console.log("Age:", user.age);
    // ... and so on

    // Access randomValue as well
    console.log("Random Value:", randomValue);
}


function deleteUser(userId) {
    // Implement the delete logic here
    console.log("Deleting user with ID:", userId);
}







