//http://localhost:8080/contact.html?name=&email=&subject=&message=

function validateForm() {
    try {
        var inputValue1 = document.getElementById("name").value;
        var inputValue2 = document.getElementById("email").value;
        var inputValue3 = document.getElementById("subject").value;
        var inputValue4 = document.getElementById("message").value;
        const data = { name: inputValue1, email: inputValue2, subject: inputValue3, message: inputValue4 };
        const address = '/contact';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if(data.result == "OK") {
                    console.log("Correo enviado");
                    document.getElementById("exito").style.visibility = "visible";
                    document.getElementById("fracaso").style.visibility = "hidden";
                } else {
                    alert("Error en el contacto");
                    document.getElementById("exito").style.visibility = "hidden";
                    document.getElementById("fracaso").style.visibility = "visible";
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
    }

document.getElementById("exito").style.visibility = "hidden";
document.getElementById("fracaso").style.visibility = "hidden";