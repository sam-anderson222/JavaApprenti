import { createContext, useEffect, useState } from "react";
import UserContext from "./CreateUserContext";

export function UserProvider({ children }) {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [userData, setUserData] = useState(null);
    const [loading, setLoading] = useState(true);


    // Ensure data persistance on reload as useState variables are reset to default on page reload.
    useEffect(() => {
        const storedIsLoggedIn = sessionStorage.getItem("isLoggedIn") === "true";
        const storedUser = sessionStorage.getItem("user"); // stored as JSON as storedUser is an object.

        // if storedUser is not found in the session, null is returned, and since null is treated as false, this boolean works.
        if (storedIsLoggedIn && storedUser) {
            setIsLoggedIn(true);
            setUserData(JSON.parse(storedUser));
        }

        setLoading(false);
    }, []);

    // Called when the user successfully logs in to save the user's data in context.
    const login = (userData) => {
        setIsLoggedIn(true);
        setUserData(userData);

        sessionStorage.setItem("isLoggedIn", "true");
        sessionStorage.setItem("user", JSON.stringify(userData));
    }

    const logout = () => {
        setIsLoggedIn(false);
        setUserData(null);

        sessionStorage.removeItem("isLoggedIn");
        sessionStorage.removeItem("user");
    }

    if (loading) {
        return (
            <div className="container mt-4">
                <div className="d-flex justify-content-center">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
        )
    }

    // The context wraps it's children so the context variables can be used inside the children components.
    return (
        <UserContext.Provider value={{isLoggedIn, userData, login, logout}}>
            {children}
        </UserContext.Provider>
    )
}

