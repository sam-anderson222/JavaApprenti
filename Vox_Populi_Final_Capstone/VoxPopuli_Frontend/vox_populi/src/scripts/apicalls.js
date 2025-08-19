

export async function getAllPollOverviews() {
    // call the api
    const response = await fetch('http://localhost:8080/api/polls/overviews');

    if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`)
    }

    const data = await response.json();
    return data;
};

export async function getAllUsers() {
    // call the api
    const response = await fetch('http://localhost:8080/api/users');

    if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`)
    }

    const data = await response.json();
    return data;
};

export async function attemptLogIn(logInData) {
    const response = await fetch('http://localhost:8080/api/users/logIn', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(logInData)
    });

    if (response.ok) {
        const data = await response.json();
        return data;
    } else if (response.status == 401) {
        throw new Error('Invalid Login Details!');
    } else {
        throw new Error(`HTTP error! Status: ${response.status}`)
    }
}