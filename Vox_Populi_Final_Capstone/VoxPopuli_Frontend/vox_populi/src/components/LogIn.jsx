import { useState } from "react";
import { attemptLogIn } from "../scripts/apicalls";
import UserContext from "../contexts/CreateUserContext";
import { useContext } from "react";
import { Navigate } from "react-router";

function LogIn() {
    const { login } = useContext(UserContext);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const [redirectUserToHome, setRedirectUserToHome] = useState(false);

    // 'e' is is the automatically create event handler object.
    const handleSubmit = async (e) => {
        e.preventDefault()
        
        const formData = new FormData(e.target);
        const userLogInData = {
            username: formData.get('_user'),
            userPassword: formData.get('_pass')
        };

        try {
            const user = await attemptLogIn(userLogInData);
            login(user);
            setRedirectUserToHome(true);
        } catch (err) {
            setShowErrorMessage(true);
        }


    };

    if (redirectUserToHome) {
        return (<Navigate to="/" />)
    }

    return (
        <div className="container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <label>Username: </label>
                <input 
                    name='_user'
                    type="text"
                />
                <label>Password: </label>
                <input 
                    name='_pass'
                    type="text"
                />
                {showErrorMessage && (
                    <div className="alert alert-info mt-2" role="alert">Error: Invalid Login Info.</div>
                )}

                <button type="submit" className="btn btn-primary">
                    Log In
                </button>
            </form>
        </div>
    )



}

export default LogIn;
