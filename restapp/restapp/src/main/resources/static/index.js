let studentTable = document.getElementById("studentTable")
let courseTable = document.getElementById("courseTable")

//on page load
getStudents()
getCourses()

//Function for getting all students
function getStudents(){
    //Empty list on page
    studentTable.innerHTML = ""

    //Get all students from server
    fetch("http://localhost:8080/students")
    .then(response => response.json())
    .then(data =>
    {
        data.forEach(i => {
            var tr = document.createElement("tr")
            studentTable.appendChild(tr)

            var th = document.createElement("th")
            th.setAttribute('scope',"row")
            var studID = i.id
            th.innerHTML = "#" + studID
            studentTable.appendChild(th)

            var td1 = document.createElement("td")
            td1.innerHTML = i.name
            studentTable.appendChild(td1)

            var td2 = document.createElement("td")
            td2.innerHTML = i.group
            studentTable.appendChild(td2)

            var td3 = document.createElement("td")
            td3.innerHTML = i.email
            studentTable.appendChild(td3)

            i.courses.forEach(course => {              
                var li = document.createElement("div")
                li.className = "m-1 pl-2 pr-2 bg-light border"
                li.innerText =
                "#" + course.id + " - " + course.name
                studentTable.appendChild(li)

                var btn = document.createElement("button")
                btn.innerHTML = "Remove"
                btn.className = "btn btn-warning m-2 ml-3 btn-sm"
                btn.onclick = () => getRemoveConfirmation()
                
                function getRemoveConfirmation() {
                    var val = confirm('Remove student from course "' + course.name + '"?');
                    if( val == true ) {
                        function remStud() {
                            fetch("http://localhost:8080/students/"+i.id+"/"+course.id,
                            {
                                method: "DELETE",
                            })
                            location.reload();
                        }
                        remStud()
                        return true;
                    } else { 
                    return false;
                    }
                }
                li.appendChild(btn)    
            })

            var td5 = document.createElement("td")
            var btn = document.createElement("button")
            btn.innerHTML = "Delete student"
            btn.className = "btn btn-danger btn-sm"
            btn.onclick = () => getDeleteStudConfirmation()
                
            function getDeleteStudConfirmation() {
                var val = confirm('Delete student "' + i.name + '"?');
                if( val == true ) {
                    function delStud() {
                        fetch("http://localhost:8080/students/"+i.id,
                        {
                            method: "DELETE",
                        })
                        location.reload();
                    }
                    delStud()
                    return true;
                } else { 
                return false;
                }
            }
            td5.appendChild(btn) 
        studentTable.appendChild(td5)
        })
    })
}

//Function for getting all students
function getCourses(){
    //Empty list on page
    courseTable.innerHTML = ""

    //Get all students from server
    fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(data =>
    {
        data.forEach(i => {
            var tr = document.createElement("tr")
            courseTable.appendChild(tr)

            var th = document.createElement("th")
            th.setAttribute('scope',"row")
            th.innerHTML = "#" + i.id
            courseTable.appendChild(th)

            var td1 = document.createElement("td")
            td1.innerHTML = i.name
            courseTable.appendChild(td1)

            var td2 = document.createElement("td")
            td2.innerHTML = i.teacher
            courseTable.appendChild(td2)

            var td3 = document.createElement("td")
            td3.innerHTML = i.description
            courseTable.appendChild(td3)

            var td4 = document.createElement("td")
            var btn = document.createElement("button")
            btn.innerHTML = "Delete course"
            btn.className = "btn btn-danger btn-sm"
            btn.onclick = () => getDeleteCoursConfirmation()   

            function getDeleteCoursConfirmation() {
                var val = confirm('Delete course "' + i.name + '"?');
                if( val == true ) {
                    function delCours() {
                        fetch("http://localhost:8080/courses/"+i.id,
                        {
                            method: "DELETE",
                        })
                        location.reload();
                    }
                    delCours()
                    return true;
                } else { 
                return false;
                }
            }
            td4.appendChild(btn) 
            courseTable.appendChild(td4)
        })
    })
}