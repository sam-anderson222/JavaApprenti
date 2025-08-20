import { useState } from "react";
import UserContext from "../contexts/CreateUserContext";
import { useContext } from "react";
import { Navigate } from "react-router";
import SuccessMessage from "./Success";
import { attemptSignUp } from "../scripts/apicalls";

function SignUp() {
    const [error, setError] = useState(null);
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);

    // 'e' is is the automatically create event handler object.
    const handleSubmit = async (e) => {
        e.preventDefault()
        
        const formData = new FormData(e.target);
        const userSignUpData = {
            username: formData.get('_user'),
            userPassword: formData.get('_pass')
        };

        try {
            await attemptSignUp(userSignUpData);
            setShowSuccessMessage(true);
        } catch (err) {
            setError(err);
        }


    };

    if (showSuccessMessage) {
        return SuccessMessage("Account Successfully Created. Proceed to Login Page.")
    }

    return (
        <div className="container">
            <div className="row mb-5 justify-content-center w-80">
                <div className="col-md-5">

                        <h2>Sign Up</h2>
                        <form onSubmit={handleSubmit}>
                            <div className="row mt-5 mb-5 justify-content-center">
                                <label>Username: </label>
                                <input 
                                    name='_user'
                                    className="form-control"
                                    type="text"
                                />
                            </div>

                            <div className="row mb-5 justify-content-center">
                                <label>Password: </label>
                                <input 
                                    name='_pass'
                                    className="form-control"
                                    type="text"
                                />
                            </div>

                            <div className="row mb-5 justify-content-center">
                                {error && (
                                    <div className="alert alert-warning mt-2" role="alert">Error: Could Not Create Account. Please Try Again</div>
                                )}
                            </div>

                            <div className="row mb-5 justify-content-center">
                                <button type="submit" className="btn btn-primary">
                                    Sign Up
                                </button>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    )



}

export default SignUp;
