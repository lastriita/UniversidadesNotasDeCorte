function getStatus() {
            const address = '/status';
            fetch(address, {method: 'GET'})
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                });
        }

        function validateForm() {
            try {
                var inputValue1 = document.getElementById("inputEmail").value;
                var inputValue2 = document.getElementById("inputPassword").value;
                const data = { user: inputValue1, password: inputValue2 };
                const address = '/login2';
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
                            console.log("Authenticated");
                            document.location.href="/home.html";
                        } else {
                            alert("Credential not recognized");
                        }
                    });

            } catch (err) {
                console.error(err.message);
            }
            return false;
        }