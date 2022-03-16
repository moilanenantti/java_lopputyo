//Form button action
document.getElementById("submitButton")
.addEventListener("click", e =>{
    e.preventDefault()

    //Create student object from form data
    let course = {
        name: document.getElementById("name").value,
        teacher: document.getElementById("teacher").value,
        description: document.getElementById("desc").value
    }

    if(document.getElementById("name").value == ""){
        alert("Please add Course name")
    } else if(document.getElementById("teacher").value == ""){
        alert("Please add Course teacher")
    } else if(document.getElementById("desc").value == ""){
        alert("Please add Course description")
    } else {
        //Post JSON object to server and get updated student list from server
        fetch("http://localhost:8080/courses",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(course)
        })

        let z = document.getElementById("mainBar")
        z.innerHTML = "Course added, returning to main.."
        z.className = "mb-4 p-2 text-center font-weight-bold text-white bg-success"
        setTimeout(function(){
            window.location.href = 'index.html';
        }, 3000);
    }
})