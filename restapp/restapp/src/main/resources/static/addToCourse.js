let studentList = document.getElementById("studentList")
let courseList = document.getElementById("courseList")

//Get list of students when page opened
getStudents()
getCourses()

//Form button action
document.getElementById("submitAnswer")
.addEventListener("click", e =>{
    e.preventDefault()

    //Create student object from form data
    let myStudent = document.getElementById("studentList").value
    let myCourse = document.getElementById("courseList").value

    if(myStudent == ""){
        alert("Please choose Student")
    } else if (myCourse == ""){
        alert("Please choose Course")
    } else {
        //Post JSON object to server and get updated student list from server
        fetch("http://localhost:8080/students/"+myStudent+"/"+myCourse,
            {
                method: "POST",
            })
        
        let z = document.getElementById("mainBar")
        z.innerHTML = "Student added to course, returning to main..";
        z.className = "mb-4 p-2 text-center font-weight-bold text-white bg-success"
        setTimeout(function(){
            window.location.href = 'index.html';
        }, 3000);
    }
})

//Function for getting all students
function getStudents(){

    //Get all students from server
    fetch("http://localhost:8080/students")
    .then(response => response.json())
    .then(studentData =>
    {
        //create option out of each course object
        studentData.forEach(i => {
            var opt = document.createElement("option")
            opt.setAttribute("value", i.id)
            var x = document.createTextNode("#"+i.id+" - "+i.name)
            opt.appendChild(x)
            studentList.appendChild(opt)
        })
    })
}

//Function for getting all courses
function getCourses(){

    //Get all students from server
    fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(data =>
    {
        console.log(data)

        //create option out of each course object
        data.forEach(i => {
            var opt = document.createElement("option")
            opt.setAttribute("value", i.id)
            var x = document.createTextNode("#"+i.id+" - "+i.name)
            opt.appendChild(x)
            courseList.appendChild(opt)
        })
    })
}