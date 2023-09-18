

console.log("working.....")
/*
function hello() {
	let vaccinate = document.getElementsByClassName("vaccinate");
	//vaccinate.innerHTML = "do vaccine";
	
	for(let i=0; i<vaccinate.length; i++) {
		vaccinate[i].innerHTML = "do vaccine";
	}
	
	console.log(vaccinate);
}*/


function clickButton() {
	console.log("delete")
}



/*
function check(user, OTP) {
	

                
}

*/

function vaccinateUser(user, OTP) {
    
                
    let h = prompt(`${user.name} put your OTP here!`);
    if (OTP == h) {
        let promise = new Promise((resolve, reject) => {

            setTimeout(() => {
                alert(`${user.name} Added to Queue`)
            }, 0)

            setTimeout(() => {
                alert(`Vaccinating ${user.vaccine}`)
            }, 5000)

            setTimeout(() => {
                alert(`${user.name} Vaccinated`)
            }, 10000)
            
        })
    }
    else if (h) {
        alert("OTP is not valid. Please enter valid OTP")
    }
}


function deleteUser(userId) {
    // Implement the delete logic here
    console.log("Deleting user with ID:", userId);
}







