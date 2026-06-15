let form = document.querySelector('form');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    let computer = {
        brand: document.getElementById('brand').value,
        model: document.getElementById('model').value
    };

    try {
        let response = await fetch('http://localhost:8008/computers/addComputer', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(computer)
        });

        let data = await response.text();
        console.log(data);

    } catch (error) {
        console.error("Xəta:", error);
    }
});