import { useParams } from "react-router";
import Loading from "./Loading";
import ErrorMessage from "./Error";
import { useContext, useEffect, useState } from "react";
import { getPoll } from "../scripts/apicalls";
import UserContext from "../contexts/CreateUserContext";

function ViewPoll() {
    const { id } = useParams();
    const { userData } = useContext(UserContext);

    const [poll, setPoll] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [selectedOption, setSelectedOption] = useState(null);


    // Attempt to parse id for poll.
    let pollId;
    try {
        pollId = parseInt(id);

        if (isNaN(pollId)) {
            throw new Error('Invalid ID format!')
        }
    } catch (error) {
        return ErrorMessage(error);
    }

    // Call API to get poll data.
    useEffect(() => {
        const loadPoll = async () => {
            try {
                const data = await getPoll(pollId);
                setPoll(data);
            } catch (err) {
                setError(err);
            } finally {
                setLoading(false);
            }
        }
     
        loadPoll();
    }, []); // empty array, only run effect on first load


    const handleSubmit = async (e) => {
            e.preventDefault()
            
            const formData = new FormData(e.target);
            const pollVote = {
                userId : userData.userId,
                pollId : poll.pollId,
                optionNumber : poll.options[selectedOption].optionNumber
            };
    
            try {
                console.log(pollVote)
            } catch (err) {
                setShowErrorMessage(true);
            }
    
    
        };


    if (loading) {
        return Loading();
    }

    if (error) {
        return ErrorMessage(error)
    }

    return (
        <div className="container mt-2">
        <div className="card shadow p-4">
            {/* Poll Title and Description */}
            <div className="row mb-5">
            <div className="col-12 text-center">
                <h2 className="fw-bold">{poll.pollTitle}</h2>
                <h4 className="text-muted">{poll.pollDescription}</h4>
            </div>
            </div>

            <form onSubmit={handleSubmit}>
            <div className="row justify-content-center">
                {poll.options.map((option, i) => {
                // Only render every 2 options as a row
                if (i % 2 !== 0) return null;

                const nextOption = poll.options[i + 1];

                return (
                    <div className="row mb-3 justify-content-center" key={i}>
                    {/* First Button */}
                    <div className={nextOption ? "col-md-5 mb-2" : "col-md-5 col-8 mb-2 fluid-vote-button"}>
                        <button
                        type="button"
                        className="btn btn-secondary poll-option-button w-100"
                        onClick={() => setSelectedOption(i)}
                        >
                        {option.optionName}
                        </button>
                    </div>

                    {/* Second Button (if exists) */}
                    {nextOption && (
                        <div className="col-md-5 mb-2 ">
                        <button
                            type="button"
                            className="btn btn-secondary poll-option-button w-100"
                            onClick={() => 
                                setSelectedOption(i + 1)}
                        >
                            {nextOption.optionName}
                        </button>
                        </div>
                    )}
                    </div>
                );
                })}

                {/* Submit Button */}
                <div className="col-12 col-md-6 mt-4 text-center">
                <button
                    type="submit"
                    className="btn btn-primary poll-vote-submit-button w-100"
                >
                    Submit Vote
                </button>
                </div>
            </div>
            </form>
        </div>
        </div>
    )
}

export default ViewPoll;