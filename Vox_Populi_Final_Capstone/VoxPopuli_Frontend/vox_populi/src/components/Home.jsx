import { useContext } from "react";
import UserContext from "../contexts/CreateUserContext";

function Home() {
    const { isLoggedIn } = useContext(UserContext);


    if (isLoggedIn) {
        return (
            <div className="container">
                <p>Home page logged in.</p>
            </div>
        )
    }

    return (
        <div className="container">
                <p>Home page logged out.</p>
        </div>
    )
}

export default Home;