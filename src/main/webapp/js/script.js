function showSignUpForm() {
    document.getElementById('sign-up-page').style.display= "block";
    document.querySelector("main").style.pointerEvents = "none"
}

function hideSignUpPage() {
    document.getElementById('sign-up-page').style.display="none";
    document.querySelector("main").style.pointerEvents = "all"
}

function enableToEdit(event) {
    var parent = event.target.parentElement.parentElement;
    var elements = parent.getElementsByClassName("readonly");
    console.log(elements);
    console.log(elements.length)
    for (var i = 0; elements.length>0;) {
        let element = elements[i]
        element.removeAttribute("class", "readonly");
        element.setAttribute("class", "writable")
    }
    parent.querySelector("#save-button").removeAttribute("class", "disabled-button");
    event.target.setAttribute("class", "disabled-button");
    console.log(parent)
}

function disableToEdit() {
    var parent = event.target.parentElement.parentElement;
    var elements = parent.getElementsByClassName("writable");
    console.log(parent.length)
    for (var i = 0; elements.length>0;) {
        let element = elements[i]
        element.removeAttribute("class", "writable");
        element.setAttribute("class", "readonly")
    }
    parent.querySelector("#edit-button").removeAttribute("class", "disabled-button");
    event.target.setAttribute("class", "disabled-button");
    console.log(parent)
}







