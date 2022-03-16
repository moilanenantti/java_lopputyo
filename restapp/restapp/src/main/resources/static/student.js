//Form button action
document.getElementById("submitButton")
.addEventListener("click", e =>{
    e.preventDefault()

    //Create student object from form data
    let student = {
        name: document.getElementById("name").value,
        group: document.getElementById("group").value,
        email: document.getElementById("email").value,
        courses: []
    }

    if(document.getElementById("name").value == ""){
        alert("Please add Student name")
    } else if(document.getElementById("group").value == ""){
        alert("Please add Student group")
    } else if(document.getElementById("email").value == ""){
        alert("Please add Student email")
    } else {
        //Post JSON object to server and get updated student list from server
        fetch("http://localhost:8080/students",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(student)
        })
        
        let z = document.getElementById("mainBar")
        z.innerHTML = "Student added, returning to main..";
        z.className = "mb-4 p-2 text-center font-weight-bold text-white bg-success"
        setTimeout(function(){
            window.location.href = 'index.html';
        }, 3000);
    }
})